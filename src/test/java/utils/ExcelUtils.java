package utils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
static XSSFWorkbook workbook;
static XSSFSheet sheet;
    public ExcelUtils(String excelPath, String sheetName) {
        try  {
             workbook = new XSSFWorkbook(excelPath);
             sheet = workbook.getSheet(sheetName);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            System.out.println(exception.getCause());
            exception.printStackTrace();
        }
    }

    //main for demo prints in console of written functionsL
    public static void main(String[]args){
        getRowCount();
    }

    public static void getRowCount() {
            int rowCount = sheet.getPhysicalNumberOfRows();
            System.out.println("ROWS COUNT:::"+rowCount);
    }

    public static void getCellData(int rowNum, int colNum) {
            DataFormatter formatter = new DataFormatter();
            Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
        System.out.println("CELL DATA ISS:::"+value);
    }
}
