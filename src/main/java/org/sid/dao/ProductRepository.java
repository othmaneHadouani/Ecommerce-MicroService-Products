package org.sid.dao;

import org.sid.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("*")
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
    /*@RestResource(path = "/selectedProducts")
    public List<Product> findBySelectedIsTrue();
    @RestResource(path = "/productsByKeyword")
    public List<Product> findByNameContains(@Param("mc") String mc);
    @RestResource(path = "/promoProducts")
    public List<Product> findByPromotionIsTrue();
    @RestResource(path = "/dispoProducts")
    public List<Product> findByAvailableIsTrue();*/


    @Query("select p from Product p where p.name like :x ")
    public Page<Product> chercherProductsPerMotCle(@Param("x") String motCle, Pageable pageable);



    @Query("select p from Product p inner join p.category c where p.name like :x and c.id=:y")
    public Page<Product> chercherProductsPerCategoryandMotCle(@Param("x") String motCle, @Param("y") Long idCat, Pageable pageable);


    @Query("select p from Product p where p.name like :x and p.selected=true ")
    public Page<Product> chercherSelectedProductsPerMotCle(@Param("x") String motCle, Pageable pageable);


    @Query("select p from Product p where p.name like :x and p.available=true ")
    public Page<Product> chercherDispoProductsPerMotCle(@Param("x") String motCle, Pageable pageable);


    @Query("select p from Product p where p.name like :x and p.promotion=true ")
    public Page<Product> chercherPromotionProductsPerMotCle(@Param("x") String motCle, Pageable pageable);
}
