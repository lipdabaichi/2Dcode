package com.hzpicc.twoDcode.utils;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.io.CharArrayReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class FromWordCol {

    //采用有序Map
    LinkedHashMap<Integer,String> result = new LinkedHashMap<>();
    //用来存取Map
    List list = new ArrayList();

    public static void testWord(String filePath){
        try{
            FileInputStream in = new FileInputStream(filePath);//载入文档 //如果是office2007  docx格式
            if(filePath.toLowerCase().endsWith("docx")){
                //word 2007 图片不会被读取， 表格中的数据会被放在字符串的最后
                XWPFDocument xwpf = new XWPFDocument(in);//得到word文档的信息
//             List<XWPFParagraph> listParagraphs = xwpf.getParagraphs();//得到段落信息
                Iterator<XWPFTable> it = xwpf.getTablesIterator();//得到word中的表格

                while(it.hasNext()){
                    XWPFTable table = it.next();
                    List<XWPFTableRow> rows=table.getRows();
                    //读取每一行数据
                    for (int i = 1; i < rows.size(); i++) {
                        XWPFTableRow  row = rows.get(i);
                        //读取每一列数据
                        List<XWPFTableCell> cells = row.getTableCells();
                        for (int j = 0; j < cells.size(); j++) {
                            XWPFTableCell cell=cells.get(j);

                            //输出当前的单元格的数据
                            System.out.println(cell.getText());
                        }
                    }

                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**   得到字符串中的行数  使用io*/
    public static long getLineNumberByIo(String target) throws IOException {

        LineNumberReader lnr = new LineNumberReader(new CharArrayReader(target.toCharArray()));
        lnr.skip(Long.MAX_VALUE);
        //System.out.println(lnr.getLineNumber() + 1);
        lnr.close();
        return lnr.getLineNumber() + 1;
    }

}
