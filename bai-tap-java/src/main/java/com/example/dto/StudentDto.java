package com.example.dto;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.example.model.PointEntites;

@Component
public class StudentDto {
	private String idStudent;
	private String nameStudent;
	private String old;
	private String address;
	Set<PointEntites> pointEntites;
	public String getIdStudent() {
		return idStudent;
	}
	public void setIdStudent(String idStudent) {
		this.idStudent = idStudent;
	}
	public String getNameStudent() {
		return nameStudent;
	}
	public void setNameStudent(String nameStudent) {
		this.nameStudent = nameStudent;
	}
	public String getOld() {
		return old;
	}
	public void setOld(String old) {
		this.old = old;
	}
	public Set<PointEntites> getPointEntites() {
		return pointEntites;
	}
	public void setPointEntites(Set<PointEntites> pointEntites) {
		this.pointEntites = pointEntites;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}
