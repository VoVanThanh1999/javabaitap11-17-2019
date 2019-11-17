package com.example.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="student")
public class StudentEntities {
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="idStudent")
	private String idStudent;
	
	@Column(name="nameStudent")
	private String nameStudent;
	
	@Column(name="old")
	private String old;
	
	@Column(name="address")
	private String address;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idStudent")
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
