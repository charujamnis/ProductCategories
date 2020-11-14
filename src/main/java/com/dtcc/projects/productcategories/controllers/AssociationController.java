package com.dtcc.projects.productcategories.controllers;

import com.dtcc.projects.productcategories.models.Association;
import com.dtcc.projects.productcategories.models.Product;
import com.dtcc.projects.productcategories.services.AssociationService;
import com.dtcc.projects.productcategories.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AssociationController {

    @Autowired
    private AssociationService associationService;

    @Autowired
    private ProductService productService;

    private List<Product> productList;
    @RequestMapping(value="/associations/products",method=RequestMethod.POST)
    public String insertDataIntoCategoriesProducts(Model model, @ModelAttribute("association") Association associationObj){
        productList= (List<Product>) productService.showAll();
        model.addAttribute("products",productList);

        //save data into categories_products table.
        associationService.save(associationObj);
        return "/products/index";
    }

    @RequestMapping(value="/associations/categories",method=RequestMethod.POST)
    public String insertDataFromCategoryPage(Model model, @ModelAttribute("association1") Association associationObj){
        productList= (List<Product>) productService.showAll();
        model.addAttribute("products",productList);

        //save data into categories_products table.
        associationService.save(associationObj);
        return "/products/index";
    }
}


