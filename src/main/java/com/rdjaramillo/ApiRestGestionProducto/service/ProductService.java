package com.rdjaramillo.ApiRestGestionProducto.service;

import com.rdjaramillo.ApiRestGestionProducto.entity.Producto;
import com.rdjaramillo.ApiRestGestionProducto.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    //List product
    public List<Producto> listProducts(){
        return productRepository.findAll();
    }
    //Save Product
    public void saveproduct(Producto producto){
        productRepository.save(producto);
    }

    //Get Product by Id
    public Producto getProductsById(Integer id){
        return productRepository.findById(id).get();
    }

    //Delete Product
    public void deleteproduct(Integer id){
        productRepository.deleteById(id);
    }


}
