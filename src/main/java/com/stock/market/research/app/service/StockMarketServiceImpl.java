package com.stock.market.research.app.service;

import com.stock.market.research.app.dao.StockMarketRepository;
import com.stock.market.research.app.domain.StockMarketData;
import com.stock.market.research.app.dto.StockMarketDataDto;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StockMarketServiceImpl implements  StockMarketService{

    @Autowired
    private StockMarketRepository stockMarketRepository;

    @Override
    @Transactional
    public Boolean uploadFile(MultipartFile file) throws Exception{

        BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"));
        CSVParser csvParse = new CSVParser(fileReader, CSVFormat.DEFAULT.withDelimiter(',').withFirstRecordAsHeader().withTrim());

        List<StockMarketData> stockMarketData = new ArrayList<StockMarketData>();
        List<CSVRecord> records = csvParse.getRecords();
        for(CSVRecord row:records){
            StockMarketData data = new StockMarketData();
            if(row.get("quarter")!=null){
                data.setQuarter(Integer.parseInt(row.get("quarter")));
            }
            data.setStock(row.get("stock"));
            data.setDate(new Date(row.get("date")));
            data.setOpen(new BigDecimal(row.get("open").replace("$","")));
            data.setHigh(new BigDecimal(row.get("high").replace("$","")));
            data.setLow(new BigDecimal(row.get("low").replace("$","")));
            data.setClose(new BigDecimal(row.get("close").replace("$","")));
            if(row.get("volume")!=null){
                data.setVolume(Long.parseLong(row.get("volume")));
            }
            if(row.get("percent_change_price") !=null && !row.get("percent_change_price").isEmpty()){
                data.setPercentChangePrice(new BigDecimal(row.get("percent_change_price")));
            }

            if(row.get("percent_change_volume_over_last_wk") !=null && !row.get("percent_change_volume_over_last_wk").isEmpty()){
                data.setPercentChangeVolumeOverlastWeek(new BigDecimal(row.get("percent_change_volume_over_last_wk")));
            }
            if(row.get("previous_weeks_volume") !=null && !row.get("previous_weeks_volume").isEmpty()){
                data.setPreviousWeeksVolume(new BigDecimal(row.get("previous_weeks_volume")));
            }
            if(row.get("next_weeks_open") !=null && !row.get("next_weeks_open").isEmpty()){
                data.setNextWeeksopen(new BigDecimal(row.get("next_weeks_open").replace("$","")));
            }
            if(row.get("next_weeks_close") != null && !row.get("next_weeks_close").isEmpty()){
                data.setNextWeeksClose(new BigDecimal(row.get("next_weeks_close").replace("$","")));
            }

            if(row.get("percent_change_next_weeks_price") != null && !row.get("percent_change_next_weeks_price").isEmpty()){
                data.setPercentChangeNextWeeksPrice(new BigDecimal(row.get("percent_change_next_weeks_price")));
            }

            if(row.get("days_to_next_dividend")!=null){
                data.setDaysToNextDividend(Integer.parseInt(row.get("days_to_next_dividend")));
            }
            if(row.get("percent_return_next_dividend") != null && !row.get("percent_return_next_dividend").isEmpty()){
                data.setPercentReturnNextDividend(new BigDecimal(row.get("percent_return_next_dividend")));
            }

            stockMarketData.add(data);
        }

        stockMarketRepository.saveAll(stockMarketData);
        return true;
    }

    @Override
    public List<StockMarketDataDto> viewStockPerformance(String stockName) throws Exception{
        List<StockMarketData> stockMarketDataList = stockMarketRepository.findByStock(stockName);

        List<StockMarketDataDto> stockMarketDataDtos = new ArrayList<>();
        for(StockMarketData data : stockMarketDataList){
            StockMarketDataDto dto = new StockMarketDataDto();
            dto.setQuarter(data.getQuarter());
            dto.setDate(data.getDate().toString());
            dto.setOpen(data.getOpen().toString()+"$");
            dto.setHigh(data.getHigh().toString()+"$");
            dto.setLow(data.getLow().toString()+"$");
            dto.setClose(data.getClose().toString()+"$");
            dto.setVolume(data.getVolume());
            dto.setPercentChangePrice(data.getPercentChangePrice());
            dto.setPercentChangeNextWeeksPrice(data.getPercentChangeNextWeeksPrice());
            dto.setPercentChangePrice(data.getPercentChangePrice());
            dto.setNextWeeksopen(data.getNextWeeksopen().toString());
            dto.setNextWeeksClose(data.getNextWeeksClose().toString());
            dto.setDaysToNextDividend(data.getDaysToNextDividend());
            dto.setPercentReturnNextDividend(data.getPercentReturnNextDividend());
            if(data.getPreviousWeeksVolume()!=null ){
                dto.setPreviousWeeksVolume(data.getPreviousWeeksVolume());
            }
            if(data.getPercentChangeVolumeOverlastWeek()!=null){
                dto.setPercentChangeVolumeOverlastWeek(data.getPercentChangeVolumeOverlastWeek());
            }
            stockMarketDataDtos.add(dto);
        }
        return stockMarketDataDtos;
    }

    @Override
    @Transactional
    public Boolean addNewStock(StockMarketDataDto stockMarketDataDto) throws Exception{
        StockMarketData stockMarketData = new StockMarketData();
        stockMarketData.setQuarter(stockMarketDataDto.getQuarter());
        stockMarketData.setStock(stockMarketDataDto.getStock());
        stockMarketData.setDate(new Date(stockMarketDataDto.getDate()));
        stockMarketData.setOpen(new BigDecimal(stockMarketDataDto.getOpen().replace("$","")));
        stockMarketData.setHigh(new BigDecimal(stockMarketDataDto.getHigh().replace("$","")));
        stockMarketData.setLow(new BigDecimal(stockMarketDataDto.getLow().replace("$","")));
        stockMarketData.setClose(new BigDecimal(stockMarketDataDto.getClose().replace("$","")));
        stockMarketData.setVolume(stockMarketDataDto.getVolume());
        stockMarketData.setPercentChangeNextWeeksPrice(stockMarketDataDto.getPercentChangeNextWeeksPrice());
        stockMarketData.setPercentChangePrice(stockMarketDataDto.getPercentChangePrice());
        if(stockMarketDataDto.getPreviousWeeksVolume() !=null){
            stockMarketData.setPreviousWeeksVolume(stockMarketDataDto.getPreviousWeeksVolume());
        }
        stockMarketData.setNextWeeksopen(new BigDecimal(stockMarketDataDto.getNextWeeksopen().replace("$","")));
        stockMarketData.setNextWeeksClose(new BigDecimal(stockMarketDataDto.getNextWeeksClose().replace("$","")));
        stockMarketData.setDaysToNextDividend(stockMarketDataDto.getDaysToNextDividend());
        stockMarketData.setPercentReturnNextDividend(stockMarketDataDto.getPercentReturnNextDividend());
        if(stockMarketDataDto.getPercentChangeVolumeOverlastWeek()!=null){
            stockMarketData.setPercentChangeVolumeOverlastWeek(stockMarketDataDto.getPercentChangeVolumeOverlastWeek());
        }

        stockMarketRepository.saveAndFlush(stockMarketData);
        return true;
    }

}
