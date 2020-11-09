package com.stock.market.research.app.controller;

import com.stock.market.research.app.domain.StockMarketData;
import com.stock.market.research.app.dto.StockMarketDataDto;
import com.stock.market.research.app.service.StockMarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/stock/market")
public class StockMarketController {

    private static final Logger logger = Logger.getLogger("StockMarketController");

    @Autowired
    private StockMarketService stockMarketService;

    @RequestMapping(value = "/uploadBulkData",method = RequestMethod.POST)
    public Boolean uploadCsvFile(@RequestParam(name = "file")MultipartFile file){
        try {
           return  stockMarketService.uploadFile(file);
        }catch(Exception e){
            logger.log(Level.ALL,"Error while uploading csv file");
        }

        return false;
    }

    @RequestMapping(value = "/predictions", method =  RequestMethod.GET)
    public String calculateStockPerformance(@RequestParam(name ="stockName") String stockName){
        try {
            return stockMarketService.calculateStockPerformance(stockName);
        }catch(Exception e){
            logger.log(Level.ALL,"Error while predicting stock performance");
        }

        return "No Predictions Made";
    }

    @RequestMapping(value = "/addRecord",method = RequestMethod.POST)
    public Boolean addNewRecord(@RequestBody StockMarketDataDto stockMarketData){
        try {
            return stockMarketService.addNewStock(stockMarketData);
        }catch(Exception e){
            logger.log(Level.ALL,"Error while predicting stock performance");
        }
        return false;
    }

}
