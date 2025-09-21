package com.faik.Controller;

import java.util.List;

import com.faik.Entites.Student;
import com.faik.dto.DtoStudent;
import com.faik.dto.DtoStudentIU;

public interface IStudentController {
	
	public DtoStudent  saveStudent(DtoStudentIU  dtoStudentIU);
	
	public List<DtoStudent> getAllStudents();
	
	public List<DtoStudent> getAllStudentsId();

	public DtoStudent getStudentById(Integer id);
	
	public void DeleteStudentById(Integer id);
	
	public DtoStudent udpateStudent(Integer id , DtoStudentIU dtoStudentIU);
}
