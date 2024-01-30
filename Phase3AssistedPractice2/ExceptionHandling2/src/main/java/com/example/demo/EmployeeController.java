package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService service;

@PostMapping("/insert")
//insert
	public Employee insert(@RequestBody Employee e) {
		return service.insert(e);
	}

@PostMapping("/insertall")
	public List<Employee> insertall(@RequestBody List<Employee> e) {
		return service.insertall(e);
	}

@GetMapping("/getall")
public List<Employee> getall(){
	return service.getall();
}
                         //pathvariables
@GetMapping("/getbyid/{id}")
public Optional<Employee> getByid(@PathVariable("id") int id) throws ResourceRequestNotFoundException {
	if(service.getByid(id).isEmpty()) {
		throw new ResourceRequestNotFoundException("id not found");
	}
	else {
		return service.getByid(id);
	}
}


@DeleteMapping("/delete/{id}")
public String deletebyid(@PathVariable("id") int id) {
	service.deletebyid(id);
	return "deleted record with id "+id;
	}

@DeleteMapping("/deletegetall/{id}")
public List<Employee> deletegetall(@PathVariable("id") int id) {
	service.deletebyid(id);
	return service.getall();
	}


@PutMapping("/update")
public Employee updatebyname(@RequestBody Employee e) {
	return service.updatebyname(e);
}


@GetMapping("/getphno/{name}/{id}")
public String findphono(@PathVariable("name") String name,@PathVariable("id") int id) throws Exception {
	
	if(service.findphono(name, id)==null) {
		throw new Exception("the phono is not found");
	}
	else {
	return service.findphono(name, id);
	}
}
}


