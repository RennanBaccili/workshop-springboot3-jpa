package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.services.ProductService;


// url dos usuarios
@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	//para spring pegar as dependecias
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.FindAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	//retorna o id na url
	@GetMapping(value= "/{id}")// a verificação vai aceitar um Id dentro da url
	public ResponseEntity<Product> findById(@PathVariable Long id){ // path variable para ele aceitar id com a url
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);

	}
}
