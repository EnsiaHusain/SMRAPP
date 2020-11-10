package com.stock.market.research.app.controller;

import com.stock.market.research.app.exception.ErrorResponse;
import com.stock.market.research.app.exception.GenericSystemException;
import com.stock.market.research.app.exception.StockNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class StockMarketExceptionController {

    @ExceptionHandler(StockNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorResponse handleStockNotFoundException(StockNotFoundException stockNotFoundException , HttpServletRequest httpServletRequest){

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorMessage(stockNotFoundException.getMessage());
        errorResponse.setRequestedURL(httpServletRequest.getRequestURI());
        errorResponse.setErrorCode(HttpStatus.NOT_FOUND.toString());

        return errorResponse;
    }

    @ExceptionHandler(GenericSystemException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ErrorResponse handleGenericSystemException(GenericSystemException genericSysException , HttpServletRequest httpServletRequest){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorMessage(genericSysException.getMessage());
        errorResponse.setRequestedURL(httpServletRequest.getRequestURI());
        errorResponse.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());

        return errorResponse;
    }
}
