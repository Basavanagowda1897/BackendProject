package com.umang.productcatalogservice2704.dtos;

import com.umang.productcatalogservice2704.models.Category;
import com.umang.productcatalogservice2704.models.Product;

public class ProductDTO {
    /*
    represents the data that we want to send to the client or receive from the client.
    It is a simplified version of the Product model that only contains the necessary fields for the API. It is used to decouple the internal representation of the data from the external representation of the data. It also helps to prevent over-posting and under-posting of data.
     */

    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private CategoryDTO categoryDTO;

    public Product toProduct(){
        /*
        This method is used to convert the ProductDTO object to a Product object.
         */
        Product product = new Product();
        product.setName(this.name);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImageUrl(this.imageUrl);

        CategoryDTO categoryDTO = this.categoryDTO;
        if(categoryDTO != null){
            Category category = new Category();
            category.setName(categoryDTO.getName());
            category.setDescription(categoryDTO.getDescription());
            product.setCategory(category);
        }

        return product;
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

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }
}
