package com.netty.config;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

import static com.netty.config.ReplaceWord.changeValue;
import static com.netty.config.ReplaceWord.checkText;

public class TestDoc {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\wrn\\Desktop\\ccc.doc";
        Map<String, String> data = new HashMap<>();
        Map<String, Object> pic = new HashMap<>();

        pic.put("${carpicture}", "Files/sign.png");
        pic.put("${licensecopy}", "Files/sign.png");
        data.put("${applyno}", "112312321");
        data.put("${AA}", "北京");
        data.put("${number}", "gou");
        data.put("${account}", "1431432432");
        data.put("${bank}", "华夏银行");
        data.put("${no}", "12222");
        data.put("${no3}", "456");
        data.put("${no4}", "45645645645654654664556465546");
        data.put("${no6}", "122246554666465466454654564564565464564565464564545454564565464562");
        data.put("${year}", "2022");
        data.put("${month}", "1");
        data.put("${day}", "12");
        data.put("${A}", "啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");
        pic.put("${sing01}", "Files/sign.png");
        pic.put("${sing02}", "Files/sign.png");
        System.out.println(pic.containsKey("${carpicture}"));
        // 列表(List)是对象的有序集合
        List<List<String[]>> tabledataList = new ArrayList<>();
        testWord(path, data);

    }

    public static void testWord(String wordPath, Map<String, String> textMap) throws IOException {
        FileInputStream f1 = new FileInputStream(wordPath);
        POIFSFileSystem pfs = new POIFSFileSystem(f1);
        HWPFDocument hwpf = new HWPFDocument(pfs);//用poifsfileSystem初始化hwpf
        Range range = hwpf.getRange();//获取全文
        for (Map.Entry<String, String> entry : textMap.entrySet()) {

            range.replaceText(entry.getKey(), String.valueOf(entry.getValue()));
            System.out.println(entry.getKey() + "填充为" + entry.getValue());
        }

        // 使用try和catch关键字捕获异常
        try (OutputStream out = new FileOutputStream("C:\\Users\\wrn\\Desktop\\" + "填充.doc")) {
            hwpf.write(out);
            out.flush();
            out.close();
        }


        f1.close();
    }

}
