package org.sid.web;


import org.sid.dao.CategoryRepository;
import org.sid.dao.ProductRepository;
import org.sid.entities.Category;
import org.sid.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController

public class ControllerRestCategories {

    @Autowired
    private CategoryRepository categoryRepository;
/*
    @GetMapping(path = "/selectedProducts")
    public List<Product> getSelectedProducts(){
        return this.productRepository.findBySelectedIsTrue();
    }*/




    @GetMapping(path = "/categories")
    public List<Category> getProductsPerMotCle(

            ){
        return this.categoryRepository.findAll();
    }

    /*@GetMapping(path = "/categories/{id}")
    public Product getProductsById(
            @PathVariable("id") Long id
    ){

        Optional<Product> product;
        product=  productRepository.findById(id);
        return product.get();
    }*/


}
