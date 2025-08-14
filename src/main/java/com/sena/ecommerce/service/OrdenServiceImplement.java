package com.sena.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.ecommerce.model.Orden;
import com.sena.ecommerce.model.Usuario;
import com.sena.ecommerce.respository.IOrdenRepository;

@Service
public class OrdenServiceImplement implements IOrdenService{

	@Autowired
	private IOrdenRepository ordenRepository;
	
	@Override
	public Orden save(Orden orden) {
		// TODO Auto-generated method stub
		return ordenRepository.save(orden);
	}

	@Override
	public Optional<Orden> get(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Orden> findALL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orden> findALL(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generarNumeroOrden() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
