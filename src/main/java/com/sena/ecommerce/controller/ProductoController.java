package com.sena.ecommerce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.ecommerce.model.Productos;
import com.sena.ecommerce.model.Usuario;
import com.sena.ecommerce.service.IProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	//instancia LOGGER
	private final Logger LOGGER = (Logger) LoggerFactory.getLogger(ProductoController.class);
	
	@Autowired
	private IProductoService productoservice;

	@GetMapping("")
	public String show(Model model) {
		model.addAttribute("productos", productoservice.findALL());
		return "productos/show";
	}
	
	@GetMapping("/create")
	public String create() {
		return "productos/create";
	}
	
	@PostMapping("/save")
	public String save(Productos producto) {
		LOGGER.info("Este es el objeto del producto a guardar de la database {}", producto);
		Usuario u  = new Usuario(1, "", "", "", "", "", "", "", "");
		producto.setUsuario(u);
		productoservice.save(producto);
		return "redirect:/productos";
	}

}
