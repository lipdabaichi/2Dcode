package com.hzpicc.twoDcode;

import com.hzpicc.twoDcode.pojo.WordCols;
import com.hzpicc.twoDcode.utils.FromWordCol;
import com.hzpicc.twoDcode.utils.Start;
import com.sun.org.apache.xerces.internal.xs.StringList;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
public class Run {
    public static void main(String[] args) throws IOException {
        Start test = new Start();
            //可自行修改在控制台输入
        String filePath = "C:\\Users\\AKC\\Desktop\\需要的资料\\tmp副本\\电梯养老综合保险合同1011-双甲方（20191105修改）.docx";
//        String filePath = "C:\Users\AKC\Desktop\需要的资料\tmp副本\\电梯养老综合保险合同（2019住宅8.1版）.docx";
        String start = "附件二、丙方维修资质证书、维保员身份证复印件及特种设备作业人员证。";
        String end = "合计";
        String init1 = test.getInfo(filePath, start, end);

        String init2 = init1.substring(init1.indexOf("1"));
        System.out.println(init2);
        //String init1中的行数
       Integer strRows = Integer.valueOf((int) (FromWordCol.getLineNumberByIo(init2) - 1)) ;

        System.out.println("_____________________________________________________________________________________________________________________________________________________________");
        init2 = init2.replaceAll("\\s+", "--");
//        System.out.println(init2.replaceAll( "\\s+", "--" ));
        String[] s = init2.split("--");

        //String 初始init1中 每行的列数
        double xiangshang = Math.ceil((double)s.length / strRows) ;//10列   36行   s[360]
        System.out.println("<<<<<<<<<"+xiangshang);
        Integer strCols=(int)xiangshang;
        System.out.println(">>>>>>>>>>"+strCols);

        List<WordCols> list = new ArrayList<>();
//        System.out.println(">>>>"+s.length);
        //一位数组转换成二维数组
        String[][] ss = FromWordCol.switchArray(s, strRows, strCols);

        for (int i = 0; i < strRows; i++) {
            WordCols wordCols = new WordCols();
            for (int j = 0; j < strCols; j++) {

                //模糊判断
                try {
                    if (ss[i][j].length() == 20) {
                        wordCols.setIdcode(ss[i][j]);
                    } else if (ss[i][j].contains("幢") || s[j].contains("-")) {
                        wordCols.setPosition(ss[i][j]);
                    } else if (ss[i][j].contains("奥") || s[j].contains("通力")) {
                        wordCols.setWeibaodanwei(ss[i][j]);
                    } else if (ss[i][j].contains("物业")) {
                        wordCols.setShiyongdanwei(ss[i][j]);
                    }
                    //else if (s[j].contains("小区")){
//                    wordCols.setShebeimingcheng(s[j]);
//                }
                } catch (NullPointerException e) {
                    return;
                }
            }
            list.add(wordCols);
            System.out.println(list);
        }




    }
}
