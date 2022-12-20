package com.vacantes.crud.repository;
import com.vacantes.crud.model.EstudianteModel;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EstudianteRepository extends CrudRepository<EstudianteModel, Long> {
	public abstract ArrayList<EstudianteModel> findByCi(String CI);
}
