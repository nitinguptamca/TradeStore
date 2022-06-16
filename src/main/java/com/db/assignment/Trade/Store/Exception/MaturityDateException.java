package com.db.assignment.Trade.Store.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MaturityDateException extends RuntimeException{
    public MaturityDateException(String exception){
        super(exception);
    }
}
