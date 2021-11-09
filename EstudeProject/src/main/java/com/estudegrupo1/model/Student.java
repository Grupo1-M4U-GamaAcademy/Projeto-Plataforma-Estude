package com.estudegrupo1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Table(name = "student")
public class Student {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_student")
	private String idStudent;
	
	@Column(name = "first_name", nullable = false, length = 25)
	private String firstName;
	
	@Column(name ="last_name", nullable = false, length = 25)
	private String lastName;
	
	@Column(name = "age", nullable = false, length = 2)
	private int age;
	
	@Column(name = "teacher", nullable = false, length = 25)
	private String teacher;
	
	@Column(name = "email", nullable = false, length = 35)
	private String email;

	public static boolean isPresent() {
		return false;
	}

	public Student get() {
		return null;
	}

	
	
	
	
}
