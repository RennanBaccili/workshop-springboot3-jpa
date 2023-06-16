package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educandoweb.course.entities.Order;


@Repository //A interface JpaRepository ja herda do jpa repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
