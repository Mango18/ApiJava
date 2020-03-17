package com.ejemplo.demo.repository;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ejemplo.demo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	Usuario findById(int id);
	
	@Query("select a from Usuario a where fecha_nacimiento = :fechaNacimiento")
    List<Usuario> findByBirthday(@Param("fechaNacimiento") Date fechaNacimiento);
	
	@Query("select a from Usuario a where fecha_registro = :fechaRegistro")
    List<Usuario> findByRegistro(@Param("fechaRegistro") Date fechaRegistro);

}
