package com.sathya.springbootmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sathya.springbootmvc.entity.ProductEntity;
import com.sathya.springbootmvc.model.ProductModel;
import com.sathya.springbootmvc.service.ProductService;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
	
	@GetMapping("/productform")
	public String greet() {
		return "add-product";
	}
	
	@PostMapping("/saveproduct")
	public String saveproduct (ProductModel productModel) {
		System.out.println(productModel);
		productService.saveproductDetails(productModel);
		return "success";
	}
	
	@GetMapping("/getallproducts")
	public String getAllproducts(Model model) {
		
		List<ProductEntity> products=productService.getAllProducts();
		model.addAttribute("Products", products);
		return "products-list";
	}
	
	@GetMapping("/getsearchform")
    public String  getsearchform()
    {
		return "search-product";
    	
    }
    @PostMapping("/searchid")
    public String searchById(@RequestParam Long id,Model model)
    {
    	ProductEntity productEntity=productService.searchById(id);
    	model.addAttribute("product",productEntity);
    	return "search-product";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteproductById(@PathVariable Long id)
    {
    	productService.deletetById(id);
    	return "redirect:/getallproducts";
    }
	

}


