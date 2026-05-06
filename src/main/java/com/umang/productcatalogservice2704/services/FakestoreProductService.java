package com.umang.productcatalogservice2704.services;

import com.umang.productcatalogservice2704.clients.FakestoreAPIClient;
import com.umang.productcatalogservice2704.dtos.FakestoreProductDto;
import com.umang.productcatalogservice2704.exceptions.ProductNotExistException;
import com.umang.productcatalogservice2704.models.Product;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakestoreProductService implements IProductService {

//    public <T> ResponseEntity<T> putForEntity(String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
//        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
//        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
//        return restTemplate.execute(url, HttpMethod.PUT, requestCallback, responseExtractor, uriVariables);
//    }

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private FakestoreAPIClient fakestoreAPIClient;

    @Override
    public List<Product> getAllProducts() {
        //call fakestore apis
        /*
        /products , GET
         */
        List<Product> products = new ArrayList<>();

        ResponseEntity<FakestoreProductDto[]> fakestoreProductDtos = fakestoreAPIClient.requestForEntity(
                HttpMethod.GET,
                "https://fakestoreapi.com/products",
                null,
                FakestoreProductDto[].class
        );

        if (fakestoreProductDtos.getBody() != null &&
                fakestoreProductDtos.getStatusCode().equals(HttpStatusCode.valueOf(200))) {
            for (FakestoreProductDto fakestoreProductDto : fakestoreProductDtos.getBody()) {
                products.add(fakestoreProductDto.toProduct());
            }
            return products;
        }
        return null;

        /*
        <T>
        Type erasure
        Generics is generally helpful at Compile time checks
        List<String> vs List<Integer>

        RunTime, Java erases the specific type (Type erasure)
        List<String> just becomes List
        List<FakestoreProductDto> also becomes List
        Why??
        List<T>
        Array

        raw Response from an api call
         */

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

    }

    @Override
    public Product getProductById(Long id) throws ProductNotExistException {

        ResponseEntity<FakestoreProductDto> fakestoreProductDto = fakestoreAPIClient.requestForEntity(
                HttpMethod.GET,
                "https://fakestoreapi.com/products/{id}",
                null,
                FakestoreProductDto.class,
                id
        );
        /*
        Convert the fakestoreProductDto to Product and return
        Map fakestoreProductDto to Product
         */
        if (fakestoreProductDto.getStatusCode().equals(HttpStatusCode.valueOf(200))) {
            if (fakestoreProductDto.getBody() != null) {
                return fakestoreProductDto.getBody().toProduct();
            } else {
                throw new ProductNotExistException("Product with id " + id + " does not exist");
            }
        } else {
            throw new ProductNotExistException("Product with id " + id + " does not exist");
        }
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    /*
    product object {}
    After replace, i'll get back the same product
     */
    @Override
    public Product replaceProduct(Product newProduct, Long id) { //Inside our business logic, we can deal in models/entities
        ResponseEntity<FakestoreProductDto> response = fakestoreAPIClient.requestForEntity(
                HttpMethod.PUT,
                "https://fakestoreapi.com/products/{id}",
                newProduct.toFakestoreProductDto(), //FakestoreProductDTO
                FakestoreProductDto.class,
                id
        );

        if (response.getBody() != null &&
                response.getStatusCode().equals(HttpStatusCode.valueOf(200))) {
            return response.getBody().toProduct();
        }

        return null;
    }
}
/*
Compile and runtime

Compile time exceptions are inherited from Exceptions class
Runtime exceptions are inherited from RuntimeException class

Implement replaceProduct()
Theory:-
1. What is the difference between PUT and PATCH HTTP methods?


replace / PUT: It is used for Replacing a resource completely.
    If you send an object, the old one is entirely removed and replaced by the new one.
update / PATCH: It is used for Partial Updates.
    For example, if you only want to change the price of a product but keep the name and description same, you use PATCH.



Exception Handling
Local handling vs Controller advice

 */