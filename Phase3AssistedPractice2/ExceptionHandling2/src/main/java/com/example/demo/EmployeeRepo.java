package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepo extends JpaRepository<Employee,Integer > {
	
	//JPQL
	String sql="select employee.phono from Employee employee where employee.empname=?1 and employee.empid=?2";
	@Query(sql)
	public String findPhono(String name,int id);

}

