package com.stock.market.research.app.service;

import com.stock.market.research.app.domain.StockMarketData;
import com.stock.market.research.app.dto.StockMarketDataDto;
import org.springframework.web.multipart.MultipartFile;

public interface StockMarketService {

    Boolean uploadFile(MultipartFile file) throws Exception;

    String calculateStockPerformance(String stockName) throws Exception;

    Boolean addNewStock(StockMarketDataDto stockMarketDataDto) throws Exception;
}
