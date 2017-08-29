package com.hdsx.hmglyh.gis.card.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.struts2.ServletActionContext;

public class POIReadExcelToHtml03 {
	//测试
	public static void main(String[] args) {

		try {
			POIReadExcelToHtml03 poire = new POIReadExcelToHtml03();

			String path = "D://a.xls";

			File sourcefile = new File(path);

			InputStream is = new FileInputStream(sourcefile);

			//POIFSFileSystem fs = new POIFSFileSystem(is);

			HSSFWorkbook wb = new HSSFWorkbook(is);
			String htmlExcel = poire.getExcelInfo(wb);
			System.out.println(htmlExcel);

			is.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	public static String getHtmlExcel(HSSFWorkbook wb){
		try {
			String htmlPage = getExcelInfo(wb);
			return htmlPage;
		}  catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public static String getExcelInfo(HSSFWorkbook wb) throws Exception {
		List<MyPictureData> list = PictureUtil.getAllPictures(wb);
		
		for(MyPictureData picture:list){
			//将图片存到一个临时文件中
			String fileName = UUID.randomUUID().toString()+"."+picture.getPictureData().suggestFileExtension();
			String url = ServletActionContext.getRequest().getRealPath("/upload")+"\\test\\"+fileName;
//			String url = "D:\\"+UUID.randomUUID().toString()+"."+picture.getPictureData().suggestFileExtension();
			picture.setUrl("../../../upload/test/"+fileName);
			FileOutputStream out = new FileOutputStream(url);
			out.write(picture.getPictureData().getData());
			out.close();
			System.out.println(url);
		}
		
		/**
		 * 获取非图片的内容
		 */
		StringBuffer sb = new StringBuffer();

		Sheet sheet = wb.getSheetAt(0);

		int lastRowNum = sheet.getLastRowNum();

		Map<String, String> map[] = getRowSpanColSpanMap(sheet);

		sb.append("<table style='border-collapse:collapse;' align='center'>");

		HSSFRow row = null;

		HSSFCell cell = null;

		// System.out.println(sheet.getPhysicalNumberOfRows());
		for (int rowNum = sheet.getFirstRowNum(); rowNum <= lastRowNum; rowNum++) {

			row = (HSSFRow) sheet.getRow(rowNum);

			if (row == null) {

				sb.append("<tr><td > &nbsp;</td></tr>");

				continue;
			}

			sb.append("<tr>");

			int lastColNum = row.getLastCellNum();

			for (int colNum = 0; colNum < lastColNum; colNum++) {

				cell = row.getCell(colNum);

				if (cell == null) {

					sb.append("<td>&nbsp;</td>");

					continue;
				}

				String stringValue = getCellValue(cell);
				
				int columnWidth = sheet.getColumnWidth(cell.getColumnIndex())/32 ;

				if (map[0].containsKey(rowNum + "," + colNum)) {

					String pointString = map[0].get(rowNum + "," + colNum);

					map[0].remove(rowNum + "," + colNum);

					int bottomeRow = Integer.valueOf(pointString.split(",")[0]);

					int bottomeCol = Integer.valueOf(pointString.split(",")[1]);

					int rowSpan = bottomeRow - rowNum + 1;

					int colSpan = bottomeCol - colNum + 1;

					sb.append("<td rowspan= '" + rowSpan + "' colspan= '"
							+ colSpan + "' ");
					
					columnWidth = getTdWidth(sheet,colNum,bottomeCol);
					
					for(MyPictureData p:list){
						int centerRow = p.getRow0();
						int centerCol = p.getCol0();
						if(centerRow>=rowNum && centerRow<=bottomeRow && centerCol>=colNum && centerCol<=bottomeCol){
							stringValue += "<br/><img width='90%' src='"+p.getUrl()+"'/>";
						}
					}

				} else if (map[1].containsKey(rowNum + "," + colNum)) {

					map[1].remove(rowNum + "," + colNum);

					continue;

				} else {

					sb.append("<td ");
				}

				HSSFCellStyle cellStyle = cell.getCellStyle();

				if (cellStyle != null) {

					short alignment = cellStyle.getAlignment();

					sb.append("align='" + convertAlignToHtml(alignment) + "' ");

					short verticalAlignment = cellStyle.getVerticalAlignment();

					sb.append("valign='"
							+ convertVerticalAlignToHtml(verticalAlignment)
							+ "' ");

					HSSFFont hf = cellStyle.getFont(wb);

					short boldWeight = hf.getBoldweight();

					short fontColor = hf.getColor();

					sb.append("style='");

					HSSFPalette palette = wb.getCustomPalette(); // 类HSSFPalette用于求的颜色的国际标准形式

					HSSFColor hc = palette.getColor(fontColor);

					sb.append("font-weight:" + boldWeight + ";"); // 字体加粗

					// System.out.println(hf.getFontHeight());

					sb.append("font-size: " + hf.getFontHeight() / 2.5 + "%;"); // 字体大小

					String fontColorStr = convertToStardColor(hc);

					if (fontColorStr != null && !"".equals(fontColorStr.trim())) {

						sb.append("color:" + fontColorStr + ";"); // 字体颜色
					}

					sb.append("width:" + columnWidth + "px;");
					
//					System.out.println(sheet.getColumnWidth(cell.getColumnIndex())+"=="+cellStyle);
					
					short bgColor = cellStyle.getFillForegroundColor();

					hc = palette.getColor(bgColor);

					String bgColorStr = convertToStardColor(hc);

					if (bgColorStr != null && !"".equals(bgColorStr.trim())) {

						sb.append("background-color:" + bgColorStr + ";"); // 背景颜色
					}
					/*
					short borderColor = cellStyle.getBottomBorderColor();

					hc = palette.getColor(borderColor);

					String borderColorStr = convertToStardColor(hc);

					if (borderColorStr != null
							&& !"".equals(borderColorStr.trim())) {

						sb.append("border-color:" + borderColorStr + ";"); // 边框颜色
					}
					*/

					sb.append( getBorderStyle(palette,0,cellStyle.getBorderTop(),cellStyle.getTopBorderColor()));
				     sb.append( getBorderStyle(palette,1,cellStyle.getBorderRight(),cellStyle.getRightBorderColor()));
				     sb.append( getBorderStyle(palette,3,cellStyle.getBorderLeft(),cellStyle.getLeftBorderColor()));
				     sb.append( getBorderStyle(palette,2,cellStyle.getBorderBottom(),cellStyle.getBottomBorderColor()));
				     
					// boolean borderBoolean = cellStyle.getWrapText();
					//     
					// if(borderBoolean){
					// sb.append("border-style: inset;");
					// }

					sb.append("' ");
				}

				sb.append(">");

				if (stringValue == null || "".equals(stringValue.trim())) {

					sb.append(" &nbsp; ");
				} else {

					// 将ascii码为160的空格转换为html下的空格（&nbsp;）
					sb.append(stringValue.replace(String.valueOf((char) 160),
							"&nbsp;"));

				}

				sb.append("</td>");

			}

			sb.append("</tr>");
		}

		sb.append("</table>");

		return sb.toString();
	}

	@SuppressWarnings("unchecked")
	private static Map<String, String>[] getRowSpanColSpanMap(Sheet sheet) {

		Map<String, String> map0 = new HashMap<String, String>();
		Map<String, String> map1 = new HashMap<String, String>();

		int mergedNum = sheet.getNumMergedRegions();

		CellRangeAddress range = null;

		for (int i = 0; i < mergedNum; i++) {

			range = sheet.getMergedRegion(i);

			int topRow = range.getFirstRow();

			int topCol = range.getFirstColumn();

			int bottomRow = range.getLastRow();

			int bottomCol = range.getLastColumn();

			map0.put(topRow + "," + topCol, bottomRow + "," + bottomCol);

			// System.out.println(topRow + "," + topCol + "," + bottomRow + ","
			// + bottomCol);

			int tempRow = topRow;

			while (tempRow <= bottomRow) {

				int tempCol = topCol;

				while (tempCol <= bottomCol) {

					map1.put(tempRow + "," + tempCol, "");

					tempCol++;
				}

				tempRow++;
			}

			map1.remove(topRow + "," + topCol);

		}

		Map[] map = { map0, map1 };

		return map;
	}

	private static String convertAlignToHtml(short alignment) {

		String align = "left";

		switch (alignment) {

		case HSSFCellStyle.ALIGN_LEFT:
			align = "left";
			break;
		case HSSFCellStyle.ALIGN_CENTER:
			align = "center";
			break;
		case HSSFCellStyle.ALIGN_RIGHT:
			align = "right";
			break;

		default:
			break;
		}

		return align;
	}

	private static String convertVerticalAlignToHtml(short verticalAlignment) {

		String valign = "middle";

		switch (verticalAlignment) {

		case HSSFCellStyle.VERTICAL_BOTTOM:
			valign = "bottom";
			break;
		case HSSFCellStyle.VERTICAL_CENTER:
			valign = "center";
			break;
		case HSSFCellStyle.VERTICAL_TOP:
			valign = "top";
			break;
		default:
			break;
		}

		return valign;
	}

	private static String convertToStardColor(HSSFColor hc) {

		StringBuffer sb = new StringBuffer("");

		if (hc != null) {

			if (HSSFColor.AUTOMATIC.index == hc.getIndex()) {

				return null;
			}

			sb.append("#");

			for (int i = 0; i < hc.getTriplet().length; i++) {

				sb.append(fillWithZero(Integer.toHexString(hc
								.getTriplet()[i])));
			}
		}

		return sb.toString();
	}

	private static String fillWithZero(String str) {

		if (str != null && str.length() < 2) {

			return "0" + str;
		}
		return str;
	}

	private static String getCellValue(HSSFCell cell) {

		switch (cell.getCellType()) {

		case HSSFCell.CELL_TYPE_NUMERIC:
			//日期格式，当日期中含有年月日时isCellDateFormatted不好使，用以下方法
			
			if(isDateCell(cell)){
				Date cellDate = cell.getDateCellValue();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
				System.out.println(sdf.format(cellDate));
				return sdf.format(cellDate);
			}
			
			//DecimalFormat format = new DecimalFormat("#0.##");
			//return format.format(cell.getNumericCellValue());
			// return String.valueOf(cell.getNumericCellValue());
			return NumberToTextConverter.toText(cell.getNumericCellValue());

		case HSSFCell.CELL_TYPE_STRING:

			return cell.getStringCellValue();

			// case HSSFCell.CELL_TYPE_FORMULA:
			//    
			// return cell.getCellFormula();

		default:
			return "";
		}
	}
	
	 static String[] bordesr={"border-top:","border-right:","border-bottom:","border-left:"};
	 static String[] borderStyles={"solid ","solid ","solid ","solid ","solid ","solid ","solid ","solid ","solid ","solid","solid","solid","solid","solid"};
	 //tring[] borderClors={}; 
	 private static  String getBorderStyle(  HSSFPalette palette ,int b,short s, short t){
	     if(s==0)return  bordesr[b]+borderStyles[s]+"#d0d7e5 1px;";;
	     String borderColorStr = convertToStardColor( palette.getColor(t));
	     borderColorStr=borderColorStr==null|| borderColorStr.length()<1?"#000000":borderColorStr;
//	     System.out.println( bordesr[b]+borderStyles[s]+borderColorStr+" 1px; "+t);
		 
		 return bordesr[b]+borderStyles[s]+borderColorStr+" 1px;";
	 }
	 
	private static int getTdWidth(Sheet sheet, int startCol, int endCol) {
		 int tdwidth = 0;
		 for (int i = startCol; i <= endCol; i++) {
			 int tempwidth = sheet.getColumnWidth(i) / 32;
			 tdwidth = tdwidth + tempwidth;
		 }
		 return tdwidth;
	}
	
	private static boolean isDateCell(Cell cell){
		if(cell == null)
			return false;
		
		boolean bDate = false;
		
		double d = cell.getNumericCellValue();
		if(DateUtil.isValidExcelDate(d)){
			CellStyle style = cell.getCellStyle();
			if(style == null)
				return false;
			int i = style.getDataFormat();
			System.out.println(style.getDataFormatString()+"=="+cell.getNumericCellValue());
			String f = style.getDataFormatString();
			if(f == null || f.length() == 0)
				return false;
			bDate = DateUtil.isADateFormat(i, f.replaceAll("[\"|\']","").replaceAll("[年|月|日|时|分|秒|毫秒|微秒]", ""));
		}
		
		return bDate;
		
	}
}