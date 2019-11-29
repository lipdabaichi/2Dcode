package com.hzpicc.twoDcode;

import com.hzpicc.twoDcode.pojo.WordCols;
import com.hzpicc.twoDcode.utils.FromWordCol;
import com.hzpicc.twoDcode.utils.Start;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class Run {
    public static void main(String[] args) throws IOException {
        Start test = new Start();
            //可自行修改在控制台输入
        String filePath = "C:\\Users\\Administrator\\Desktop\\tmp副本\\电梯养老综合保险合同1011-双甲方（20191105修改）.docx";
//        String filePath = "C:\\Users\\Administrator\\Desktop\\tmp副本\\电梯养老综合保险合同（2019住宅8.1版）.docx";
        String start = "附件二、丙方维修资质证书、维保员身份证复印件及特种设备作业人员证。";
        String end = "合计";
        String init1 = test.getInfo(filePath, start, end);

        String init2 = init1.substring(init1.indexOf("1"));
        System.out.println(init2);
        //String init1中的行数
       Integer strRows = Integer.valueOf((int) (FromWordCol.getLineNumberByIo(init2) - 1)) ;

//        for (int i = 1; i <= FromWordCol.getLineNumberByIo(init2)-1; i++) {
//
//            if (i == 1) {
//                System.out.println("第一行"+s);
//            }
//
//        }
        System.out.println("_____________________________________________________________________________________________________________________________________________________________");
        init2 = init2.replaceAll("\\s+", "--");
//        System.out.println(init2.replaceAll( "\\s+", "--" ));
        String[] s = init2.split("--");

        //String 初始init1中 每行的列数
        Integer strCols = s.length / strRows;

        List<WordCols> list = new ArrayList<>();

        for (int i = 0; i < strRows; i++) {
            for (int j = 0; j < strCols; j++) {
                WordCols wordCols = new WordCols();
                
                wordCols.setIdcode();
                wordCols.setPosition();
                wordCols.setWeibaodanwei();
                wordCols.setShiyongdanwei();
                list.add(wordCols);
            }
        }




    }
}
