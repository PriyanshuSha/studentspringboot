package com.student.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.student.model.bike;
import com.student.repository.bikeRepository;

@Service
public class bikeService {
	
	@Autowired
	private bikeRepository bikerepo;
	public String addBike(bike l1) {
		String msg=null;
		bike _b2=bikerepo.save(l1);
		if(_b2!=null) {
			msg= "Bike added successfully "+new Date();
		}
		else {
			msg=null;
		}
		return msg;
	}
	
	
	public List<bike> getBike(){
		return bikerepo.findAll();
	}
		
	
	public String updateBike(bike l1)
	{
		bike _b2=bikerepo.save(l1);
		if(_b2!=null) {
			return "Bike updated successfully "+new Date();
		}
		else {
			return null;
		}
	}
	
	
	public String deleteBike(int bikeid) {
		
		Optional<bike> _l1=bikerepo.findById(bikeid);
		if(_l1!=null) {
			bikerepo.deleteById(bikeid);
			return "Bike deleted successfully ";
		}
		else {
			return null;
		}
	}
	
	
	public List<bike> getBikes(String field){
		
		return bikerepo.findAll(Sort.by(Direction.DESC,field));
		
		
	}
}
