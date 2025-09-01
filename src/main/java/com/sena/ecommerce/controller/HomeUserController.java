package com.sena.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.ecommerce.service.IProductoService;

@Controller
@RequestMapping("/")
public class HomeUserController {
	// instancia de producto service
	@Autowired // se instancia producto servise del paquete service
	private IProductoService productoService;

	@GetMapping("")
	public String home(Model model) {
		model.addAttribute("productos", productoService.findALL());
		return "usuario/home";
	}
}
