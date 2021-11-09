package com.estudegrupo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudegrupo1.model.Teacher;
import com.estudegrupo1.service.TeacherService;

@CrossOrigin
@RestController
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;

	@GetMapping("/teacher")
	public ResponseEntity<List<Teacher>> getAllTeacher() {
		return ResponseEntity.ok(teacherService.getTeacherList());
	}

	@GetMapping("/teacher/{id}")
	public ResponseEntity<Teacher> getTeacherById(@PathVariable Integer idTeacher) {
		return ResponseEntity.ok().body(this.teacherService.getTeacherById(idTeacher));
	}

	@PostMapping("/addTeacher")
	public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher) {
		return ResponseEntity.ok(this.teacherService.createTeacher(teacher));
	}

	@PutMapping("/updateTeacher/")
	public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher) {
		return ResponseEntity.ok().body(this.teacherService.updateTeacherById(teacher));
	}

	@DeleteMapping("/deleteTeacher/{id}")
	public HttpStatus deleteTeacher(@PathVariable Integer idTeacher) {
		this.teacherService.deleteTeacherById(idTeacher);
		return HttpStatus.OK;
	}
}
