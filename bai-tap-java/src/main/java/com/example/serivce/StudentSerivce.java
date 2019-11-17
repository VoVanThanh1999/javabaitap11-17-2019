package com.example.serivce;

import java.util.List;
import java.util.Optional;

import com.example.dto.StudentDto;
import com.example.model.StudentEntities;

public interface StudentSerivce {
	public List<StudentEntities> findAll();
	
	public Optional<StudentEntities> findById(String id);	
	
	public List<StudentEntities> findByNameStudent(String name);
	
	public void insertOneStudent(StudentEntities studentEntities);
	
	public void inserManyStudent(List<StudentEntities> studentEntities);
	
	public void updateOne(StudentDto studentDto);
	
	public void updateManyStudent(List<StudentDto> StudentDto);
	
	public boolean checkExist(String id);
	
	public boolean deleteById(String id);
	
	public void deletebyName(String name);
	
	public void getAllSortById(String id);
	
	public void getAllSortDescById();
	
	public List<StudentEntities> getAllStudentLitmit(int number);
	
	public void deleteStudentByNameAndAddress(String nameStudent,String address);
	
	public List<StudentEntities> findByAddressUserOrderByName(String address);
}
