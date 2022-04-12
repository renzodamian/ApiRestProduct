package com.rdjaramillo.ApiRestGestionProducto.controller;

import com.rdjaramillo.ApiRestGestionProducto.entity.Producto;
import com.rdjaramillo.ApiRestGestionProducto.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerProduct {
     @Autowired
    private ProductService productService;

     @GetMapping("/products")
     public List<Producto> listProduct(){
         return productService.listProducts();
     }

    @GetMapping("/products/{id}")
    public Producto getProductById(@PathVariable Integer id){
        return productService.getProductsById(id);
    }

}
