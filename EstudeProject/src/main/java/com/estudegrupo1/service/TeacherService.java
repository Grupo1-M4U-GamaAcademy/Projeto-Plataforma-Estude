package com.estudegrupo1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudegrupo1.model.Teacher;
import com.estudegrupo1.repository.TeacherRepository;

@Service
public class TeacherService {
	
	 @Autowired
	    private TeacherRepository teacherRepository;

	    public Teacher createTeacher (Teacher teacher) {
	        return teacherRepository.save(teacher);
	    }

	    public List<Teacher> createTeacherList(List<Teacher> list) {
	        return teacherRepository.saveAll(list);
	    }

	    public List<Teacher> getTeacherList() {
	        return teacherRepository.findAll();
	    }

	    public Teacher getTeacherById(Integer idTeacher) {
	        return teacherRepository.findById(idTeacher).orElse(null);
	    }

	    public Teacher updateTeacherById(Teacher teacher) {
	        Optional<Teacher> teacherFound = teacherRepository.findById(teacher.getIdTeacher());

	        if (teacherFound.isPresent()) {
	            Teacher teacherUpdate = teacherFound.get();
	            teacherUpdate.setFirstName(teacher.getFirstName());
	            teacherUpdate.setLastName(teacher.getLastName());
	            teacherUpdate.setEmail(teacher.getEmail());
	            teacherUpdate.setDescriptionTeachers(teacher.getDescriptionTeachers());

	            return teacherRepository.save(teacher);
	        } else {
	            return null;
	        }
	    }

	    public String deleteTeacherById(Integer idTeacher) {
	        teacherRepository.deleteById(idTeacher);
	        return "Teacher "+ idTeacher +" deleted";
	    }
	}
