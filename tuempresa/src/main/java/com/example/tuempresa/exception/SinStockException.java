package com.example.tuempresa.exception;

public class SinStockException extends RuntimeException {
    public SinStockException(String message) {
        super(message);
    }
}
