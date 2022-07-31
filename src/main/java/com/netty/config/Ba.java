//package com.netty.config;
//
//import com.spire.pdf.PdfDocument;
//import org.apache.commons.logging.LogFactory;
//import org.apache.poi.xwpf.usermodel.XWPFDocument;
//import sun.rmi.runtime.Log;
//
//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
//import java.io.*;
//
//public class Ba {
//    public static String path = "C:\\Users\\wrn\\Desktop\\WordToPDF.pdf";
//
//    public static void main(String[] args) {
//        aspPdfToJpg(path,"C:\\Users\\wrn\\Desktop\\");
//    }
//
//
//        public static int aspPdfToJpg(String sourPath ,String savePath){
//            int flag = 0;
//            PdfDocument pdfDocument = new PdfDocument();
//            pdfDocument.loadFromFile(sourPath);
//            BufferedImage bufferedImage = null;
//            try{
//                for (int i=0;i<pdfDocument.getPages().getCount();i++){
//                    bufferedImage = pdfDocument.saveAsImage(i);
//                    bufferedImage = bufferedImage.getSubimage(bufferedImage.getMinX(),15,bufferedImage.getWidth(),bufferedImage.getHeight()-15);
//                    File saveFile = new File(savePath+i+".jpg");
//                    if(!saveFile.exists()){
//                        saveFile.mkdirs();
//                    }
//                    ImageIO.write(bufferedImage,"jpg",saveFile);
//                    bufferedImage.flush();
//                }
//                flag = 1;
//            }catch (Exception e){
//                e.printStackTrace();
//            }finally{
//                return flag;
//            }
//    }
//}
