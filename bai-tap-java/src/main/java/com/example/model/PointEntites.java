package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="point")
public class PointEntites {
	@Id
	@Column(name="idPoint")
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String idPoint;
	
	@Column(name="namePoint")
	private String namePoint;
	
	private float point;
	
	public String getIdPoint() {
		return idPoint;
	}

	public void setIdPoint(String idPoint) {
		this.idPoint = idPoint;
	}

	public String getNamePoint() {
		return namePoint;
	}

	public void setNamePoint(String namePoint) {
		this.namePoint = namePoint;
	}

	public float getPoint() {
		return point;
	}

	public void setPoint(float point) {
		this.point = point;
	}
	
	
	
}
