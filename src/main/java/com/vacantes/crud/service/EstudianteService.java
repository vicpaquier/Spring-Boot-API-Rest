package com.vacantes.crud.service;

import com.vacantes.crud.model.EstudianteModel;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacantes.crud.repository.EstudianteRepository;

@Service
public class EstudianteService {
	@Autowired
	EstudianteRepository estudianteRepository;
	
	//retornar todos los estudiantes por id
	public ArrayList<EstudianteModel> getAll(){
		return (ArrayList<EstudianteModel>) estudianteRepository.findAll();
	}
	
	//retornar los estudiantes por ci
	public ArrayList<EstudianteModel> getByCi(String CI){
		return estudianteRepository.findByCi(CI);
	}
	
	//retornar solo un estudiante
	public Optional<EstudianteModel> get(long id){
		return estudianteRepository.findById(id);
	}
	
	//guardar
	public EstudianteModel save(EstudianteModel e){
		return estudianteRepository.save(e);
	}
	
	//eliminar
	public boolean delete(long id){
		try {
			estudianteRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
}
