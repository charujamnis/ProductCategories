package com.dtcc.projects.productcategories.controllers;

import com.dtcc.projects.productcategories.models.Association;
import com.dtcc.projects.productcategories.models.Category;
import com.dtcc.projects.productcategories.models.Product;
import com.dtcc.projects.productcategories.services.CategoryService;
import com.dtcc.projects.productcategories.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value="categories/{id}",method=RequestMethod.GET)
    public String showById(Model model,@PathVariable Long id){
        Category category=categoryService.showById(id);
        List<Product> productList= (List<Product>) productService.findByCategoriesNotContains(category);
        Association associationObj=new Association();
        model.addAttribute("category",category);
        model.addAttribute("association",associationObj);
        model.addAttribute("notInProducts",productList);
        return "categories/show";
    }

    @RequestMapping(value="/categories/category", method=RequestMethod.GET)
    public String getAllCategories(Model model){
        List<Category> categories= (List<Category>) categoryService.showAll();
        model.addAttribute("categories",categories);
        return "/categories/categoriesindex";
    }
    @RequestMapping(value="categories/newcategory", method=RequestMethod.GET)
    public String showNewCategory(Model model){
        Category category=new Category();
        model.addAttribute("newcategory",category);
        return "/categories/newcategory";
    }

    @RequestMapping(value="categories/createcategory", method=RequestMethod.POST)
    public String addNewCategory(@Valid @ModelAttribute("newcategory") Category category, BindingResult bindingResult){
        if (bindingResult.hasErrors()) { return "/categories/newcategory";}
        else {
            category.setCreatedate(new Date());
            category.setUpdatedate(new Date());
            categoryService.create(category);
            return "redirect:/viewcategories";
        }
    }

    @RequestMapping("/viewcategories")
    public String viewCategories(Model model){
        List<Category> categoryList= (List<Category>) categoryService.showAll();
        model.addAttribute("categories",categoryList);
        return "categories/categoriesindex";
    }
}

