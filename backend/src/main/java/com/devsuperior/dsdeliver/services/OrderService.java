package com.devsuperior.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdeliver.dto.OrderDTO;
import com.devsuperior.dsdeliver.entities.Order;
import com.devsuperior.dsdeliver.repositories.OrderRepository;

@Component
public class OrderService {
	
	@Autowired //ja faz resolução da dependencia
	private OrderRepository repository;
	
	@Transactional(readOnly = true) //garantir que fecha conexao com banco
	public List<OrderDTO> findAll() {
		List<Order> list = repository.findOrdersWithProducts();
		// Transformar Lista product em product DTO
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
}
