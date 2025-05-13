package com.example.tuempresa.model;

import java.util.List;

public class Order {

    private String id;
    private String email;
    private List<String> productos;

    public Order() {
    }

    public Order(String id, String email, List<String> productos) {
        this.id = id;
        this.email = email;
        this.productos = productos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getProductos() {
        return productos;
    }

    public void setProductos(List<String> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", productos=" + productos +
                '}';
    }
}
