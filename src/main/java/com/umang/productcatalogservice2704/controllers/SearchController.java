package com.umang.productcatalogservice2704.controllers;

import com.umang.productcatalogservice2704.dtos.SearchRequestDTO;
import com.umang.productcatalogservice2704.models.Product;
import com.umang.productcatalogservice2704.services.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
    @Autowired
    private ISearchService searchService;

    /*
    Create /search endpoint
    HTTP : POST
    Request body: { DTO }
    Response: Page of products
     */

    @PostMapping("/search")
    public Page<Product> searchProducts(@RequestBody SearchRequestDTO searchRequestDTO){
        return searchService.searchProducts(
                searchRequestDTO.getQuery(),
                searchRequestDTO.getPageNo(),
                searchRequestDTO.getPageSize(),
                searchRequestDTO.getSortParams()
        );
    }
}
