package com.sena.ecommerce.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//anotaciones jpa
@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;
	private String Nombre;
	private String Username;
	private String Email;
	private String Documento;
	private String Direccion;
	private String Telefono;
	private String Password;
	private String tipo;

	// relaciones DB(database)
	@OneToMany(mappedBy = "usuario")
	private List<Productos> Produtos;

	@OneToMany(mappedBy = "usuario")
	private List<Orden> Ordenes;

	// metodo contructor vacio
	public Usuario() {

	}

	// metodo constructor con campos
	public Usuario(Integer id, String nombre, String username, String email, String documento, String direccion,
			String telefono, String password, String tipo) {
		super();
		this.id = id;
		Nombre = nombre;
		Username = username;
		Email = email;
		Documento = documento;
		Direccion = direccion;
		Telefono = telefono;
		Password = password;
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getDocumento() {
		return Documento;
	}

	public void setDocumento(String documento) {
		Documento = documento;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", Nombre=" + Nombre + ", Username=" + Username + ", Email=" + Email
				+ ", Documento=" + Documento + ", Direccion=" + Direccion + ", Telefono=" + Telefono + ", Password="
				+ Password + ", tipo=" + tipo + "]";
	}

}