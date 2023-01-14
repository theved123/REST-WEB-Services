package com.securitypoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.securitypoc.model.Student;


public interface StudentRepo extends JpaRepository<Student,Long>{

}
