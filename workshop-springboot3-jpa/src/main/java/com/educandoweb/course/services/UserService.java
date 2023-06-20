package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

//@Component //ela registra minha classe como componente do spring para poder ser injetado pelo autowired

@Service // para registrar um serviço na camada de serviço para ele ser registrado como autowired
public class UserService {
	//para que o spring faça injeção de dependencia transparente ao programador
	
	@Autowired
	private UserRepository repository;
	
	public List<User> FindAll(){
		return repository.findAll();
	}
	
	public User findById (Long id) {
		Optional <User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id)); // vai me retornar obj do tipo user que estiver dentro do obj
	}		//expressão lambida para tentar retornar objeto ou ativar exception
	
	//retorna um usuario salvo
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		try {
			User entity = repository.getReferenceById(id); // insdtanciar o usuario monitorando sem ir ao banco dedados
			updateData(entity,obj);
			return repository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	// função criadas para determinar qual dos dados podem ser alterados
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
