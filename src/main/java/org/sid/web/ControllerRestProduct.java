package org.sid.web;


import org.sid.dao.ProductRepository;
import org.sid.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin("*")
@RestController

public class ControllerRestProduct {

    @Autowired
    private ProductRepository productRepository;
/*
    @GetMapping(path = "/selectedProducts")
    public List<Product> getSelectedProducts(){
        return this.productRepository.findBySelectedIsTrue();
    }*/




    @GetMapping(path = "/products")
    public Page<Product> getProductsPerMotCle(
            @RequestParam(name = "motCle",defaultValue = "") String motCle ,
            @RequestParam(name = "size",defaultValue = "8")int size,
            @RequestParam(name = "page",defaultValue = "0")int page
            ){

        Page<Product> products;
        products=  productRepository.chercherProductsPerMotCle("%"+motCle+"%",new PageRequest(page,size));
        return products;
    }

    @GetMapping(path = "/products/{id}")
    public Product getProductsById(
            @PathVariable("id") Long id
    ){

        Optional<Product> product;
        product=  productRepository.findById(id);
        return product.get();
    }

    @GetMapping(path = "/categories/products")
    public Page<Product> getProductsPerCategorieAndMotCle(
            @RequestParam(name = "idCat") Long idCat ,
            @RequestParam(name = "motCle",defaultValue = "") String motCle ,
            @RequestParam(name = "size",defaultValue = "8")int size,
            @RequestParam(name = "page",defaultValue = "0")int page
    ){

        Page<Product> products;
        products=  productRepository.chercherProductsPerCategoryandMotCle("%"+motCle+"%",idCat,new PageRequest(page,size));
        return products;
    }

    @GetMapping(path = "/selectedProducts")
    public Page<Product> getSelectedProductsPerMotCle(
            @RequestParam(name = "motCle",defaultValue = "") String motCle ,
            @RequestParam(name = "size",defaultValue = "8")int size,
            @RequestParam(name = "page",defaultValue = "0")int page
    ){

        Page<Product> products;
        products=  productRepository.chercherSelectedProductsPerMotCle("%"+motCle+"%",new PageRequest(page,size));
        return products;
    }


    @GetMapping(path = "/disponibleProducts")
    public Page<Product> getDisponibleProductsPerMotCle(
            @RequestParam(name = "motCle",defaultValue = "") String motCle ,
            @RequestParam(name = "size",defaultValue = "8")int size,
            @RequestParam(name = "page",defaultValue = "0")int page
    ){

        Page<Product> products;
        products=  productRepository.chercherDispoProductsPerMotCle("%"+motCle+"%",new PageRequest(page,size));
        return products;
    }

    @GetMapping(path = "/promotionProducts")
    public Page<Product> getPromotionProductsPerMotCle(
            @RequestParam(name = "motCle",defaultValue = "") String motCle ,
            @RequestParam(name = "size",defaultValue = "8")int size,
            @RequestParam(name = "page",defaultValue = "0")int page
    ){

        Page<Product> products;
        products=  productRepository.chercherPromotionProductsPerMotCle("%"+motCle+"%",new PageRequest(page,size));
        return products;
    }
}
