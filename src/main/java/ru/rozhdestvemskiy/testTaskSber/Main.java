package ru.rozhdestvemskiy.testTaskSber;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static final String PATH_FILE = "src/main/resources/name_java.xslx";

    public static void main(String[] args) {
        String value1 = "Т704НМ800";
        String value2 = "Т704НМ799";
        String value3 = "Т204НМ799";

        Set<String> values = readXSLXFile(PATH_FILE);

        if (values.contains(value1) || values.contains(value2) || values.contains(value3)) {
            System.out.println("Номер найден");
        } else {
            System.out.println("Номер не найден");
        }
    }

    public static Set<String> readXSLXFile(String pathFile) {

        Set<String> data = new HashSet<>();

        try (FileInputStream file = new FileInputStream(pathFile);
             Workbook workbook = new XSSFWorkbook(file)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    continue;
                }
                for (Cell cell : row) {
                    data.add(cell.getRichStringCellValue().getString());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }
}
