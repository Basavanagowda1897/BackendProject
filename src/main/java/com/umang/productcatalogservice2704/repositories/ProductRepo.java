package com.umang.productcatalogservice2704.repositories;

import com.umang.productcatalogservice2704.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
     /*
     This interface is used to perform CRUD operations on the Product entity.
     It extends the JpaRepository interface which provides methods for CRUD operations.
      */

    /*
     */
    Page<Product> findByName(String name, Pageable pageable); //working

    @Override
    Optional<Product> findById(Long id);

    @Override
    List<Product> findAll();

    @Override
    Product save(Product product);

    List<Product> findByPriceBetween(Double minPrice, Double maxPrice); //working

    List<Product> findAllByOrderByPrice();


    /*
    get description of a product where id = 1
     */
    @Query(value = "SELECT p.description FROM Product p WHERE p.id = :id")
    String getDescriptionWhereIdIs(Long id);

    /*
    HQL  (Hibernate Query language)
    Native SQL
     */
}
/*
MVC pattern


Client -> Controller -> Service -> Repository -> Database

getProductByID

select * from products
where p.id = id;

However, we will JPA inbuilt methods
 */