package com.estudegrupo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudegrupo1.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer>{

}
