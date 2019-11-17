package com.example.serivce;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dto.StudentDto;
import com.example.model.StudentEntities;
import com.example.repository.StudentRepository;
import com.example.repository.StudentRepositoryImlp;


@Service
public class StudentSerivceImlp implements StudentSerivce{
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	StudentRepositoryImlp studentRepositoryImlp;
	
	@Transactional
	@Override
	public List<StudentEntities> findAll() {
		// TODO Auto-generated method stub
		List<StudentEntities> studentEntities = studentRepository.findAll();
		return studentEntities;
	}
	
	@Transactional
	@Override
	public Optional<StudentEntities> findById(String id) {
		// TODO Auto-generated method stub
		Optional<StudentEntities> studentEntities = studentRepository.findById(id);
		return studentEntities;
	}
	
	@Transactional
	@Override
	public List<StudentEntities> findByNameStudent(String name) {
		// TODO Auto-generated method stub
		try {
			List<StudentEntities> studentEntities = studentRepository.findByNameStudent(name);
			return studentEntities;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	@Transactional
	@Override
	public void insertOneStudent(StudentEntities studentEntities) {
		// TODO Auto-generated method stub
		try {
			studentRepository.save(studentEntities);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}
	
	@Transactional
	@Override
	public void inserManyStudent(List<StudentEntities> studentEntities) {
		// TODO Auto-generated method stub
		studentRepository.saveAll(studentEntities);
	}
	
	@Transactional
	@Override
	public void updateOne(StudentDto studentDto) {
		// TODO Auto-generated method stub
		try {
			Optional<StudentEntities> studentEntities =	findById(studentDto.getIdStudent());
			studentEntities.ifPresent(student ->{
				student.setNameStudent(studentDto.getNameStudent());
				student.setOld(studentDto.getOld());
				student.setAddress(studentDto.getAddress());
				student.setPointEntites(studentDto.getPointEntites());
				studentRepository.save(student);
			} );
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	
	@Transactional
	@Override
	public boolean checkExist(String id) {
		// TODO Auto-generated method stub
		Optional<StudentEntities> studentEntities = findById(id);
		if (studentEntities.isPresent()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteById(String id) {
		// TODO Auto-generated method stub
		Optional<StudentEntities> studentEntities = studentRepository.findById(id);
		if (studentEntities!=null) {
			studentRepository.deleteById(studentEntities.get().getIdStudent());
			return true;
		}
		return false;
		
	}
	
	@Transactional
	@Override
	public void deletebyName(String name) {
		// TODO Auto-generated method stub
		List<StudentEntities> studentEntities = studentRepository.findByNameStudent(name);
		studentEntities.stream().forEach(e->{
			studentRepository.delete(e);
			
		});
		
	}
	
	@Transactional
	@Override
	public void getAllSortById(String id) {
		// TODO Auto-generated method stub
		
	}
	
	@Transactional
	@Override
	public void getAllSortDescById() {
		// TODO Auto-generated method stub
		
	}
	
	
	@Transactional
	@Override
	public List<StudentEntities> getAllStudentLitmit(int limit) {
		// TODO Auto-generated method stub
		List<StudentEntities> studentEntities =	studentRepositoryImlp.findStudentLimitedTo(limit);
		return studentEntities;
	}
	
	@Transactional
	@Override
	public void deleteStudentByNameAndAddress(String nameStudent, String address) {
		// TODO Auto-generated method stub
		List<StudentEntities> studentEntities = findAll();
		studentRepository.deleteAll(studentEntities.stream()
							.filter(e -> e.getNameStudent().equalsIgnoreCase(nameStudent) )
							.filter(e -> e.getAddress().equalsIgnoreCase(address))
							.collect(Collectors.toList())
				);	
	}
	
	@Transactional
	@Override
	public List<StudentEntities> findByAddressUserOrderByName(String address) {
		// TODO Auto-generated method stub
		try {
			List<StudentEntities> studentEntities = studentRepositoryImlp.findByAddressUserOrderByName(address);
			return studentEntities;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
		
	}
	
	@Transactional
	@Override
	public void updateManyStudent(List<StudentDto> studentDto) {
		// TODO Auto-generated method stub
		try {
			List<StudentEntities> entities = studentRepository.findAll();
			entities.forEach(entiti ->{
				studentDto.forEach(d ->{
					if (entiti.getIdStudent().equalsIgnoreCase(d.getIdStudent())) {
						entiti.setNameStudent(d.getNameStudent());
						entiti.setAddress(d.getAddress());
						entiti.setOld(d.getOld());
						entiti.setPointEntites(d.getPointEntites());
						System.out.println("dsa");
						studentRepository.save(entiti);
					}
					
				});
			});
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	
	
}
