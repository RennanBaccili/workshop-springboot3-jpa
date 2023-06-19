package com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;


// url dos usuarios
@RestController
@RequestMapping(value = "/users")
public class UserResource {
	//para spring pegar as dependecias
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.FindAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	//retorna o id na url
	@GetMapping(value= "/{id}")// a verificação vai aceitar um Id dentro da url
	public ResponseEntity<User> findById(@PathVariable Long id){ // path variable para ele aceitar id com a url
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	// inserção de usuario
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value= "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value ="/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
