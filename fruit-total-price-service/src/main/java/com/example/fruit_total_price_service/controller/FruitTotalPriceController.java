package com.example.fruit_total_price_service.controller;

import com.example.fruit_total_price_service.service.FruitPriceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/total-price")
public class FruitTotalPriceController {

    @Autowired
    private FruitPriceClient client;

    @GetMapping("/fruit/{fruit}/month/{month}/quantity/{qty}")
    public Map<String, Object> getTotalPrice(
            @PathVariable String fruit,
            @PathVariable String month,
            @PathVariable int qty
    ) {
        if (qty <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }

        double unitPrice = client.getUnitPrice(fruit.toLowerCase(), month.toLowerCase());
        double total = unitPrice * qty;

        return Map.of(
                "fruit", fruit.toLowerCase(),
                "month", month.toLowerCase(),
                "unit_price", unitPrice,
                "quantity", qty,
                "total_price", total,
                "port", 8001
        );
    }

    @ExceptionHandler(RuntimeException.class)
    public Map<String, String> handleError(RuntimeException ex) {
        return Map.of("error", ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Map<String, String> handleBadInput(IllegalArgumentException ex) {
        return Map.of("error", ex.getMessage());
    }
}