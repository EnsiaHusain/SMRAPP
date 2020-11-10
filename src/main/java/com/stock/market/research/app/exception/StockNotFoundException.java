package com.stock.market.research.app.exception;

public class StockNotFoundException extends Exception {

    public StockNotFoundException(){
        super();
    }

    public StockNotFoundException(String message){
        super(message);
    }
}
