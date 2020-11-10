package com.stock.market.research.app.controller;

import com.stock.market.research.app.dto.StockMarketDataDto;
import com.stock.market.research.app.exception.GenericSystemException;
import com.stock.market.research.app.exception.StockNotFoundException;
import com.stock.market.research.app.service.StockMarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/stock/market")
public class StockMarketController {

    private static final Logger logger = Logger.getLogger("StockMarketController");

    @Autowired
    private StockMarketService stockMarketService;

    @RequestMapping(value = "/uploadBulkData",method = RequestMethod.POST)
    public Boolean uploadCsvFile(@RequestParam(name = "file") MultipartFile file) throws Exception{
        try {
           return  stockMarketService.uploadFile(file);
        }catch(Exception e){
            logger.log(Level.ALL,"Error while uploading csv file");
            throw new GenericSystemException("There was an internal error while uploading csv file");
        }

    }

    @RequestMapping(value = "/predictions", method =  RequestMethod.GET)
    public List<StockMarketDataDto> viewStockPerformance(@RequestParam(name ="stockName") String stockName) throws Exception{
        try {
            List<StockMarketDataDto> stockMarketData = stockMarketService.viewStockPerformance(stockName);
            if(stockMarketData == null || stockMarketData.isEmpty()){
                throw new StockNotFoundException("No data found for stock "+stockName);
            }
            return stockMarketData;
        }catch(Exception e){
            logger.log(Level.ALL,"Error while predicting stock performance");
            throw new GenericSystemException("There was an internal error while viewing stock performance");
        }
    }

    @RequestMapping(value = "/addRecord",method = RequestMethod.POST)
    public Boolean addNewRecord(@RequestBody StockMarketDataDto stockMarketData) throws Exception{
        try {
            return stockMarketService.addNewStock(stockMarketData);
        }catch(Exception e){
            logger.log(Level.ALL,"Error while predicting stock performance");
            throw new GenericSystemException("There was an internal error while adding a new stock data");
        }
    }

}
