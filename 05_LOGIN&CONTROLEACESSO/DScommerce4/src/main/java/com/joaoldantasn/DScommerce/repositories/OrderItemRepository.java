package com.joaoldantasn.DScommerce.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joaoldantasn.DScommerce.entities.OrderItem;
import com.joaoldantasn.DScommerce.entities.OrderItemPK;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{
	
}
