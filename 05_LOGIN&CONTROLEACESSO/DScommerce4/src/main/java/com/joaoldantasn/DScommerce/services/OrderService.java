package com.joaoldantasn.DScommerce.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaoldantasn.DScommerce.dto.OrderDTO;
import com.joaoldantasn.DScommerce.dto.OrderItemDTO;
import com.joaoldantasn.DScommerce.entities.Order;
import com.joaoldantasn.DScommerce.entities.OrderItem;
import com.joaoldantasn.DScommerce.entities.OrderStatus;
import com.joaoldantasn.DScommerce.entities.Product;
import com.joaoldantasn.DScommerce.entities.User;
import com.joaoldantasn.DScommerce.exceptions.ResourceNotFoundException;
import com.joaoldantasn.DScommerce.repositories.OrderItemRepository;
import com.joaoldantasn.DScommerce.repositories.OrderRepository;
import com.joaoldantasn.DScommerce.repositories.ProductRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthService authService;
	
	@Transactional(readOnly = true)
	public OrderDTO findById(Long id) {
		Order order = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Recurso não encontrado"));
		authService.validateSelfOrAdmin(order.getClient().getId());
		return new OrderDTO(order);
	}
	
	@Transactional
	public OrderDTO insert (OrderDTO dto) {

		Order order = new Order();
		order.setMoment(Instant.now());
		order.setStatus(OrderStatus.WAITING_PAYMENT);
		
		User user = userService.authenticated();
		order.setClient(user);
		
		for (OrderItemDTO itemDTO : dto.getItems()) {
			Product product = productRepository.getReferenceById(itemDTO.getProductId());
			OrderItem item = new OrderItem(order, product, itemDTO.getQuantity(), product.getPrice());
			order.getItems().add(item);
		}
		
		repository.save(order);
		orderItemRepository.saveAll(order.getItems());
		return new OrderDTO(order);
		
	}
	

}
