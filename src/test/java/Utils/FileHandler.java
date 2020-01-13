package Utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class FileHandler {

    public ArrayList<String> listReadExcel(String filePath, String fileName, String sheetName, String Id) throws IOException  {
        boolean flag = false;
        //Create an object of File class to open xlsx file
        File file = new File(filePath + "\\" + fileName);
        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);
        Workbook Workbook = null;
        //Find the file extension by splitting file name in substring  and getting only extension name
        String fileExtensionName = fileName.substring(fileName.indexOf("."));
        if (fileExtensionName.equals(".xlsx")) {
            //If it is xlsx file then create object of XSSFWorkbook class
            Workbook = new XSSFWorkbook(inputStream);
        }
        //Check condition if the file is xls file
        if (fileExtensionName.equals(".xls")) {
            //If it is xls file then create object of HSSFWorkbook class
            Workbook = new HSSFWorkbook(inputStream);
        }
        //Read sheet inside the workbook by its name
        Sheet sheet = Workbook.getSheet(sheetName);
        ArrayList<String> list = new ArrayList();

        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        for (int i = 0; i < rowCount + 1; i++) {
            String word2verify;
            Row row = sheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                if (j == 0 && row.getCell(j).getStringCellValue().equalsIgnoreCase(Id)) {
                    flag = true;
                } else if (flag) {
                    switch (row.getCell(j).getCellType()) {
                        case NUMERIC:
                            list.add(String.valueOf(row.getCell(j).getNumericCellValue()));
                            break;
                        case STRING:
                            word2verify = row.getCell(j).getStringCellValue();
                            if (word2verify.contains("\"")){
                                word2verify.replace("\"","");
                            }
                            list.add(word2verify);
                            break;
                    }
                }
            }
            if (flag){
                break;
            }
        }
        return list;
    }

    public Object[][] readExcel(String filePath, String fileName, String sheetName, String Id) throws IOException {
        boolean flag = false;
        //Create an object of File class to open xlsx file
        File file = new File(filePath + "\\" + fileName);
        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);
        Workbook Workbook = null;
        //Find the file extension by splitting file name in substring  and getting only extension name
        String fileExtensionName = fileName.substring(fileName.indexOf("."));
        if (fileExtensionName.equals(".xlsx")) {
            //If it is xlsx file then create object of XSSFWorkbook class
            Workbook = new XSSFWorkbook(inputStream);
        }
        //Check condition if the file is xls file
        if (fileExtensionName.equals(".xls")) {
            //If it is xls file then create object of HSSFWorkbook class
            Workbook = new HSSFWorkbook(inputStream);
        }
        //Read sheet inside the workbook by its name
        Sheet sheet = Workbook.getSheet(sheetName);
        ArrayList<String> list = new ArrayList();

        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        for (int i = 0; i < rowCount + 1; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                if (j == 0 && row.getCell(j).getStringCellValue().equalsIgnoreCase(Id)) {
                    System.out.println("find the ID: "+Id);
                    flag = true;
                   // list.add(j, row.getCell(j).getStringCellValue());
                } else if (flag) {
                    switch (row.getCell(j).getCellType()) {
                        case NUMERIC:
                            list.add(String.valueOf(row.getCell(j).getNumericCellValue()));
                            System.out.println();
                            break;
                        case STRING:
                            list.add(row.getCell(j).getStringCellValue());
                            break;
                    }
                }
            }
            if (flag){
                flag = false;
                System.out.println("finish to load the list: ");
                System.out.println(list.toString());
                break;
            }
        }
        return new Object[][] { list.toArray() };
    }


    public void updateExcel(String filePath, String fileName, String sheetName, String dataToWrite,String id,int cellNum) throws IOException {
        //Create an object of File class to open xlsx file
        File file = new File(filePath + "\\" + fileName);

        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = null;

        //Find the file extension by splitting  file name in substring and getting only extension name
        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        //Check condition if the file is xls file
        if (fileExtensionName.equals(".xls")) {
            //If it is xls file then create object of XSSFWorkbook class
            workbook = new HSSFWorkbook(inputStream);
        }

        if (fileExtensionName.equals(".xlsx")) {
            //If it is xlsx file then create object of XSSFWorkbook class
            workbook = new XSSFWorkbook(inputStream);
        }

        //Read excel sheet by sheet name
        Sheet sheet = workbook.getSheet(sheetName);
        Row row;
        Cell cell;
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        for (int i = 0; i < rowCount + 1; i++) {
            row = sheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                if (j == 0 && row.getCell(j).getStringCellValue().equalsIgnoreCase(id)) {
                    System.out.println("find the ID: "+id);
                    cell = row.createCell(cellNum);
                    cell.setCellValue(dataToWrite);
                    break;
                }
            }
        }

        //Close input stream
        inputStream.close();

        //Create an object of FileOutputStream class to create write data in excel file
        FileOutputStream outputStream = new FileOutputStream(file);

        //write data in the excel file
        workbook.write(outputStream);

        //close output stream
        outputStream.close();
    }


    public void writeExcel(String filePath, String fileName, String sheetName, String[] dataToWrite) throws IOException {

        //Create an object of File class to open xlsx file
        File file = new File(filePath + "\\" + fileName);

        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = null;

        //Find the file extension by splitting  file name in substring and getting only extension name
        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        //Check condition if the file is xls file
        if (fileExtensionName.equals(".xls")) {
            //If it is xls file then create object of XSSFWorkbook class
            workbook = new HSSFWorkbook(inputStream);
        }

        if (fileExtensionName.equals(".xlsx")) {
            //If it is xlsx file then create object of XSSFWorkbook class
            workbook = new XSSFWorkbook(inputStream);
        }

        //Read excel sheet by sheet name
        Sheet sheet = workbook.getSheet(sheetName);

        //Get the current count of rows in excel file
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

        //Get the first row from the sheet
        Row row = sheet.getRow(0);

        //Create a new row and append it at last of sheet
        Row newRow = sheet.createRow(rowCount + 1);

        //Create a loop over the cell of newly created Row
        for (int j = 0; j < row.getLastCellNum(); j++) {

            //Fill data in row
            Cell cell = newRow.createCell(j);
            cell.setCellValue(dataToWrite[j]);
        }

        //Close input stream
        inputStream.close();

        //Create an object of FileOutputStream class to create write data in excel file
        FileOutputStream outputStream = new FileOutputStream(file);

        //write data in the excel file
        workbook.write(outputStream);

        //close output stream
        outputStream.close();
    }

}
