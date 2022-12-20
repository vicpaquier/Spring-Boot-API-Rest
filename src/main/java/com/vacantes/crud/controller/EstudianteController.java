package com.vacantes.crud.controller;
import com.vacantes.crud.model.EstudianteModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vacantes.crud.service.EstudianteService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

	@Autowired
	EstudianteService estudianteservice;
	
	//listar todos los estudiantes
	@GetMapping()
	public ArrayList<EstudianteModel> listarTodos(){
		 return estudianteservice.getAll();
	}
	
	//pathvariable indica que el id va a venir en la url
	@GetMapping(path = "/{id}")
	public Optional<EstudianteModel> consultarPorId(@PathVariable("id") Long id){
		 return estudianteservice.get(id);
	}
	
	@GetMapping(path = "/consultar")
	public ArrayList<EstudianteModel> consultarPorCI(@RequestParam("ci") String CI){
		 return estudianteservice.getByCi(CI);
	}
	
	//crear nuevo estudiante
	@PostMapping()
	public EstudianteModel registrar(@RequestBody EstudianteModel e){
		 return estudianteservice.save(e);
	}
	
	//eliminar
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Long id){
		boolean res =  estudianteservice.delete(id);
		 Map datos = new HashMap<>();
		 datos.put("mensaje", "Datos eliminados con exito");
		 if (!res) {
			 datos.put("mensaje", "No existe el registro con id: "+id);
		 }
		 datos.put("respuesta", res);
		 
		 return new ResponseEntity<>(datos, HttpStatus.OK);
	}
	
}
