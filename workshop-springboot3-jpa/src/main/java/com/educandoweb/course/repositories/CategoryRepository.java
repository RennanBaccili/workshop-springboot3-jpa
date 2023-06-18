package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educandoweb.course.entities.Category;
// repositorio de jpa

@Repository //A interface JpaRepository ja herda do jpa repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
