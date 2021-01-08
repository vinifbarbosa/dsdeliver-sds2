package com.devsuperior.dsdeliver.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	 
	 //endpoint para salvar 	 
	 @PostMapping //Metodo http vai ser post
	 public ResponseEntity<OrderDTO> insert (@RequestBody OrderDTO dto) {
		 dto = service.insert(dto); //chamando metodo la do service
		
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				 .path("/{id}").buildAndExpand(dto.getId()).toUri(); //.path para definir caminho do  recurso
		 	return ResponseEntity.created(uri).body(dto);//quando recurso é criado ok,codigo 201
	 }
	 	@PutMapping("/{id}/delivered")
	 	public ResponseEntity<OrderDTO> setDelivered(@PathVariable Long id)  {
	 		OrderDTO dto = service.setDelivered(id); //chamar service,setado como entregue
	 		return ResponseEntity.ok().body(dto);
	 	}
}
