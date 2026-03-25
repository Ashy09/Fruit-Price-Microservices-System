package com.example.fruit_total_price_service.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Service
public class FruitPriceClient {
    private final RestTemplate restTemplate = new RestTemplate();

    public double getUnitPrice(String fruit, String month) {
        String url = "http://localhost:8000/fruit-price/fruit/" + fruit + "/month/" + month;
        Map<?, ?> response = restTemplate.getForObject(url, Map.class);
        if (response != null && response.containsKey("fmp")) {
            return Double.parseDouble(response.get("fmp").toString());
        } else {
            throw new RuntimeException("Unable to get price from FMP");
        }
    }
}