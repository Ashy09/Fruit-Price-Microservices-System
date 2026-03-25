package com.example.fruit_month_price_service.loader;

import com.example.fruit_month_price_service.model.FruitPrice;
import com.example.fruit_month_price_service.repository.FruitPriceRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class ExcelLoader implements CommandLineRunner {

    @Autowired
    private FruitPriceRepository repository;

    @Override
    public void run(String... args) throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("FMP.xlsx");
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        Row header = sheet.getRow(0);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            String fruit = row.getCell(0).getStringCellValue();
            for (int j = 1; j < row.getLastCellNum(); j++) {
                String month = header.getCell(j).getStringCellValue();
                double price = row.getCell(j).getNumericCellValue();
                repository.save(new FruitPrice(null, fruit.toLowerCase(), month.toLowerCase(), price));
            }
        }
        workbook.close();
    }
}