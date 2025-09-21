package com.faik.Services;

import java.util.List;

import com.faik.Entites.Student;
import com.faik.dto.DtoStudent;
import com.faik.dto.DtoStudentIU;

public interface IStudentService {

	public DtoStudent saveStudent(DtoStudentIU student);
	
	public List<DtoStudent> getAllStudents();
	
	public DtoStudent  getStudentsById(Integer id);
	
	public void deleteStudents(Integer id);
	
	public DtoStudent updateStudent(Integer id , DtoStudentIU dtoStudentIU);
}
