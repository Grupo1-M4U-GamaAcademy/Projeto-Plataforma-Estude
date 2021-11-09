package com.estudegrupo1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudegrupo1.model.Address;
import com.estudegrupo1.model.Student;
import com.estudegrupo1.model.User;
import com.estudegrupo1.repository.AddressRepository;
import com.estudegrupo1.repository.StudentRepository;
import com.estudegrupo1.repository.UserRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AddressRepository addressRepository;

	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	public List<Student> createStudentList(List<Student> list) {
		return studentRepository.saveAll(list);
	}

	public List<User> getUserList() {
		return userRepository.findAll();
	}

	public List<Student> getStudentList() {
		return studentRepository.findAll();
	}

	public List<Address> getAddressList() {
		return addressRepository.findAll();
	}

	public Student getStudentById(Integer idStudent) {
		return studentRepository.findById(idStudent).orElse(null);
	}

	public Student updateStudentById(Student student) {
		Optional<Student> studentFound = studentRepository.findByIdStudent(student.get());

		if (Student.isPresent()) {
			Student studentUpdate = studentFound.get();
            studentUpdate.setFirstName(student.getFirstName());
            studentUpdate.setLastName(student.getLastName());
            studentUpdate.setAge(student.getAge());

			return studentRepository.save(student);
		} else {
			return null;
		}
	}

	public String deleteStudentById(Integer idStudent) {
		studentRepository.deleteById(idStudent);
		return "Student " + idStudent + " deleted";
	}
}
