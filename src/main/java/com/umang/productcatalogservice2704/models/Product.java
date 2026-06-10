package com.umang.productcatalogservice2704.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.umang.productcatalogservice2704.dtos.CategoryDTO;
import com.umang.productcatalogservice2704.dtos.FakestoreProductDto;
import com.umang.productcatalogservice2704.dtos.ProductDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Product extends BaseModel{
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private Category category;
    /*
    While creating a new product
     */

    public ProductDTO toProductDto(){
        /*
        This method is used to convert the Product object to a ProductDTO object.
         */
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(this.name);
        productDTO.setDescription(this.description);
        productDTO.setPrice(this.price);
        productDTO.setImageUrl(this.imageUrl);

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName(this.category.getName());
        categoryDTO.setDescription(this.category.getDescription());
        productDTO.setCategoryDTO(categoryDTO);

        return productDTO;
    }

    public FakestoreProductDto toFakestoreProductDto(){
        /*
        This method is used to convert the Product object to a FakestoreProductDto object.
         */
        FakestoreProductDto fakestoreProductDto = new FakestoreProductDto();
        fakestoreProductDto.setId(this.getId());
        fakestoreProductDto.setTitle(this.name);
        fakestoreProductDto.setDescription(this.description);
        fakestoreProductDto.setPrice(this.price);
        fakestoreProductDto.setImage(this.imageUrl);
        fakestoreProductDto.setCategory(this.category.getName());

        return fakestoreProductDto;
    }

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

/*
class A{
    B b;
}

Association relationship ("has-a")
Product Category => M : 1
1          1
M           1
 */