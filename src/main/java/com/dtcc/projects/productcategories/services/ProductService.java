package com.dtcc.projects.productcategories.services;

import com.dtcc.projects.productcategories.models.Category;
import com.dtcc.projects.productcategories.models.Product;
import com.dtcc.projects.productcategories.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    public Product create(Product product){
        //System.out.println("The product id is "+product.getId());
        return productRepository.save(product);
    }

    public Iterable<Product> createAll(Iterable<Product> product){
        return productRepository.saveAll(product);
    }

    public Product showById(Long id){
      //  return productRepository.findById(id).orElse(null);
        return productRepository.findById(id).get();
    }

    public Iterable<Product> showAll(){
        return productRepository.findAll();
    }

    public List<Product> findByCategoriesNotContains(Category category){
        return productRepository.findByCategoriesNotContains(category);
    }
    //public Product update(Long id,String name,String description, Double price){
        public Product update(Product product){
        System.out.println("The product id in updated "+product.getId());
        /*Product product=showById(id);
        if (name != null) {
            product.setName(name);
        } else {
            product.setName(product.getName());
        }
        if(description !=null){
            product.setDescription(description);
        }else{
            product.setDescription(product.getDescription());
        }
        if(price !=null){
            product.setPrice(price);
        }else {
            product.setPrice(product.getPrice());
        }

        product.setUpdatedate(new Date());*/
        return productRepository.save(product);
    }

    public Product delete(Long id){
        Product productToDelete=showById(id);
        productRepository.delete(productToDelete);
        return productToDelete;
    }
}

