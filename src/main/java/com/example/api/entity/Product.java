package com.example.api.entity;

import javax.persistence.Entity;

@Entity
public class Product {

    private int id;
    private String name;
    private int qty;

    public Product() {
    }

    public Product(int id, String name, int qty) {
        this.id = id;
        this.name = name;
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQty() {
        return qty;
    }

    public static ProductBuilder builder() {
        return new ProductBuilder();
    }

    public static class ProductBuilder {

        private int id;
        private String name;
        private int qty;

        public ProductBuilder setId(final int id) {
            this.id = id;
            return this;
        }

        public ProductBuilder setName(final String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder setQty(final int qty) {
            this.qty = qty;
            return this;
        }

        public Product build() {
            return new Product(id, name, qty);
        }

    }

}
