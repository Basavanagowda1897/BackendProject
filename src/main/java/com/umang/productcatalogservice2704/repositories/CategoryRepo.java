package com.umang.productcatalogservice2704.repositories;

import com.umang.productcatalogservice2704.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
        /*
        This interface is used to perform CRUD operations on the Category entity.
        It extends the JpaRepository interface which provides methods for CRUD operations.
        */
}
