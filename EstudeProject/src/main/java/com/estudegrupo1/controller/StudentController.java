package com.estudegrupo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudegrupo1.model.Student;
import com.estudegrupo1.service.StudentService;


@RestController
@RequestMapping("/student")
public class StudentController {
	

	@Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getStudentList());
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer idStudent) {
        return ResponseEntity.ok().body(this.studentService.getStudentById(idStudent));
    }

    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return ResponseEntity.ok(this.studentService.createStudent(student));
    }

    @PutMapping("/updateStudent/")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        return ResponseEntity.ok().body(this.studentService.updateStudentById(student));
    }

    @DeleteMapping("/deleteStudent/{id}")
    public HttpStatus deleteStudent(@PathVariable Integer idStudent) {
        this.studentService.deleteStudentById(idStudent);
        return HttpStatus.OK;
    }
}
	