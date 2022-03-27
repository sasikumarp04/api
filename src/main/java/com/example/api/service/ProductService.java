package com.example.api.service;

import com.example.api.controller.exception.ProductNotFoundException;
import com.example.api.controller.model.ProductRequest;
import com.example.api.controller.model.ProductResponse;
import com.example.api.entity.Product;
import com.example.api.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    Logger log = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    public void createProduct(final ProductRequest productRequest) {
        Product product = buildProduct(productRequest);
        productRepository.save(product);
    }

    public void updateProduct(final int id, final ProductRequest productRequest) {
        //TODO add implementation to update product
    }

    public void deleteProduct(final int id) {
        productRepository.deleteById(id);
    }

    public ProductResponse getById(final int id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            log.error("Product not found for id [{}]", id);
            throw new ProductNotFoundException("Product not found");
        }
        return buildProductResponse(product.get());
    }

    private Product buildProduct(ProductRequest productRequest) {
        return Product.builder().setId(productRequest.getId())
                .setName(productRequest.getName())
                .setQty(productRequest.getQty())
                .build();
    }

    private ProductResponse buildProductResponse(Product product) {
        return ProductResponse.builder().setId(product.getId())
                .setName(product.getName())
                .setQty(product.getQty())
                .build();
    }

}
