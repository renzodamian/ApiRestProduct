package com.rdjaramillo.ApiRestGestionProducto.repository;

import com.rdjaramillo.ApiRestGestionProducto.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Producto,Integer> {
}
