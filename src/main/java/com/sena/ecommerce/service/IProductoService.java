package com.sena.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.sena.ecommerce.model.Productos;

public interface IProductoService {

	public Productos save(Productos producto);

	public Optional<Productos> get(Integer id);

	public void update(Productos producto);

	public void delete(Integer id);

	public List<Productos> findALL();
}
