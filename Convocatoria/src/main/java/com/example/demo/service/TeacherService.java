package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.TeacherModel;
import com.example.demo.models.response.ResponseModel;
import com.example.demo.repositories.ITeacherRepository;

@Service
public class TeacherService {
	
	@Autowired
	ITeacherRepository teacherRepository;
	
	//GET
	public List<TeacherModel> getAll() {
		// El entre parentesis funciona como un parse para convertir.
		return (List<TeacherModel>) teacherRepository.findAll();	
	}
	
	//POST
	public ResponseModel save(TeacherModel teacherModel) {
		
		try {
			Iterable<TeacherModel> teachers = teacherRepository.findAll();
			for(TeacherModel t : teachers) {
				if(t.getDocumentNumber().equals(teacherModel.getDocumentNumber())) {
					return new ResponseModel(false, "El número de documento ya se encuentra registrado");
				}
			}
			
			teacherRepository.save(teacherModel);
			return new ResponseModel(true, "Profesor registrado exitosamente");
			
		} catch(Exception ex){
			return new ResponseModel(false, "Error al guardar: " + ex.getMessage());
		}
	}
	
	//PUT
	public ResponseModel update(TeacherModel teacherModel) {
		try {
			if(!teacherExist(teacherModel.getId())) {
				return new ResponseModel(false, "Docente no existe");
			} 
			
			Iterable<TeacherModel> teachers = teacherRepository.findAll();

	        for (TeacherModel t : teachers) {
	        	if (t.getId() != teacherModel.getId() && t.getDocumentNumber().equals(teacherModel.getDocumentNumber())) {

	                return new ResponseModel(false, "El número de documento ya está registrado por otro docente " );
	            }
	        }
	        
	        teacherRepository.save(teacherModel);
	        return new ResponseModel(true, "Docente actualizado con éxito");
	        
		} catch(Exception ex) {
			return new ResponseModel(false, ex.toString());
		}
	}
	
	//DELETE
	public ResponseModel delete(int Id) {
		try {
			if(!teacherExist(Id)) {
				return new ResponseModel(false, "Docente no existe");
			} else {
				teacherRepository.deleteById(Id);
				return new ResponseModel(true, "Docente eliminado");
			}
		} catch(Exception ex) {
			return new ResponseModel(false, ex.getMessage());
		}
	}
	
	private boolean teacherExist(int Id) {
		return teacherRepository.findById(Id).isEmpty() ? false : true;
	}
	
}
