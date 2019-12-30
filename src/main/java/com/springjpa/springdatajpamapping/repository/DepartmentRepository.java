package com.springjpa.springdatajpamapping.repository;

import com.springjpa.springdatajpamapping.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
