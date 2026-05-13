package com.umang.productcatalogservice2704.advisors;

import com.umang.productcatalogservice2704.exceptions.ProductNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/*
throwing ProductNotExist exception from 100 places in the code
try{
throw new ProductNotExistException("Product with id " + id + " does not exist");
}catch(){
    handle
}



 */
@RestControllerAdvice
public class ControllerAdvisor {

    /*
    random methods
     */

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        // Return the error message from the exception + 400 Bad Request
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointer(NullPointerException ex) {
        return new ResponseEntity<>("Something went wrong internally", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ProductNotExistException.class)
    public ResponseEntity<String> handleProductNotExistException(ProductNotExistException e){
        //log the exception
        //return a custom error response to the client
        return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
    }

}

/*
Diff between monorepo and microservice

10 services

Deployment strategy
 */
