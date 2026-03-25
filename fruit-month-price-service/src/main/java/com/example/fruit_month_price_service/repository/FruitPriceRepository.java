package com.example.fruit_month_price_service.repository;

import com.example.fruit_month_price_service.model.FruitPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface FruitPriceRepository extends JpaRepository<FruitPrice, Long> {
    Optional<FruitPrice> findByFruitIgnoreCaseAndMonthIgnoreCase(String fruit, String month);
}