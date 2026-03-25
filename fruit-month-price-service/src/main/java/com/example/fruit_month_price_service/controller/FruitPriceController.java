package com.example.fruit_month_price_service.controller;

import com.example.fruit_month_price_service.model.FruitPrice;
import com.example.fruit_month_price_service.repository.FruitPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/fruit-price")
public class FruitPriceController {

    @Autowired
    private FruitPriceRepository repository;

    @GetMapping("/fruit/{fruit}/month/{month}")
    public Map<String, Object> getFruitPrice(@PathVariable String fruit, @PathVariable String month) {
        FruitPrice fp = repository.findByFruitIgnoreCaseAndMonthIgnoreCase(
                fruit.toLowerCase(), month.toLowerCase()
        ).orElseThrow(
                () -> new RuntimeException("No price found for " + fruit + " in " + month)
        );

        return Map.of(
                "fruit", fruit.toLowerCase(),
                "month", month.toLowerCase(),
                "fmp", fp.getPrice(),
                "port", 8000
        );
    }
}