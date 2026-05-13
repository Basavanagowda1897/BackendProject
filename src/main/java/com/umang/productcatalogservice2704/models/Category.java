package com.umang.productcatalogservice2704.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Category extends BaseModel{
    private String name;
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    /*
    I want to fetch a category from the db
    id, name, description
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}


/*

P : C = > M : 1
Category : Product => 1:M
1          M
 1       1


ORM will create schema

products
id, name, description, price, image_url, category_id (foreign key)

categories
id, name, description
 */