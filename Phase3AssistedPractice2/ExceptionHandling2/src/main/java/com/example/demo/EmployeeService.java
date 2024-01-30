package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	//creates an obj automatically wrt to the dummy object which u have created 
	@Autowired
	EmployeeRepo repo;

	//insert
	public Employee insert(Employee e) {
		return repo.save(e);
	}

	//insert all
	public List<Employee> insertall(List<Employee> e) {
		return repo.saveAll(e);
	}


	//getallrecord
	public List<Employee> getall(){
		return repo.findAll();
	}

	//getbyid
	//getbyid--primary key -int
	//		public Optional<Employee> getByid(int id) {
	//			return repo.findById(id);
	//		}

	//		public Employee getByid(int id) {
	//			return repo.findById(id).orElse(null);
	//		}

	public Optional<Employee> getByid(int id) {
		return repo.findById(id);
	}


	//deleteAll-deleting all records 
	//		public void deletebyid(int id) {
	//			repo.deleteById(id);
	//		}

	//deleteAll-deleting all records 
	public String deletebyid(int id) {
		repo.deleteById(id);
		return "deleted id of "+id;
	}


	//update                  {id:5,name:"updated name"}
	public Employee updatebyname(Employee e) {
		Employee ee=repo.findById(e.getEmpid()).orElse(null);
		ee.setEmpname(e.getEmpname());
		return repo.save(ee);
	}

	//predefined method 
	public String findphono(String name,int id) {
		return repo.findPhono(name, id);
	}

}

