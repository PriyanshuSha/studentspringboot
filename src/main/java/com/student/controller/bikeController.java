package com.student.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.student.model.bike;
import com.student.services.bikeService;

@RestController
public class bikeController {
	
	
		@Autowired
		private bikeService service;
		
		@RequestMapping(method=RequestMethod.POST ,value="/bike")
		public ResponseEntity<String> addBike(@RequestBody bike l1) {
			String status=service.addBike(l1);
			if(status!=null)
				return new ResponseEntity<>(status,HttpStatus.CREATED);
			else
				return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		@RequestMapping(method=RequestMethod.GET ,value="/bike")
		public ResponseEntity<List<bike>> getBike() {
			return new ResponseEntity<>(service.getBike(),HttpStatus.OK);
		}
		
		
		
		@RequestMapping(method=RequestMethod.PUT, value="/bike")
		public ResponseEntity<String> updateBike(@RequestBody bike l1){
			String status=service.updateBike(l1);
			if(status!=null){
				
			    return new ResponseEntity<>(status,HttpStatus.OK );
			}
			else {
				
				return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
			}	
		}
		
		
		@RequestMapping(method=RequestMethod.DELETE,value="/bike/{bikeid}")
		
		public ResponseEntity<String> deleteBike(@PathVariable int bikeid){
			String status=service.deleteBike(bikeid);
			
			if(status!=null){
				
			    return new ResponseEntity<>(status,HttpStatus.OK );
			}
			else {
				return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
			}	
		}
		
		
		@GetMapping("/getbikes/{field}")
		
		public ResponseEntity<List<bike>> getBike(@PathVariable String field){
			
		    	return new ResponseEntity<>(service.getBikes(field),HttpStatus.OK);
			
		}

}
