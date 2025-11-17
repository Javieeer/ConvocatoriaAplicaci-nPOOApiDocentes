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
	public TeacherModel save(TeacherModel teacherModel) {
		//Hacemos validación previa
		//insert into () values()
		return teacherRepository.save(teacherModel);
	}
	
	public ResponseModel update(TeacherModel teacherModel) {
		try {
			if(!teacherExist(teacherModel.getId())) {
				return new ResponseModel(false, "Docente no existe");
			} else {
				teacherRepository.save(teacherModel);
				return new ResponseModel(true, "Docente actualizado con exito");
			}
		} catch(Exception ex) {
			return new ResponseModel(false, ex.toString());
		}
	}
	
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
