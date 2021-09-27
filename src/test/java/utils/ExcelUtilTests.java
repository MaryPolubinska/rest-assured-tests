package utils;

public class ExcelUtilTests {

    public static void main(String[] args) {
        String excelPath = "./data/TestData.xlsx";
        String sheetName = "Page1";
        ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
        excel.getRowCount();
        excel.getCellData(1, 0);
        excel.getCellData(1, 1);
        excel.getCellData(1, 2);
    }
}
