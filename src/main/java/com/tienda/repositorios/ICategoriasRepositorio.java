package com.tienda.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.modelos.Categorias;

public interface ICategoriasRepositorio extends JpaRepository<Categorias, Integer>{
	
}