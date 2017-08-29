package com.hdsx.hmglyh.gis.card.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ddf.EscherClientAnchorRecord;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.hssf.record.EscherAggregate;
import org.apache.poi.hssf.usermodel.HSSFPictureData;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class PictureUtil {
	
	public static List<MyPictureData> getAllPictures(HSSFWorkbook workbook) {  
        List<MyPictureData> list = new ArrayList<MyPictureData>();  
  
        List<HSSFPictureData> pictureList = workbook.getAllPictures();  
        List<ClientAnchorInfo> clientAnchorRecords = getClientAnchorRecords(workbook);  
        
//        System.out.println(pictureList.size()+"==="+clientAnchorRecords.size());
        
        if (pictureList.size() != clientAnchorRecords.size()) {  
            throw new RuntimeException("解析文件中的图片信息出错，找到的图片数量和图片位置信息数量不匹配");  
        }  
          
        for (int i = 0; i < pictureList.size(); i++) {  
            HSSFPictureData pictureData = pictureList.get(i);  
            ClientAnchorInfo anchor = clientAnchorRecords.get(i);  
            HSSFSheet sheet = anchor.sheet;  
            EscherClientAnchorRecord clientAnchorRecord = anchor.clientAnchorRecord;  
            list.add(new MyPictureData(workbook, sheet, pictureData, clientAnchorRecord));  
        }  
          
        return list ;  
    }  
  
    private static class ClientAnchorInfo {  
        public HSSFSheet sheet;  
        public EscherClientAnchorRecord clientAnchorRecord;  
          
        public ClientAnchorInfo(HSSFSheet sheet, EscherClientAnchorRecord clientAnchorRecord) {  
            super();  
            this.sheet = sheet;  
            this.clientAnchorRecord = clientAnchorRecord;  
        }  
    }  
    private static List<ClientAnchorInfo> getClientAnchorRecords(HSSFWorkbook workbook) {  
        List<ClientAnchorInfo> list = new ArrayList<ClientAnchorInfo>();  
          
        EscherAggregate drawingAggregate = null;  
        HSSFSheet sheet = null;  
        List<EscherRecord> recordList = null;  
        Iterator<EscherRecord> recordIter = null;  
        int numSheets = workbook.getNumberOfSheets();  
        for(int i = 0; i < numSheets; i++) {  
            sheet = workbook.getSheetAt(i);  
            drawingAggregate = sheet.getDrawingEscherAggregate();  
            if(drawingAggregate != null) {  
                recordList = drawingAggregate.getEscherRecords();  
                recordIter = recordList.iterator();  
                while(recordIter.hasNext()) {  
                    getClientAnchorRecords(sheet, recordIter.next(), 1, list);  
                }  
            }  
        }  
          
        return list;  
    }  
  
    private static void getClientAnchorRecords(HSSFSheet sheet, EscherRecord escherRecord, int level, List<ClientAnchorInfo> list) {  
        List<EscherRecord> recordList = null;  
        Iterator<EscherRecord> recordIter = null;  
        EscherRecord childRecord = null;  
        recordList = escherRecord.getChildRecords();  
        recordIter = recordList.iterator();  
        while(recordIter.hasNext()) {  
            childRecord = recordIter.next();  
            if(childRecord instanceof EscherClientAnchorRecord) {  
                ClientAnchorInfo e = new ClientAnchorInfo(sheet, (EscherClientAnchorRecord) childRecord);  
                list.add(e);  
            }  
            if(childRecord.getChildRecords().size() > 0) {  
                getClientAnchorRecords(sheet, childRecord, level+1, list);  
            }  
        }  
    }  
	
}
