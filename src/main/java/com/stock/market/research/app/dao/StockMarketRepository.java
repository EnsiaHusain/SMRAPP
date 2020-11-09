package com.stock.market.research.app.dao;

import com.stock.market.research.app.domain.StockMarketData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockMarketRepository extends JpaRepository<StockMarketData,Integer>{

    List<StockMarketData> findByStock(String stock);
}
