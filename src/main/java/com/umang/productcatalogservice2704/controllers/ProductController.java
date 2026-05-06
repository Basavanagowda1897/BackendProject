package com.umang.productcatalogservice2704.controllers;


import com.umang.productcatalogservice2704.dtos.ProductDTO;
import com.umang.productcatalogservice2704.exceptions.ProductNotExistException;
import com.umang.productcatalogservice2704.models.Product;
import com.umang.productcatalogservice2704.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
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
    public List<ProductDTO> getAllProducts() throws SQLException, ClassNotFoundException {
        List<Product> products = productService.getAllProducts();
        List<ProductDTO> productDTOS = new ArrayList<>();

        for(Product product: products){
            productDTOS.add(product.toProductDto());
        }
        return productDTOS;
    }


    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Long id) throws ProductNotExistException {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product.toProductDto());
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

    /*
    Replace product API
    Earlier product with id 1 was:-
    {
    "name": "Old Product Name",
    "description": "Old Product Description",
    "price": 49.99,
    "imageUrl": "https://example.com/old-product-image.jpg",
    }
    /products/1
    {
    "name": "New Product Name",
    "description": "New Product Description",
    "price": 99.99,
    "imageUrl": "https://example.com/new-product-image.jpg",
    }

    so the product with id 1 becomes
    {
    "name": "New Product Name",
    "description": "New Product Description",
    "price": 99.99,
    "imageUrl": "https://example.com/new-product-image.jpg",
    }

     */
    @PutMapping("/products/{id}")
    public ProductDTO replaceProduct(@PathVariable("id") Long productId,
                                     @RequestBody ProductDTO productDTO) {
        //Convert ProductDTO to a product

        Product product = productDTO.toProduct();

        //Call the service layer to replace the product
        Product response = productService.replaceProduct(
                product,
                productId);

        //Return result

        return response.toProductDto();

        //A --> B it's better to write the mapper inside A
        //Since inside A, you'll have access to this keyword
        //A.toB() method can access all the properties of A and map it to B

    }
    /*
    Frontend app calls the apis hosted in backend app
     */

    //Local exception handlers

}
