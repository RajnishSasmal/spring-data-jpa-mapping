package com.springjpa.springdatajpamapping.repository;

import com.springjpa.springdatajpamapping.entity.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	
    @Query("SELECT p FROM Employee p WHERE (p.firstName) like %:firstName%")
    public List<Employee> findByLikeFirstName(@Param("firstName") final String firstName);
}
