package com.example.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.example.model.StudentEntities;


@Repository
public class StudentRepositoryImlp {
	@PersistenceContext
	EntityManager entityManager;
	
	public List<StudentEntities> findStudentLimitedTo(int limit){
		return entityManager.createQuery("Select u  from StudentEntities u ",StudentEntities.class).
				setMaxResults(limit).
				getResultList();
	}
	
	public List<StudentEntities> findByAddressUserOrderByName(String address){
		return entityManager.createQuery("Select u from StudentEntities as u where u.address = '"+address+"' order by u.nameStudent  "
				,StudentEntities.class).getResultList();
	}
}
