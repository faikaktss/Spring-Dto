package com.faik.Services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.faik.Controller.Impl.StudentControllerImpl;
import com.faik.Entites.Student;
import com.faik.Repository.StudentRepository;
import com.faik.Services.IStudentService;
import com.faik.dto.DtoStudent;
import com.faik.dto.DtoStudentIU;

@Service
public class StudentServiceImpl implements IStudentService{

	@Autowired
	public StudentRepository studentRepository;

	
	@Override
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
		DtoStudent response = new DtoStudent();
		Student student = new Student();
		BeanUtils.copyProperties(dtoStudentIU, student);
		
		Student dbStudent = studentRepository.save(student);
		BeanUtils.copyProperties(dbStudent, response);	
		return response;
		
	}

	@Override
	public List<DtoStudent> getAllStudents() {
		List<DtoStudent> dtoList = new ArrayList<>();
		
		List<Student> studentList = studentRepository.findAll();
		
		for (Student student : studentList) {
			DtoStudent dto =  new DtoStudent();
			BeanUtils.copyProperties(student, dto);
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public DtoStudent getStudentsById(Integer id) {
		DtoStudent dtoStudent = new DtoStudent();
		Optional<Student> optional =  studentRepository.findById(id);
		if(!optional.isEmpty()) {
			Student dbStudent  = optional.get();
			
			BeanUtils.copyProperties(dbStudent, dtoStudent);
		}
		return dtoStudent;
	}

	@Override
	public void deleteStudents(Integer id) {
		Optional<Student> optional =  studentRepository.findById(id);
		if(optional.isPresent()) {
			studentRepository.delete(optional.get());
		}
	}

	@Override
	public DtoStudent updateStudent(Integer id , DtoStudentIU dtoStudentIU) {
		DtoStudent dtoStudent = new DtoStudent();
		
		Optional<Student> optional = studentRepository.findById(id);
		if(optional.isPresent()) {
			Student dbStudent = optional.get();
			
			dbStudent.setFirstName(dtoStudentIU.getFirstName());
			dbStudent.setLastName(dtoStudentIU.getLastName());
			dbStudent.setBirthofDay(dtoStudentIU.getBirthofDay());
			
			Student updatedStudent =  studentRepository.save(dbStudent);
			
			BeanUtils.copyProperties(updatedStudent, dtoStudent);
			return dtoStudent;
		}
		return null;
	}
	
	


}
