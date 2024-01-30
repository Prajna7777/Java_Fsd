package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MphasisJpArestApplicationTests {

	@Autowired
	EmployeeService service;
		
		@Test
		public void inserttest() {
			Employee e=new Employee();
			e.setEmpname("satish");  //mocking
			e.setPhono("9999");
		 assertNotNull(service.insert(e));
		}

		
		@Test
		public void deletetest() {
		  assertEquals("deleted id of "+3,service.deletebyid(3));
		}


}
