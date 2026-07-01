package com.umang.productcatalogservice2704.services;

import com.umang.productcatalogservice2704.dtos.SortParam;
import com.umang.productcatalogservice2704.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ISearchService {

    Page<Product> searchProducts(String query,
                                 int pageNo,
                                 int pageSize,
                                 List<SortParam> sortParams);
}
