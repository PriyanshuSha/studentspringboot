package com.student.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class student {
	
	@Id
	private int studentId;
	private String studentName;
	private String studentCourse;
	private String studentPhone;
	
	@OneToMany
	@JoinColumn(name="studentId")
	private List<bike> stubike;

}
