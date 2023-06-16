package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;

//@Component //ela registra minha classe como componente do spring para poder ser injetado pelo autowired

@Service // para registrar um serviço na camada de serviço para ele ser registrado como autowired
public class OrderService {
	//para que o spring faça injeção de dependencia transparente ao programador
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> FindAll(){
		return repository.findAll();
	}
	
	public Order findById (Long id) {
		Optional <Order> obj = repository.findById(id);
		return obj.get(); // vai me retornar obj do tipo user que estiver dentro do obj
	}
}
