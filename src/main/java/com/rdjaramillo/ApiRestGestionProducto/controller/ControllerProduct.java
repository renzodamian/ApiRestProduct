package com.rdjaramillo.ApiRestGestionProducto.controller;

import com.rdjaramillo.ApiRestGestionProducto.entity.Producto;
import com.rdjaramillo.ApiRestGestionProducto.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Producto> getProductById(@PathVariable Integer id){
        try {
           Producto product = productService.getProductsById(id);
           return new ResponseEntity<Producto>(product, HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/products")
    public void saveProduct(@RequestBody Producto producto){
        productService.saveproduct(producto);
    }

    @PutMapping("/products/{id}")
    //<?> Cualquier tipo de datos
    public ResponseEntity<?> updateProduct(@RequestBody Producto product, @PathVariable Integer id){
        try {
            Producto productoActual = productService.getProductsById(id);
            productoActual.setName(product.getName());
            productoActual.setPrice(product.getPrice());
            productService.saveproduct(productoActual);
            return new ResponseEntity<Producto>(HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productService.deleteproduct(id);

    }
}

