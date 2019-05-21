package dn.codegym.crm.service.impl;

import dn.codegym.crm.dto.LeadDTO;
import dn.codegym.crm.service.ReadFromExcelFileService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ReadFromExcelFileServiceImpl implements ReadFromExcelFileService {
    public List<LeadDTO> readBooksFromExcelFile(String excelFilePath) throws IOException {
        List<LeadDTO> leadDTOS = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

        Workbook workBook = getWorkbook(inputStream, excelFilePath);
        Sheet firstSheet = workBook.getSheetAt(0);
        Iterator<Row> rows = firstSheet.iterator();

        while (rows.hasNext()) {
            Row row = rows.next();
            Iterator<Cell> cells = row.cellIterator();
            LeadDTO leadDTO=new LeadDTO();

            while (cells.hasNext()) {
                Cell cell = cells.next();
                int columnIndex = cell.getColumnIndex();

                switch (columnIndex) {
                    case 0:
                        leadDTO.setProduct((String) getCellValue(cell));
                        break;
                    case 1:
                        leadDTO.setName((String) getCellValue(cell));
                        break;
                    case 2:
                        leadDTO.setPhoneNumber((String) getCellValue(cell));
                        break;
                    case 3:
                        leadDTO.setEmail((String) getCellValue(cell));
                        break;
                    case 4:
                        leadDTO.setSource((String) getCellValue(cell));
                        break;
                    case 5:
                        leadDTO.setAdmissionDate((String) getCellValue(cell));
                        break;
                    case 6:
                        leadDTO.setJob((String) getCellValue(cell));
                        break;
                    case 7:
                        leadDTO.setGender((String) getCellValue(cell));
                        break;
                    case 8:
                        leadDTO.setStatus((String) getCellValue(cell));
                        break;
                    case 9:
                        leadDTO.setLastUpdateStatusDate((String) getCellValue(cell));
                        break;
                }
            }
            leadDTOS.add(leadDTO);
        }

        workBook.close();
        inputStream.close();

        return leadDTOS;
    }

    public Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();

            case Cell.CELL_TYPE_BOOLEAN:
                return cell.getBooleanCellValue();

            case Cell.CELL_TYPE_NUMERIC:
                return cell.getNumericCellValue();
        }

        return null;
    }

    public Workbook getWorkbook(FileInputStream inputStream, String excelFilePath) throws IOException {
        Workbook workbook = null;

        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }

        return workbook;
    }

}
