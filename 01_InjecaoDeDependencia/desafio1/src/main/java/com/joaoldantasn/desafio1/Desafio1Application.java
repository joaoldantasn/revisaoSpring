package com.joaoldantasn.desafio1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.joaoldantasn.desafio1.entities.Order;
import com.joaoldantasn.desafio1.services.OrderService;

@SpringBootApplication
public class Desafio1Application implements CommandLineRunner{
	
	@Autowired
	OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(Desafio1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Order order = new Order(1309, 95.90, 0.0);
		System.out.println("Pedido código: " + order.getCode());
		System.out.println("Valor total: " + orderService.total(order));
		
	}

}
