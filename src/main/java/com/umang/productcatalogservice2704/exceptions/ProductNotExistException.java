package com.umang.productcatalogservice2704.exceptions;

public class ProductNotExistException extends Exception{
    public ProductNotExistException(String message) {
        super(message);
    }
}



/*
Today's agenda items
1. Implementing getAllProducts()
    -Handling type erasure and java generics
2. Implement replaceProduct() API
    -Hack postForEntity
3. Create Fakestore API client
4. Exception handler / Controller advice
 */