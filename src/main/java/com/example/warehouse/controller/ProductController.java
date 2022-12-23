package com.example.warehouse.controller;

import com.example.warehouse.entity.Orders;
import com.example.warehouse.entity.Products;
import com.example.warehouse.repository.ProductsRepository;
import com.example.warehouse.service.ProductsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class ProductController {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private ProductsService productsService;

    @GetMapping("/products")
    public String products(Model model){
        model.addAttribute("products", productsRepository.findAll());
        return "products";
    }

    @GetMapping("/product/add")
    public String addProduct(Model model){
        Products product = new Products();
        model.addAttribute("product", product);
        return "addProduct";
    }

    @PostMapping("/product/add")
    public String addProduct(@Valid Products products,
                             BindingResult bindingResult,
                             Model model){

        if(bindingResult.hasErrors()){
            Map<String, String> errMap = ControllerUtils.getErrors(bindingResult);
            model.addAttribute(errMap);
            model.addAttribute("message", products);
        }else{
            model.addAttribute("message", null);

            productsService.addProduct(products);
        }
        return "redirect:/products";
    }

    @GetMapping("/product/edit/{id}")
    public String productEditForm(Model model,
                                  @PathVariable(value = "id") long id){
        model.addAttribute("product", productsRepository.findById(id).get());
        return "productEdit";
    }

    @PostMapping("/product/edit/{id}")
    public String productSave(@RequestParam("productId") Products products,
                           @RequestParam String name,
                           @RequestParam String brand,
                           @RequestParam String description){
        productsService.saveProduct(products, name, brand, description);
        return "redirect:/products";
    }

    @GetMapping("/product/cancel")
    public String productCancel(){
        return "redirect:/products";
    }

}
