
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.gis.card.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.apache.struts2.ServletActionContext;
import org.w3c.dom.Document;

/**  
 *  
 * @author Baiyy
 * @created 2015年12月29日 下午2:10:30 
 */

public class Word2Html {
//	public static void main(String argv[]) {  
//        try {  
//            convert2Html("D://1.doc","D://1.html");  
//        } catch (Exception e) {  
//            e.printStackTrace();  
//        }  
//    }  
  
    public static void writeFile(String content, String path) {  
        FileOutputStream fos = null;  
        BufferedWriter bw = null;  
        try {
        	String url = ServletActionContext.getRequest().getRealPath("/upload")+"\\test\\"+path;
            File file = new File(url);  
            fos = new FileOutputStream(file);  
            bw = new BufferedWriter(new OutputStreamWriter(fos,"UTF-8"));  
            bw.write(content);  
        } catch (FileNotFoundException fnfe) {  
            fnfe.printStackTrace();  
        } catch (IOException ioe) {  
            ioe.printStackTrace();  
        } finally {  
            try {  
                if (bw != null)  
                    bw.close();  
                if (fos != null)  
                    fos.close();  
            } catch (IOException ie) {  
            }  
        }  
    }  
  
    public static String convert2Html(InputStream is, String outPutFile)  
            throws TransformerException, IOException,  
            ParserConfigurationException {  
        HWPFDocument wordDocument = new HWPFDocument(is);//WordToHtmlUtils.loadDoc(new FileInputStream(inputFile));  
        WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(  
                DocumentBuilderFactory.newInstance().newDocumentBuilder()  
                        .newDocument());  
         wordToHtmlConverter.setPicturesManager( new PicturesManager()  
         {  
             public String savePicture( byte[] content,  
                     PictureType pictureType, String suggestedName,  
                     float widthInches, float heightInches )  
             {  
                 return suggestedName;  
             }  
         } );  
        wordToHtmlConverter.processDocument(wordDocument);  
        //save pictures  
        List pics=wordDocument.getPicturesTable().getAllPictures();  
        if(pics!=null){  
            for(int i=0;i<pics.size();i++){  
                Picture pic = (Picture)pics.get(i);  
                System.out.println();  
                try {  
                	String url = ServletActionContext.getRequest().getRealPath("/upload")+"\\test\\"+pic.suggestFullFileName();
                    pic.writeImageContent(new FileOutputStream(url));  
                } catch (FileNotFoundException e) {  
                    e.printStackTrace();  
                }    
            }  
        }  
        Document htmlDocument = wordToHtmlConverter.getDocument();  
//        Range range = wordDocument.getRange();
//        TableIterator tableIter = new TableIterator(range);
//        while (tableIter.hasNext()) {  
//            Table table = tableIter.next();
//            
//        }
        
        ByteArrayOutputStream out = new ByteArrayOutputStream();  
        DOMSource domSource = new DOMSource(htmlDocument);  
        StreamResult streamResult = new StreamResult(out);  
  
        TransformerFactory tf = TransformerFactory.newInstance();  
        Transformer serializer = tf.newTransformer();  
        serializer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");  
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");  
        serializer.setOutputProperty(OutputKeys.METHOD, "html");  
        serializer.transform(domSource, streamResult);  
        out.close();  
        writeFile(out.toString("UTF-8"), outPutFile); 
        return "<iframe src='"+"../../../upload/test/"+outPutFile+"' width='100%' height='96%'></iframe>";
    }   
}
