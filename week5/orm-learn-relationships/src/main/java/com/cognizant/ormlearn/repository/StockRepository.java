package com.cognizant.ormlearn.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    // Get stock details for a code between start and end dates
    List<Stock> findByCodeAndDateBetween(String code, Date startDate, Date endDate);

    // Get stock details for a code where close price is greater than a specified value
    List<Stock> findByCodeAndCloseGreaterThan(String code, BigDecimal closePrice);

    // Find top 3 dates with highest transaction volume
    List<Stock> findTop3ByOrderByVolumeDesc();

    // Identify top 3 dates when stock price was lowest for a code
    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}
