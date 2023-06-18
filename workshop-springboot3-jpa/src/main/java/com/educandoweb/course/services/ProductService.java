package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;

//@Component //ela registra minha classe como componente do spring para poder ser injetado pelo autowired

@Service // para registrar um serviço na camada de serviço para ele ser registrado como autowired
public class ProductService {
	//para que o spring faça injeção de dependencia transparente ao programador
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> FindAll(){
		return repository.findAll();
	}
	
	public Product findById (Long id) {
		Optional <Product> obj = repository.findById(id);
		return obj.get(); // vai me retornar obj do tipo user que estiver dentro do obj
	}
}
