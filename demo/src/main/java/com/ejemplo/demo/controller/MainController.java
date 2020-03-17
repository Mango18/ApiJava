package com.ejemplo.demo.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.repository.UsuarioRepository;

@Controller
@RequestMapping(path="/api/v1/usuario")
public class MainController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	  @GetMapping(path="/getAll")
	  public @ResponseBody Iterable<Usuario> getAllUsers() {
		  return usuarioRepository.findAll();
	  }
	  
	  @DateTimeFormat(pattern = "yyyy-MM-dd")
	  @GetMapping(path="/getBirthday")
	  public @ResponseBody Iterable<Usuario> getBirthday(@RequestParam Date date) {
		  return usuarioRepository.findByBirthday(date);
	  }
	  
	  
	  
	  @DeleteMapping(path="/delete/{id}")
	  public void Delete(@PathVariable int id) {
		  usuarioRepository.deleteById(id); 
	  }
	  
	  @PutMapping(path="/modify/{id}")
	  public @ResponseBody String Update(@PathVariable int id, @RequestBody Usuario usuario2) {
		 Usuario usuario = usuarioRepository.findById(id);
		 usuario.setNombre(usuario2.getNombre());
		 usuario.setApellido(usuario2.getApellido());
		 usuarioRepository.saveAndFlush(usuario);
		 return "El usuario ha sido modificado";
	  }
	  
	  @PostMapping(path="/create")
	  public @ResponseBody String add (@RequestParam("file") MultipartFile file, Usuario usuario, Date date ) throws IOException {
		  usuario.setFoto(file.getBytes());
		  usuario.setFechaNacimiento(date);
		  usuario.setFechaRegistro(LocalDate.now());
		    usuarioRepository.save(usuario);
		    return "El usuario " + usuario.getNombre() + " ha sido añadido";
	  }	  
	  
}
	
