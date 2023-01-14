package com.securitypoc.service;

import java.util.List;

import com.securitypoc.Dto.StudentDto;

public interface StudentService {

	StudentDto saveStudent(StudentDto studentDto);
	List<StudentDto> getAllStudent();
	StudentDto getSingleStudent(Long studentId);
	StudentDto updateStudent(StudentDto studentDto ,Long studentId);
	void deleteStudent(Long studentId);
}
