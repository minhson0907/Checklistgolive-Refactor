package android.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.util.POILogger;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
public class DataHelper {
    public static XSSFWorkbook wb;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static FileInputStream fis;

    public static String getCellData(int rownum, int col, String fileName) {
        try {
            //        datamap = DataHelper.data(System.getProperty("user.dir")+"//data//userdata.xlsx","Sheet1");
            //fis=new FileInputStream("C:\\Users\\ajain153\\Desktop\\Test Data.xlsx");
            fis = new FileInputStream(System.getProperty("user.dir") + "/data//" + fileName +".xlsx");
            wb = new XSSFWorkbook(fis);
            sheet = wb.getSheet("Sheet1");
            row = sheet.getRow(rownum);
            cell = row.getCell(col);
            //   System.out.println(cell.getStringCellValue());
            if (cell == null) {
                return "";
            }
            return cell.getStringCellValue();

        } catch (Exception e) {
            System.out.println("In the Catch Block:" + e);
            return "Exception Occured";
        }

    }
}