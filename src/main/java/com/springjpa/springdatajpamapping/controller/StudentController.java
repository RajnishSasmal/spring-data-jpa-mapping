package com.springjpa.springdatajpamapping.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springjpa.springdatajpamapping.dto.StudentGeneration;
import com.springjpa.springdatajpamapping.entity.Department;
import com.springjpa.springdatajpamapping.entity.Employee;
import com.springjpa.springdatajpamapping.repository.DepartmentRepository;
import com.springjpa.springdatajpamapping.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping(value = "/createDept", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
     //public Department createStudent(@RequestBody  @JsonProperty("student") StudentGeneration student){
    public Department createDept(@RequestBody  @JsonProperty("department") Department department){
         return departmentRepository.save(department);
     }
    
    @PostMapping(value = "/createStudent/{deptId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
   public Employee createStudent(@RequestBody  @JsonProperty("employee") Employee employee,
		   @PathVariable("deptId") final Integer deptId){
    	 Optional<Department> dept = departmentRepository.findById(deptId);
    	 if(dept== null || dept.get()==null)
    		 return null;
    	 employee.setDeptId(dept.get().getDeptId()); 
    	
        return employeeRepository.save(employee);
    }
    
    @GetMapping("/firstNameLike/{firstName}")
    public List<Employee> findFirstNameLike(@PathVariable("firstName") final String firstName){
       return employeeRepository.findByLikeFirstName(firstName);
    }

    
    @GetMapping("/allStudent")
     public List<Department> findStudent(){
        return departmentRepository.findAll();
     }

}
