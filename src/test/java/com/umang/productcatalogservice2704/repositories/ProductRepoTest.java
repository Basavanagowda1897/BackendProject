package com.umang.productcatalogservice2704.repositories;

import com.umang.productcatalogservice2704.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ProductRepoTest {

    @Autowired
    private ProductRepo productRepo;

    @Test
    @Transactional
    public void testJpaMethods(){
        //List<Product> products = productRepo.findByPriceBetween(250.0, 500.0);
        //System.out.println(products);

        List<Product> products = productRepo.findAllByOrderByPrice();
        System.out.println();

        String descr = productRepo.getDescriptionWhereIdIs(1L);
        System.out.println();
    }

}

/*
I want to find all products in a certain price range
 */

/*
ACID

SQL databases are also called as Transactional databases
 */