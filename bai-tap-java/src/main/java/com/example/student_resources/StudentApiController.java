package com.example.student_resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.dto.StudentDto;
import com.example.model.StudentEntities;
import com.example.serivce.StudentSerivce;

@RestController
@RequestMapping("/api")
public class StudentApiController {
	@Autowired
	StudentSerivce studentSerivce;
	
	@RequestMapping(value = "/v1/students",method = RequestMethod.GET)
	public List<StudentEntities> findAll(){
		List<StudentEntities> studentEntities =	studentSerivce.findAll();
		return studentEntities;
	}
	
	@RequestMapping(value = "/v1/students/{name}",method = RequestMethod.GET)
	public List<StudentEntities> findByName(@PathVariable("name") String name){
		return studentSerivce.findByNameStudent(name);
	}
	
	@RequestMapping(value = "/v1/students",method = RequestMethod.POST)
	public void insertOneStudent(@RequestBody StudentEntities studentEntities) {
		studentSerivce.insertOneStudent(studentEntities);
	}
	
	@RequestMapping(value = "/v1/students/many",method = RequestMethod.POST)
	public void inserManyStudent(@RequestBody List<StudentEntities> studentEntities) {
		studentSerivce.inserManyStudent(studentEntities);
	}
	
	@RequestMapping(value = "/v1/students",method = RequestMethod.PUT)
	public void updateOne(@RequestBody StudentDto studentDto) {
		studentSerivce.updateOne(studentDto);
	}
	
	@RequestMapping(value = "/v1/students/check/{id}",method = RequestMethod.GET)
	public String checkExit(@PathVariable("id") String id) {
		if (studentSerivce.checkExist(id) ) {
			return "<h4>tồn tài user</h4>";
		}
		return "<h4>không tồn tài user</h4>";
	}
	
	@RequestMapping(value="/v1/students/{name}",method = RequestMethod.DELETE)
	public void deleteByName(@PathVariable("name") String name) {
		studentSerivce.deletebyName(name);
	}
	
	@RequestMapping(value = "/v1/students/limit/{num}")
	public List<StudentEntities> getStudentByLimit(@PathVariable("num") int num){
		List<StudentEntities> studentEntities = studentSerivce.getAllStudentLitmit(num);
		return studentEntities;
	}
	
	@RequestMapping(value = "/v1/students/{name}/{address}",method = RequestMethod.DELETE)
	public void deleteByNameAndAddress(@PathVariable("name") String name, @PathVariable("address") String address) {
		studentSerivce.deleteStudentByNameAndAddress(name, address);
	}
	
	@RequestMapping(value = "/v1/students/order/{address}")
	public List<StudentEntities> findByAddressUserOrderByName(@PathVariable("address") String address){
		return studentSerivce.findByAddressUserOrderByName(address);
	}
	
	@RequestMapping(value = "/v1/students/updates",method = RequestMethod.PUT)
	public void updateMany(@RequestBody List<StudentDto> studentDtos) {
		studentSerivce.updateManyStudent(studentDtos);
	}
	 
}
