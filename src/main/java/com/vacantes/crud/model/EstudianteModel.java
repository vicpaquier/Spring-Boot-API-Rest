package com.vacantes.crud.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_estudiantes")
public class EstudianteModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "documento", unique= true, length = 15, nullable = false)
	private String ci;
	
	@Column(length = 50, nullable = false)
	private String nombre;
	
	@Column(length = 50, nullable = false)
	private String apellido;
	
	@Column(length = 50, nullable = false, unique= true)
	private String correo;

	public EstudianteModel() {
		super();
	}

	public EstudianteModel(long id, String ci, String nombre, String apellido, String correo) {
		super();
		this.id = id;
		this.ci = ci;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
	}

	public EstudianteModel(String ci, String nombre, String apellido, String correo) {
		super();
		this.ci = ci;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	
	

}