package com.hzpicc.twoDcode.utils;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellAddress;

import java.io.*;

public class ExcelOutput {
    /**
 	  * 给excel指定位置写入值
 	  *
      * @param path       写入文件在路径
 	  * @param coordinate 写入内容的位置（例如:B4）
      * @param value      写的值
 	  */
    public static void writeSpecifiedCell(String path, String coordinate, String value) {
        //根据路径获取文件
        File file = new File(path);
        //定义输入流对象
        FileInputStream excelFileInputStream;
        try {
            excelFileInputStream = new FileInputStream(file);
            // 拿到文件转化为JavaPoi可操纵类型
            Workbook workbook = WorkbookFactory.create(excelFileInputStream);
            excelFileInputStream.close();
            ////获取excel表格
            Sheet sheet = workbook.getSheetAt(0);
            //获取单元格的row和cell
            CellAddress address = new CellAddress(coordinate);
            // 获取行
            Row row = sheet.getRow(address.getRow());
            // 获取列
            //action: 注意这里所在的excel的单元格(如A2等)内必须有   东西   存在;不然会   报错
            // poi中的他做的是修改   而不是insert 新增
            Cell cell = row.getCell(address.getColumn());
            //设置单元的值
//            try {
                cell.setCellValue(value);
//            } catch (NullPointerException e) {
//                e.getStackTrace();
//            }

            //写入数据
            FileOutputStream excelFileOutPutStream = new FileOutputStream(file);
            workbook.write(excelFileOutPutStream);
            excelFileOutPutStream.flush();
            excelFileOutPutStream.close();
            System.out.println("指定单元格设置数据写入完成");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EncryptedDocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
