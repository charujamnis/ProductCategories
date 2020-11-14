package com.dtcc.projects.productcategories;

import com.dtcc.projects.productcategories.models.Product;
import com.dtcc.projects.productcategories.repositories.CategoryRepository;
import com.dtcc.projects.productcategories.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;
import java.util.Optional;

@SpringBootApplication
public class ProductCategoriesApplication {

    private static final Logger log = LoggerFactory.getLogger(ProductCategoriesApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ProductCategoriesApplication.class, args);
    }

   /* @Bean
    public CommandLineRunner demo(ProductRepository productRepository, CategoryRepository categoryRepository){
        return (args) -> {
            //save few products
            productRepository.save(new Product("Butter","Lite Olive Butter spread",4.99,new Date(),new Date()));
            productRepository.save(new Product("Oil","Wesson brand",7.50,new Date(),new Date()));
            productRepository.save(new Product("Tablet","Ipad-mini",250.99,new Date(),new Date()));

            //fetch all products.
            log.info("Products found with findAll(): ");
            log.info("---------------------------------");
            for(Product product : productRepository.findAll()){
                log.info(product.toString());
            }
            log.info(" ");

            //fetch an individual product by ID;
            Optional<Product> product=productRepository.findById(25L);
            log.info("Product found with findById(25L):");
            log.info("--------------------------------");
            log.info(product.toString());
            log.info("");
        };
    }*/
}
