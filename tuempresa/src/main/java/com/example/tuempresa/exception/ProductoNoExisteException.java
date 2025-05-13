package com.example.tuempresa.exception;

public class ProductoNoExisteException extends RuntimeException {
    public ProductoNoExisteException(String nombreProducto) {
        super("El producto no existe: " + nombreProducto);
    }
}
