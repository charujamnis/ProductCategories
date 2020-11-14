package com.dtcc.projects.productcategories.repositories;

import com.dtcc.projects.productcategories.models.Category;
import com.dtcc.projects.productcategories.models.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {
   // List<Category> findAll();
    List<Category> findByProductsNotContains(Product product);
}
