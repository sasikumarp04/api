package com.example.api.controller.model;

import com.example.api.entity.Product;

public class ProductResponse {

    private int id;
    private String name;
    private int qty;

    public ProductResponse() {
    }

    public ProductResponse(int id, String name, int qty) {
        this.id = id;
        this.name = name;
        this.qty = qty;
    }

    public static ProductResponseBuilder builder() {
        return new ProductResponseBuilder();
    }

    public static class ProductResponseBuilder {

        private int id;
        private String name;
        private int qty;

        public ProductResponseBuilder setId(final int id) {
            this.id = id;
            return this;
        }

        public ProductResponseBuilder setName(final String name) {
            this.name = name;
            return this;
        }

        public ProductResponseBuilder setQty(final int qty) {
            this.qty = qty;
            return this;
        }

        public ProductResponse build() {
            return new ProductResponse(id, name, qty);
        }

    }
}
