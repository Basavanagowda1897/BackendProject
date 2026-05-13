package com.umang.productcatalogservice2704.services;

import com.umang.productcatalogservice2704.exceptions.ProductNotExistException;
import com.umang.productcatalogservice2704.models.Product;
import com.umang.productcatalogservice2704.models.State;
import com.umang.productcatalogservice2704.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("storageProductService")
public class StorageProductService implements IProductService{

    @Autowired
    private ProductRepo productRepo;
    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(Long id) throws ProductNotExistException {
        Optional<Product> optionalProduct = productRepo.findById(id);

        if(optionalProduct.isEmpty()){
            throw new ProductNotExistException("Product with id " + id + " does not exist.");
        }else{
            return optionalProduct.get();
        }
    }

    @Override
    public Product createProduct(Product product) {
        if(product.getId() != null){
            Optional<Product> optionalProduct = productRepo.findById(product.getId());
            if(optionalProduct.isPresent()){
                throw new RuntimeException("Product with id " + product.getId() + " already exists.");
            }
        }
        return productRepo.save(product);
    }

    @Override
    public Product replaceProduct(Product newProduct, Long id) {
        return null;
    }

    @Override
    public Boolean deleteProductById(Long id) {
        /*
        Soft delete
         */
        Optional<Product> optionalProduct = productRepo.findById(id);

        if(optionalProduct.isEmpty()){
            return false;
            //throw new RuntimeException("Product with id " + id + " does not exist.");
        }else{
            Product product = optionalProduct.get();
            product.setState(State.DELETED);
            productRepo.save(product);
            return true;
        }
    }

    /*

     */
}
