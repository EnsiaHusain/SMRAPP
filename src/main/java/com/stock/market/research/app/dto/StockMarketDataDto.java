package com.stock.market.research.app.dto;

import java.math.BigDecimal;

public class StockMarketDataDto {

    private Integer quarter;
    private String stock;
    private String date;
    private String open;
    private String high;
    private String low;
    private String close;
    private Long volume;
    private BigDecimal percentChangePrice;
    private BigDecimal percentChangeVolumeOverlastWeek;
    private BigDecimal previousWeeksVolume;
    private String nextWeeksopen;
    private String nextWeeksClose;
    private BigDecimal percentChangeNextWeeksPrice;
    private Integer daysToNextDividend;
    private BigDecimal percentReturnNextDividend;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
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

    public String getNextWeeksopen() {
        return nextWeeksopen;
    }

    public void setNextWeeksopen(String nextWeeksopen) {
        this.nextWeeksopen = nextWeeksopen;
    }

    public String getNextWeeksClose() {
        return nextWeeksClose;
    }

    public void setNextWeeksClose(String nextWeeksClose) {
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
