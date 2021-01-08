package com.devsuperior.dsdeliver.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsdeliver.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	// ordenar do mais antigo para o mais recenete e os que nao foram entregados 
	
	@Query("SELECT DISTINCT obj FROM Order obj JOIN FETCH obj.products" //escreve a consulta no springboot,como se fosse no Sql,linguagem JPQL
			+ " WHERE obj.status = 0 ORDER BY obj.moment ASC")
		List<Order> findOrdersWithProducts();

}
