package com.umang.productcatalogservice2704.services;

import com.umang.productcatalogservice2704.dtos.FakestoreProductDto;
import com.umang.productcatalogservice2704.exceptions.ProductNotExistException;
import com.umang.productcatalogservice2704.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakestoreProductService implements IProductService{

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public List<Product> getAllProducts() {
        //call fakestore apis
        /*
        /products , GET
         */
        FakestoreProductDto[] fakestoreProductDtos = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakestoreProductDto[].class
        );

        /*
        HW
        Type erasure in Collections library
        List is part of collections?
        <T>
        List<T>
         */
        /*
        Convert the array of fakestoreProductDtos to List of Products and return

        HW
         */
        return null;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotExistException {

        ResponseEntity<FakestoreProductDto> fakestoreProductDto = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/{id}",
                FakestoreProductDto.class,
                id
        );
        /*
        Convert the fakestoreProductDto to Product and return
        Map fakestoreProductDto to Product
         */
        if(fakestoreProductDto.getStatusCode().equals(HttpStatusCode.valueOf(200))){
            if(fakestoreProductDto.getBody() != null){
                return fakestoreProductDto.getBody().toProduct();
            }else{
                throw new ProductNotExistException("Product with id " + id + " does not exist");
            }
        }else{
            throw new ProductNotExistException("Product with id " + id + " does not exist");
        }
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }
}
/*
Compile and runtime

Compile time exceptions are inherited from Exceptions class
Runtime exceptions are inherited from RuntimeException class
 */