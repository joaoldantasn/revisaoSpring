package com.joaoldantasn.DScommerce.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaoldantasn.DScommerce.entities.Product;
import com.joaoldantasn.DScommerce.repositories.ProductRepository;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
	
	@Autowired
	private ProductRepository repository;
	
	@GetMapping
	public String teste() {
		Optional<Product> result = repository.findById(1L);
		Product product = result.get();
		return product.getName();
	}
}
