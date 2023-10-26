package com.tienda.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tienda.modelos.Productos;
import com.tienda.repositorios.IProductosRepositorio;

@Controller
public class TiendaController {
	@Autowired
	private IProductosRepositorio productosRepo;
	
	@GetMapping("/")
	public String menuPrincipal(Model model) {
		List<Productos> productos = productosRepo.findAll();
		model.addAttribute("productos", productos);
		return "catalogo";
	}
	
	@GetMapping("/carrito")
	public String listarCarrito(Model model) {
		List<Productos> productos = productosRepo.findAll();
		model.addAttribute("productos", productos);
		return "carrito";
	}
	
	@GetMapping("/agregar")
	public String agregarProducto(Model model) {
		model.addAttribute("productos", new Productos());
		return "agregarProducto";
	}
	
	@PostMapping("/guardar")
	public String guardarProducto(@ModelAttribute Productos productos) {
		productosRepo.save(productos);
		return "redirect:/";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarProducto(@PathVariable Integer id) {
		productosRepo.deleteById(id);
		return "redirect:/carrito";
	}
	
	@GetMapping("/editar/{id}")
	public String editarProducto(@PathVariable Integer id, Model model) {
		Productos productos= productosRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("ID de producto no válido"));
		model.addAttribute("productos", productos);
		return "editarProducto"; // Vista de edición
	}
}
