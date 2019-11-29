package com.hzpicc.twoDcode.utils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.regex.Pattern;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
/**
 * 读取Word文档中指定位置的表格数据或文本内容
 * @author yigai
 *
 */
public class Start {
    /**
     *
     * @param filePath 文档路径
     * @param start 指定位置开始读取表格数据的该位置上的字符串
     * @param end 指定位置开始结束读取表格数据的该位置上的字符串
     * @throws IOException
     */
    public String getInfo(String filePath,String start,String end) throws IOException{
        //载入文件
        FileInputStream fis = new FileInputStream(filePath);
        //判断文档格式
        if(filePath.endsWith(".docx")){
            //处理.docx格式文档
            //获取文档信息数据
            XWPFDocument xdoc = new XWPFDocument(fis);
            //从Word文件中提取和返回简单数据
            XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
            String docx = extractor.getText();
            //对数据进行整理
//             docx = Pattern.compile("").matcher(docx).replaceAll(" ");
            //获取对应位置的数据
            String date = docx.substring(docx.indexOf(start), docx.indexOf(end));
            //打印数据
//            System.out.println(date);
            //关流
            fis.close();
            return date;
        }else{//处理.doc格式文档
            //获取文档信息数据
            HWPFDocument doc = new HWPFDocument(fis);
            //从Word文件中提取和返回简单数据
            WordExtractor word = new WordExtractor(doc);
            String wordDoc = word.getText();
            //对数据进行整理
            // docx = Pattern.compile("\\s").matcher(docx).replaceAll("");
            //获取对应位置的数据
            String date = wordDoc.substring(wordDoc.indexOf(start), wordDoc.indexOf(end));
            //打印数据
//            System.out.println(date);
            //关流
            fis.close();
            return date;
        }
    }

}