package com.sena.ecommerce.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.ecommerce.model.Productos;
import com.sena.ecommerce.model.Usuario;
import com.sena.ecommerce.service.IProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	// instancia LOGGER
	private final Logger LOGGER = (Logger) LoggerFactory.getLogger(ProductoController.class);

	@Autowired
	private IProductoService productoservice;

	// metodo de listar productos
	@GetMapping("")
	public String show(Model model) {
		model.addAttribute("productos", productoservice.findALL());
		return "productos/show";
	}

	// metodo de redireccionamiento al formulario de creación de productos
	@GetMapping("/create")
	public String create() {
		return "productos/create";
	}

	// metodo de creación de productos
	@PostMapping("/save")
	public String save(Productos producto) {
		LOGGER.info("Este es el objeto del producto a guardar de la database {}", producto);
		Usuario u = new Usuario(1, "", "", "", "", "", "", "", "");
		producto.setUsuario(u);
		productoservice.save(producto);
		return "redirect:/productos";
	}

	// metodo para el formulario de edición de productos
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Productos p = new Productos();
		// nos retorna la busqueda de un objeto de tipo producto con el id
		Optional<Productos> op = productoservice.get(id);
		p = op.get();
		LOGGER.warn("EBusqueda de producto por id {}", p);
		model.addAttribute("producto", p);
		return "productos/edit";
	}

	// metodo de actualización de datos
	@PostMapping("/update")
	public String update(Productos productos) {
		LOGGER.info("Este es el objeto del producto a actualizar de la database {}", productos);
		Usuario u = new Usuario(1, "", "", "", "", "", "", "", "");
		productos.setUsuario(u);
		productoservice.update(productos);
		return "redirect:/productos";
	}

	// metodo para eliminar con id un producto
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		productoservice.delete(id);
		return "redirect:/productos";
	}
}
