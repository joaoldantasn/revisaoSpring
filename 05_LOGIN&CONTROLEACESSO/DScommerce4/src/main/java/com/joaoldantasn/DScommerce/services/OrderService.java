package com.joaoldantasn.DScommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaoldantasn.DScommerce.dto.OrderDTO;
import com.joaoldantasn.DScommerce.entities.Order;
import com.joaoldantasn.DScommerce.exceptions.ResourceNotFoundException;
import com.joaoldantasn.DScommerce.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Transactional(readOnly = true)
	public OrderDTO findById(Long id) {
		Order order = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Recurso não encontrado"));
		return new OrderDTO(order);
	}
	

}
