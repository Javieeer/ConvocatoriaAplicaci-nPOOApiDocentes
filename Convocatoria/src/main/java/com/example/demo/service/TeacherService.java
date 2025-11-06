package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.ITeacherRepository;

@Service
public class TeacherService {
	
	@Autowired
	ITeacherRepository teacherRepository;
	
}
