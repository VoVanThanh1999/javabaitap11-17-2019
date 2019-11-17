package com.example.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.StudentEntities;

public interface StudentRepository extends JpaRepository<StudentEntities, String>{
	List<StudentEntities> findByNameStudent(String name);
	
	
}
