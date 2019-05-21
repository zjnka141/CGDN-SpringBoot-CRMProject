package dn.codegym.crm.service;

import dn.codegym.crm.dto.LeadDTO;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public interface ReadFromExcelFileService {
    List<LeadDTO> readBooksFromExcelFile(String excelFilePath) throws IOException;

    Object getCellValue(Cell cell);

    Workbook getWorkbook(FileInputStream inputStream, String excelFilePath) throws IOException;
}
