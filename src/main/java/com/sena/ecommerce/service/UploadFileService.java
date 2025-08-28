package com.sena.ecommerce.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileService {

	private String folder = "images/";

	// metodo para subir o cargar la imagen del producto
	public String saveImages(MultipartFile file, String nombre) throws IOException {
		// validacion de imagen
		if (!file.isEmpty()) {
			byte[] bytes = file.getBytes();
			// variable path que redirige al directorio, se importa el path de .nio.file
			Path path = Paths.get(folder + nombre + "_" + file.getOriginalFilename());
			Files.write(path, bytes);
			return nombre + "_" + file.getOriginalFilename();

		}
		return "default.jpg";
	}
	
	//metodo para eliminar imagen del producto
	public void deteleImage(String nombre) {
		String ruta = "image/";
		File file = new File(ruta + nombre);
		file.delete();
		}
}
