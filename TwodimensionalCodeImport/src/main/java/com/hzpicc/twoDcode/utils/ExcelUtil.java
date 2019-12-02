package com.hzpicc.twoDcode.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;

//import static com.ejauto.utils.IdentityUtils.CHECK_BIT;

/**
 * by akc
 * 2019/8/26
 */
public class ExcelUtil {
    /**
     *
     * @param filePath  需要读取的文件路径
     * @param column  指定需要获取的列数，例如第一列 1
     * @param startRow 指定从第几行开始读取数据
     * @param  endRow 指定结束行
     * @return 返回读取列数据的set
     */
//    public static LinkedHashMap<Integer,String> getColumnSet(String filePath, int column, int startRow , int endRow){
//        //文件
//        Workbook wb = readExcel(filePath);
//        //sheet
//        Sheet sheet = wb.getSheetAt(0);
//        //行数
//        int rownum = sheet.getPhysicalNumberOfRows();
//        Row row = null;
//        //采用有序数组
//        LinkedHashMap<Integer,String> result = new LinkedHashMap<>();
//        String cellData = null;
//        String outWord = null;
//        if(wb != null){
//            for (int i=startRow-1; i<endRow; i++){
//                System.out.println("我是序号;"+(i+1));
//                row = sheet.getRow(i);
//                if(row !=null){
//                    cellData = (String) getCellFormatValue(row.getCell(column-1));
//                    //修改
//                    boolean legalPattern = IdentityUtils.isLegalPattern(cellData.replaceAll(" ", ""));
//                    if(legalPattern==false) {
//                        System.out.println("原来版:"+cellData.replaceAll(" ", ""));
//                        System.out.println("身份证有误得修改 \n改正如下:");
//                        try {
//                            String fixCode = cellData.replaceAll(" ", "").substring(0, 17) + CHECK_BIT;
//                            System.out.println("改正版:"+fixCode);
//                            //存入linkedhashmap
//                            result.put((i+1),fixCode.replaceAll(" ", ""));
//
//                        } catch (StringIndexOutOfBoundsException e) {
//                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!数字长度有误;不进行修改");
//                            System.out.println("改正版:"+cellData.replaceAll(" ", ""));
//                            result.put((i+1),cellData.replaceAll(" ", "")+"(暂不予修改)");
//                        }
//
//                        System.out.println("-----------mm------------------------------------------");
//                        continue;
//                    }
//                    System.out.println("该身份证没问题");
//                    result.put((i+1),cellData.replaceAll(" ", "")+"(该身份证校验位正确)");
//                }else{
//                    break;
//                }
//                System.out.println("我应该是身份证:"+cellData);
//            }
//        }
//        return  result;
//    }

//    /**
//     *
//     * @param filePath 需要读取的文件路径
//     * @param column 指定需要获取的列数，例如第一列 1
//     * @param startRow 指定从第几行开始读取数据
//     * @return  返回读取列数据的set
//     */
//    public static HashSet<String> getColumnSet(String filePath, int column, int startRow){
//        Workbook wb = readExcel(filePath); //文件
//        Sheet sheet = wb.getSheetAt(0); //sheet
//        int rownum = sheet.getPhysicalNumberOfRows(); //行数
//        System.out.println("sumrows " + rownum);
//
//       return  getColumnSet(filePath, column, startRow , rownum-1);
//    }


    /**
     *     读取excel
     */
    public static Workbook readExcel(String filePath){
        Workbook wb = null;
        if(filePath==null){
            return null;
        }
        String extString = filePath.substring(filePath.lastIndexOf("."));
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            if(".xls".equals(extString)){
                return wb = new HSSFWorkbook(is);
            }else if(".xlsx".equals(extString)){
                return wb = new XSSFWorkbook(is);
            }else{
                return wb = null;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }

    public static Object getCellFormatValue(Cell cell){
        Object cellValue = null;
        if(cell!=null){
            //判断cell类型
            switch(cell.getCellType()){
                case NUMERIC:{
                    //将数值型cell设置为string型
                    cell.setCellType(CellType.STRING);
                    cellValue = cell.getStringCellValue();
                    break;
                }
                case FORMULA:{
                    //判断cell是否为日期格式
                    if(DateUtil.isCellDateFormatted(cell)){
                        //转换为日期格式YYYY-mm-dd
                        cellValue = cell.getDateCellValue();
                    }else{
                        //数字
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                case STRING:{
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                }
                default:
                    cellValue = "";
            }
        }else{
            cellValue = "";
        }
        return cellValue;
    }

}
