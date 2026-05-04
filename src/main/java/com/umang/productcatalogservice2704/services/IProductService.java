package com.umang.productcatalogservice2704.services;

import com.umang.productcatalogservice2704.exceptions.ProductNotExistException;
import com.umang.productcatalogservice2704.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id) throws ProductNotExistException;
    Product createProduct(Product product);
}



/*
As soon as you run spring app, spring identifies all special classes and creates their
objects and also injects wherever required.
 */