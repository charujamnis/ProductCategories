package com.dtcc.projects.productcategories.services;

import com.dtcc.projects.productcategories.models.Category;
import com.dtcc.projects.productcategories.models.Product;
import com.dtcc.projects.productcategories.repositories.CategoryRepository;
import com.dtcc.projects.productcategories.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
    }

    public Category create(Category category){
        return categoryRepository.save(category);
    }

    public Iterable<Category> createAll(Iterable<Category> category){
        return categoryRepository.saveAll(category);
    }

    public Category showById(Long id){
        return categoryRepository.findById(id).get();
    }

    public Iterable<Category> showAll(){
        return categoryRepository.findAll();
    }

    public List<Category> findByProductNotContains(Product product){
        return categoryRepository.findByProductsNotContains(product);
    }
    public Category update(Category category){
        return categoryRepository.save(category);
    }

    public Category delete(Long id){
        Category categoryToDelete=showById(id);
        categoryRepository.delete(categoryToDelete);
        return categoryToDelete;
    }


}

