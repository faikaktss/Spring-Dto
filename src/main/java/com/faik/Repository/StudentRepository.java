package com.faik.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.faik.Entites.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
