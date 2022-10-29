package com.student.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.student.model.student;
import com.student.repository.studentRepository;

@Service
public class studentService {
	
	@Autowired
	private studentRepository repo;
	
	public String addStudent(student s1) {
		student _s2=repo.save(s1);
		
		if(_s2!=null) {
			return "student added successfully"+new Date();
		}
		else {
			return null;
			}
	    }

	
		public List<student> getAllStudents(){
			
			return repo.findAll();
		
		}
		
		
		public String updateStudent(student s1) {
			
			student _s2=repo.save(s1);
			if(_s2!=null) {
				return "student updated successfully\" "+new Date();
			}
			else {
				return null;
			}
			
		}
		
		
		
		public String deleteStudent(int stuid) {
			
			Optional<student> _s1=repo.findById(stuid);
			
			if(_s1!=null) {
				repo.deleteById(stuid);
				return "student deleted successfully";
			}
			else {
				return null;
			}
			
		}

}
