package com.faik.Controller.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.faik.Controller.IStudentController;
import com.faik.Entites.Student;
import com.faik.Services.IStudentService;
import com.faik.dto.DtoStudent;
import com.faik.dto.DtoStudentIU;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController{

	@Autowired
	private IStudentService studentService;
	
	
	//Normalde burada Dto lar kullanılır

	@PostMapping(path = "/save")
	@Override
	public DtoStudent saveStudent(@RequestBody @Valid DtoStudentIU dtoStudentIU) {
		return studentService.saveStudent(dtoStudentIU);
	}

	@GetMapping(path = "/list")
	@Override
	public List<DtoStudent> getAllStudents() {
		return studentService.getAllStudents();
	}



	@Override
	public List<DtoStudent> getAllStudentsId() {
		// TODO Auto-generated method stub
		return null;
	}


	
	@GetMapping(path = "/list/{id}")
	@Override
	public DtoStudent getStudentById(@PathVariable(name = "id") Integer id) {
		return studentService.getStudentsById(id);
	}

	@GetMapping(path = "/delete/{id}")
	@Override
	public void DeleteStudentById(@PathVariable(name = "id") Integer id) {
		studentService.deleteStudents(id);
	}

	@PutMapping(path = "/update/{id}")
	@Override
	public DtoStudent udpateStudent(@PathVariable(name = "id") Integer id,@RequestBody DtoStudentIU dtoStudentIU) {
		return studentService.updateStudent(id, dtoStudentIU);
	}
}
