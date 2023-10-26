package com.tienda.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.modelos.Productos;

public interface IProductosRepositorio extends JpaRepository<Productos, Integer>{
	
}