package com.ejemplo.demo.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.format.annotation.DateTimeFormat;


@Entity(name ="Usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdUsuario;
	private String nombre;
	private String apellido;
	@Lob
	private byte[] foto;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate fechaRegistro;
	
	
	 /* Relación many to many *****************************************
	 * 	public List<tabla2> tabla2;
	 * @ManyToMany
	 * @JoinTable(
	 * 		name= "tabla2",
	 * 		joinColumns = @JoinColumns (name = "tabla1_id")
	 * 		inverseJoinColumns = @JoinColumns (name = "tabla2_id"))
	 ******************************************************************/
	
	
	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public Integer getIdUsuario() {
		return IdUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		IdUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
