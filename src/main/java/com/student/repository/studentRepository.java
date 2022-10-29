package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.student.model.student;

@Repository
public interface studentRepository  extends JpaRepository<student,Integer> {

}
