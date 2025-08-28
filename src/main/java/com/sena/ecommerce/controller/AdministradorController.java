package com.sena.ecommerce.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.ecommerce.model.Productos;
import com.sena.ecommerce.service.IProductoService;

//decirle a la clase que es de tipo controlador
@Controller
@RequestMapping("/administrador")//solicitud de mapeo al directorio administrador 
public class AdministradorController {
	
	// instancia LOGGER
		private final Logger LOGGER = (Logger) LoggerFactory.getLogger(ProductoController.class);

		@Autowired
		private IProductoService productoservice;
	
	@GetMapping("")
	public String home(Model model) {
		List<Productos> productos = productoservice.findALL();
		model.addAttribute("productos",productos);
		return "administrador/home";
	}
}
