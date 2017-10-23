package com.nannoprice.api.model;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Budget {

    @Id
    private String id;

    private List<Product> products;

    private Double totalBudget;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Double getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(Double totalBudget) {
        this.totalBudget = totalBudget;
    }
}
