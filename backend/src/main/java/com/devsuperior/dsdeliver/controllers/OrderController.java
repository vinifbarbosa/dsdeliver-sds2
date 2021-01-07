package com.devsuperior.dsdeliver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsdeliver.dto.OrderDTO;
import com.devsuperior.dsdeliver.services.OrderService;

@RestController //controlador rest
@RequestMapping(value = "/orders") //definir caminho do recurso controller
public class OrderController {

	 @Autowired //injetar dependência do product service
	 private OrderService service;
	 
	 @GetMapping //end point metodo get http
	 public ResponseEntity<List<OrderDTO>> findALl() { //ResponseEntity spring boot capsula uma resposta http
		 List<OrderDTO> list = service.findAll(); // criar variavel tipo list recebendo o service.findall
		 return ResponseEntity.ok().body(list); //OK é metodo que cria resposta de sucesso codigo 200 htttp
	 }
}
