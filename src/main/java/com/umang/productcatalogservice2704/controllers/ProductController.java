package com.umang.productcatalogservice2704.controllers;


import com.umang.productcatalogservice2704.dtos.ProductDTO;
import com.umang.productcatalogservice2704.models.Product;
import com.umang.productcatalogservice2704.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    /*
    1. Get details of all products
    Type: GET
     */

    @Autowired
    private IProductService productService;


    @GetMapping("/products")
    public List<ProductDTO> getAllProducts(){
        return null;
    }


    @GetMapping("/products/{id}")
    public ProductDTO getProductById(@PathVariable("id") Long id){
        Product product = productService.getProductById(id);
        return product.toProductDto();
    }

    @PostMapping("/products")
    public ProductDTO createProduct(@RequestBody ProductDTO product){
        return null;
    }
    /*
    "name":
    "description":
    "price":
    "imageUrl":

    DTOs vs Models

    API contract
    /endpoint
    /http method
    request : { "name" : , "Description" : }
    response: {}
     */
}
