package com.securitypoc.service.impl;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.securitypoc.Dto.StudentDto;
import com.securitypoc.exception.ResourceNotFoundException;
import com.securitypoc.model.Student;
import com.securitypoc.repository.StudentRepo;
import com.securitypoc.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepo studentRepo;

	private ModelMapper modelMapper;

// save Student
	@Override
	public StudentDto saveStudent(StudentDto studentDto) {

		Student student = this.modelMapper.map(studentDto, Student.class);
		Student saveStudent = this.studentRepo.save(student);
		log.info("Student Saved Sucessfully...!!!");
		return this.modelMapper.map(saveStudent, StudentDto.class);

	}

// getAllStudents
	public List<StudentDto> getAllStudent() {
		List<Student> list = this.studentRepo.findAll();
		List<StudentDto> studentDtos = list.stream().map((student) -> this.modelMapper.map(student, StudentDto.class))
				.collect(Collectors.toList());

		return studentDtos;
	}

// get single Student
	public StudentDto getSingleStudent(Long studentId) {
		Student student = this.studentRepo.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "studentId", studentId));

		return this.modelMapper.map(student, StudentDto.class);
	}

// update	
	@Override
	public StudentDto updateStudent(StudentDto studentDto, Long studentId) {
		Student student = this.studentRepo.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "studentId", studentId));
		student.setRollno(studentDto.getRollno());
		student.setStudentName(student.getStudentName());
		student.setStudentAddr(student.getStudentAddr());
		Student updateStudent = this.studentRepo.save(student);
		return this.modelMapper.map(updateStudent, StudentDto.class);
	}

// delete Student

	@Override
	public void deleteStudent(Long studentId) {
		Student student = this.studentRepo.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "studentId", studentId));

		this.studentRepo.delete(student);
	}

}
