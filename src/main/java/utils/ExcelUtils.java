package utils;

import java.io.File; // Added this import to fix the "File" error
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.*;

import com.orthofx.smilestream.base.BaseTest;

public class ExcelUtils {

    public Map<String, String> getSpecificRowData(String filePath, String sheetName, int rowNumber) throws Exception {
        // Create the file object
        File file = new File(filePath);
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheet(sheetName);
        
        // DataFormatter helps convert any cell type (Numeric, Formula, etc.) into a String
        DataFormatter formatter = new DataFormatter();
        
        // Row 1 in Excel is Index 0 (Headers)
        Row headerRow = sheet.getRow(0);
        
        // User wants physical row 'rowNumber', so we use index 'rowNumber - 1'
        Row targetRow = sheet.getRow(rowNumber - 1);
        
        if (targetRow == null) {
            workbook.close();
            throw new Exception("Row " + rowNumber + " does not exist in the sheet!");
        }

        Map<String, String> rowData = new HashMap<>();
        
        // Loop through each cell in the header to use as Map Keys
        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
            String columnName = headerRow.getCell(i).getStringCellValue();
            
            // Get the cell from the target row
            Cell cell = targetRow.getCell(i);
            
            // Use formatter to get the value as it appears in Excel
            String cellValue = formatter.formatCellValue(cell);
            
            rowData.put(columnName, cellValue);
        }
        
        workbook.close();
        return rowData;
    }
    
    
}