package com.devsuperior.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdeliver.dto.ProductDTO;
import com.devsuperior.dsdeliver.entities.Product;
import com.devsuperior.dsdeliver.repositories.ProductRepository;

@Component
public class ProductService {
	
	@Autowired //ja faz resolução da dependencia
	private ProductRepository repository;
	
	@Transactional(readOnly = true) //garantir que fecha conexao com banco
	public List<ProductDTO> findAll() {
		List<Product> list = repository.findALlByOrderByNameAsc();
		// Transformar Lista product em product DTO
		return list.stream().map(x -> new ProductDTO(x))
				.collect(Collectors.toList());
	}
}
