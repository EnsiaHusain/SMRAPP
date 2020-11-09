package com.stock.market.research.app.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class StockMarketData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer stockId;
    private Integer quarter;
    private String stock;
    private Date date;
    private BigDecimal open;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal close;
    private Long volume;
    private BigDecimal percentChangePrice;
    private BigDecimal percentChangeVolumeOverlastWeek;
    private BigDecimal previousWeeksVolume;
    private BigDecimal nextWeeksopen;
    private BigDecimal nextWeeksClose;
    private BigDecimal percentChangeNextWeeksPrice;
    private Integer daysToNextDividend;
    private BigDecimal percentReturnNextDividend;

    public StockMarketData(){

    }

    public StockMarketData(Integer quarter,String stock,Date date,BigDecimal open,BigDecimal high,BigDecimal low,BigDecimal close,
                           Long volume, BigDecimal percentChangePrice,BigDecimal percentChangeVolumeOverlastWeek, BigDecimal previousWeeksVolume,
                           BigDecimal nextWeeksopen,BigDecimal nextWeeksClose, BigDecimal percentChangeNextWeeksPrice, Integer daysToNextDividend,
                           BigDecimal percentReturnNextDividend){

        this.quarter = quarter;
        this.stock = stock;
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.percentChangePrice = percentChangePrice;
        this.percentChangeVolumeOverlastWeek = percentChangeVolumeOverlastWeek;
        this.previousWeeksVolume = previousWeeksVolume;
        this.nextWeeksopen = nextWeeksopen;
        this.nextWeeksClose = nextWeeksClose;
        this.percentChangeNextWeeksPrice = percentChangeNextWeeksPrice;
        this.daysToNextDividend = daysToNextDividend;
        this.percentReturnNextDividend = percentReturnNextDividend;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public Integer getQuarter() {
        return quarter;
    }

    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getClose() {
        return close;
    }

    public void setClose(BigDecimal close) {
        this.close = close;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public BigDecimal getPercentChangePrice() {
        return percentChangePrice;
    }

    public void setPercentChangePrice(BigDecimal percentChangePrice) {
        this.percentChangePrice = percentChangePrice;
    }

    public BigDecimal getPercentChangeVolumeOverlastWeek() {
        return percentChangeVolumeOverlastWeek;
    }

    public void setPercentChangeVolumeOverlastWeek(BigDecimal percentChangeVolumeOverlastWeek) {
        this.percentChangeVolumeOverlastWeek = percentChangeVolumeOverlastWeek;
    }

    public BigDecimal getPreviousWeeksVolume() {
        return previousWeeksVolume;
    }

    public void setPreviousWeeksVolume(BigDecimal previousWeeksVolume) {
        this.previousWeeksVolume = previousWeeksVolume;
    }

    public BigDecimal getNextWeeksopen() {
        return nextWeeksopen;
    }

    public void setNextWeeksopen(BigDecimal nextWeeksopen) {
        this.nextWeeksopen = nextWeeksopen;
    }

    public BigDecimal getNextWeeksClose() {
        return nextWeeksClose;
    }

    public void setNextWeeksClose(BigDecimal nextWeeksClose) {
        this.nextWeeksClose = nextWeeksClose;
    }

    public BigDecimal getPercentChangeNextWeeksPrice() {
        return percentChangeNextWeeksPrice;
    }

    public void setPercentChangeNextWeeksPrice(BigDecimal percentChangeNextWeeksPrice) {
        this.percentChangeNextWeeksPrice = percentChangeNextWeeksPrice;
    }

    public Integer getDaysToNextDividend() {
        return daysToNextDividend;
    }

    public void setDaysToNextDividend(Integer daysToNextDividend) {
        this.daysToNextDividend = daysToNextDividend;
    }

    public BigDecimal getPercentReturnNextDividend() {
        return percentReturnNextDividend;
    }

    public void setPercentReturnNextDividend(BigDecimal percentReturnNextDividend) {
        this.percentReturnNextDividend = percentReturnNextDividend;
    }
}
