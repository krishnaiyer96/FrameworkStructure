package org.example.Utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ExcelReader {

    public ArrayList<String> getData(String testCaseName) throws IOException {

        ArrayList<String> data = new ArrayList<String>();

        FileInputStream fis = new FileInputStream("D:\\Source\\Java\\FrameworkDesign\\TestData.xlsx");
        XSSFWorkbook workBook = new XSSFWorkbook(fis);
        int sheets = workBook.getNumberOfSheets();
        for(int i = 0; i< sheets; i++){
            if(workBook.getSheetName(i).equalsIgnoreCase("TestData")){
                XSSFSheet sheet = workBook.getSheetAt(i);    // Sheet is collection of rows
                Iterator<Row> rows =  sheet.iterator();   // rows is collection of cells
                Row firstRow = rows.next();
                Iterator<Cell> cells = firstRow.cellIterator();
                int k = 0;
                int column = 0;
                while(cells.hasNext())
                {
                    Cell value = cells.next();
                    if(value.getStringCellValue().equalsIgnoreCase("TestCase"))
                    {
                        column = k;

                    }
                    k++;
                }
                System.out.println(column);
                while(rows.hasNext())
                {
                    Row r = rows.next();
                    if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)){

                        Iterator<Cell> cv = r.cellIterator();
                        while(cv.hasNext())
                        {
                            Cell c = cv.next();
                            if(c.getCellType() == CellType.STRING){
                                data.add(cv.next().getStringCellValue());
                            }
                            else if(c.getCellType() == CellType.NUMERIC){
                                
                            }

                        }
                        System.out.println(data);

                    }
                }


            }
        }
        return data;
    }
    public static void main(String[] args) throws IOException {
ExcelReader reader = new ExcelReader();
reader.getData("Shopping");

    }
}
