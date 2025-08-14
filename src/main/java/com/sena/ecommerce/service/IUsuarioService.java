package com.sena.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.sena.ecommerce.model.Usuario;

public interface IUsuarioService {

	public Usuario save(Usuario usuario);

	public Optional<Usuario> get(Integer id);

	public void update(Usuario usuario);

	public void delete(Integer id);
	
	Optional<Usuario> FinById(Integer id);
	
	Optional<Usuario> FindByEmail(String email);
	
	List<Usuario> findALL();
}
