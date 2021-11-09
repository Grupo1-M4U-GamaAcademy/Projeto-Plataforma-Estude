package com.estudegrupo1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "teacher")
public class Teacher {
	
		@Id
		@Column(name = "id_teacher")
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer idTeacher;
		
		@Column(name = "first_name", nullable = false)
		private String firstName;
		
		@Column(name = "last_name", nullable = false)
		private String lastName;
		
		@Column(name = "email", nullable = false)
		private String email;
		
		@Column(name = "description", nullable = false)
		private String descriptionTeachers;
		
		

}
