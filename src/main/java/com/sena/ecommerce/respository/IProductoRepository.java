package com.sena.ecommerce.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.ecommerce.model.Productos;

@Repository
public interface IProductoRepository extends JpaRepository<Productos, Integer> {
	

}
