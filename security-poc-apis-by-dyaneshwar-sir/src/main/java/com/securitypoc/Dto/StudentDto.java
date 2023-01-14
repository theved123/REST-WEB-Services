package com.securitypoc.Dto;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
	
	private Long studentId;
	
	@NotEmpty
	@Size(min=2,max=8,message="* Note: Name Must Be Between 2-8 Letters")
	private String studentName;
	
	@NotEmpty
	@Size(min=2,max=10,message="* Note: Address Must Be Between 2-10 Letters")
	private String studentAddr;
	
	@NotEmpty
	private String rollno;
	
	@Size(max=12)
	private String studentAadhar;
	
	@Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}",message="Enter 1-10 Fields")
	private String studentPAN;
	
	@Email
	private String email;

}
