package com.dtcc.projects.productcategories.controllers;

import com.dtcc.projects.productcategories.models.Association;
import com.dtcc.projects.productcategories.models.Category;
import com.dtcc.projects.productcategories.models.Product;
import com.dtcc.projects.productcategories.services.CategoryService;
import com.dtcc.projects.productcategories.services.ProductService;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value="/",method=RequestMethod.GET)
    public String showIndexPage(Model model){

        List<Product> productList= (List<Product>) productService.showAll();
        model.addAttribute("products",productList);
        return "products/index";
    }

    @RequestMapping(value="products/{id}",method=RequestMethod.GET)
    public String showById(Model model,@PathVariable Long id){
        Product product=productService.showById(id);
        System.out.println("product: "+product);
        List<Category> categoryList= (List<Category>) categoryService.findByProductNotContains(product);
        Association associationObject = new Association();
        model.addAttribute("product",product);
        model.addAttribute("association",associationObject);
        model.addAttribute("notInCategories",categoryList);
        return "products/show";
    }

    @RequestMapping(value="products/newproduct", method=RequestMethod.GET)
    public String showNewProduct(Model model){
        Product product=new Product();
        model.addAttribute("newproduct",product);
        return "/products/newproduct";
    }

    //@ModelAttribute to read the data from the submitted form.
    //to bind form data to java object.
    @RequestMapping(value="products/createproduct", method=RequestMethod.POST)
    public String addNewProduct(@Valid @ModelAttribute("newproduct") Product product, BindingResult bindingResult){

        if(bindingResult.hasErrors()){return "products/newproduct";}
        else {
            product.setCreatedate(new Date());
            product.setUpdatedate(new Date());
            productService.create(product);
            //return "redirect:/";
            return "redirect:/viewproducts";
        }
    }

    @RequestMapping("/viewproducts")
    public String viewProducts(Model model){
        System.out.println("in view products");
        List<Product> productList= (List<Product>) productService.showAll();
        model.addAttribute("products",productList);
        return "products/index";
    }

}
