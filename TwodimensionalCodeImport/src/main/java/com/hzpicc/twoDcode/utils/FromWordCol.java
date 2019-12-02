package com.hzpicc.twoDcode.utils;


import com.hzpicc.twoDcode.pojo.WordCols;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.io.CharArrayReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.LineNumberReader;
import java.math.BigDecimal;
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

    public static String[][] switchArray(String[] nums,Integer rows ,Integer cols){
        String[][] numArray=new String[rows][cols];
        int length=nums.length;
        for(int i=0;i<length;i++){
            String num=nums[i];
            //一维数组nums中的第index个除三取余数为二维数组的行
            int a=i / cols;
            //一维数组nums中的第index个除三取模为二维数组的列
            int b=i % cols;
            numArray[a][b]=num;
        }
        return numArray;
    }

    /**
     *
     * @param fout      输出文件路径;注意必须执行的列   必须存在数据(akc回答:不一定)
     */
    public void out2Excel(List<WordCols> list ,String fout){
        //修改excel表中的某列的数据
        //from poi的写入excel
        Integer nums=1;
        for (WordCols words:list) {
            nums++;
            ExcelOutput.writeSpecifiedCell(fout, String.valueOf("A"+nums),words.getIdcode());
            ExcelOutput.writeSpecifiedCell(fout, String.valueOf("C"+nums),words.getShiyongdanwei());
            ExcelOutput.writeSpecifiedCell(fout, String.valueOf("B"+nums),words.getShebeimingcheng());
            ExcelOutput.writeSpecifiedCell(fout, String.valueOf("G"+nums),"在用");
            ExcelOutput.writeSpecifiedCell(fout, String.valueOf("S"+nums),words.getPosition());
            ExcelOutput.writeSpecifiedCell(fout, String.valueOf("AA"+nums),words.getWeibaodanwei());
            ExcelOutput.writeSpecifiedCell(fout, String.valueOf("AJ"+nums),"浙江省");
            ExcelOutput.writeSpecifiedCell(fout, String.valueOf("AK"+nums),"杭州市");
            ExcelOutput.writeSpecifiedCell(fout, String.valueOf("AL"+nums),"拱墅区");
            ExcelOutput.writeSpecifiedCell(fout, String.valueOf("AR"+nums),words.getNianjianshijian());
        }
//        for (int i = outStartRow; i <=endRow; i++) {
//
//        }
    }

    public static boolean isNumeric(String str) {
        String bigStr;
        try {
            bigStr = new BigDecimal(str).toString();
        } catch (Exception e) {
            return false;//异常 说明包含非数字。
        }
        return true;
    }


}
