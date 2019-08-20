package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Register;

@Repository
public interface EmployeeRepository extends CrudRepository<Register, Long>{

}
