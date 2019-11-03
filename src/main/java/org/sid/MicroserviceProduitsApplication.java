package org.sid;

import net.bytebuddy.utility.RandomString;
import org.sid.dao.CategoryRepository;
import org.sid.dao.ProductRepository;
import org.sid.entities.Category;
import org.sid.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Random;

@SpringBootApplication
@EnableConfigurationProperties
@EnableDiscoveryClient
public class MicroserviceProduitsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceProduitsApplication.class, args);
    }


    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;


    @Override
    public void run(String... args) throws Exception {

       /* repositoryRestConfiguration.exposeIdsFor(Product.class, Category.class);

        categoryRepository.save(new Category(null,"Computers",null,null,null));
        categoryRepository.save(new Category(null,"Printers",null,null,null));
        categoryRepository.save(new Category(null,"Smart phones",null,null,null));
        Random rnd=new Random();
        categoryRepository.findAll().forEach(c->{
            for (int i = 0; i <10 ; i++) {
                Product p=new Product();
                p.setName(RandomString.make(18));
                p.setCurrentPrice(100+rnd.nextInt(10000));
                p.setAvailable(rnd.nextBoolean());
                p.setPromotion(rnd.nextBoolean());
                p.setSelected(rnd.nextBoolean());
                p.setCategory(c);
                p.setPhotoName("unknown.png");
                productRepository.save(p);
            }
        });*/
    }

}
