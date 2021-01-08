package com.devsuperior.dsdeliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdeliver.dto.OrderDTO;
import com.devsuperior.dsdeliver.dto.ProductDTO;
import com.devsuperior.dsdeliver.entities.Order;
import com.devsuperior.dsdeliver.entities.OrderStatus;
import com.devsuperior.dsdeliver.entities.Product;
import com.devsuperior.dsdeliver.repositories.OrderRepository;
import com.devsuperior.dsdeliver.repositories.ProductRepository;

@Component
public class OrderService {
	
	@Autowired //ja faz resolução da dependencia
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true) //garantir que fecha conexao com banco
	public List<OrderDTO> findAll() {
		List<Order> list = repository.findOrdersWithProducts();
		// Transformar Lista product em product DTO
		return list.stream().map(x -> new OrderDTO(x))
				.collect(Collectors.toList());
	}
	
	@Transactional 
	public OrderDTO insert(OrderDTO dto) { // para receber no metodo,tem que ser na ordem dos parâmetros ,instanciando order no order DTO
		Order order = new Order(null, //id nul porque esta mandando um novo pedido
				dto.getAddress(),
				dto.getLatitude(),
				dto.getLongitude(),
				Instant.now(), 
				OrderStatus.PENDING); //instanciando um novo objeto do tipo order com esses valores
		
		for(ProductDTO p : dto.getProducts()) { //percorrer todo product dto e chamar cada um de p
			Product product = productRepository.getOne(p.getId()); //instanciando produto com base no id do p
			order.getProducts().add(product); //adicionando na lista dos produtos do order que acabou de instanciar
			
		}
		order = repository.save(order); //salvarno banco.
		return new OrderDTO(order); // retornar objeto convertido DTO
		}
	// Metodo para inserir um novo pedido ,já associado com produtos dele
	@Transactional 
	public OrderDTO setDelivered(Long id) {
		Order order = repository.getOne(id); // alterar registro = getOne monitorado JPA
		order.setStatus(OrderStatus.DELIVERED); //pedido entregue
		order = repository.save(order); //pedido entregue salvo
		return new OrderDTO(order);
	}
	
	}
	

