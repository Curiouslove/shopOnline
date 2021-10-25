package com.ecommerce.shop.data.model;

public enum Currency {
    NGN("Naira"), USD("Dollar"), SRC("Singapore Dollar"), GBP("British Pound"), FRC("Franc"), GHC("Ghana Cedis");

    private String name;
    Currency(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
