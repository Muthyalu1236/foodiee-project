package com.foodiee.mapper;

import com.foodiee.dao.Orders;
import com.foodiee.dto.OrdersDto;

public class OrderMapper {
	
	
	public static Orders mapToOrder(OrdersDto ordersDto) {
		
		return new Orders(
					ordersDto.getId(),
					ordersDto.getUsername(),
					ordersDto.getFooditem(),
					ordersDto.getQuantity(),
					ordersDto.getPrice()
				);
		
	}
	
	public static OrdersDto mapToOrderDto(Orders orders) {
		
		return new OrdersDto(
					orders.getId(),
					orders.getUsername(),
					orders.getFooditem(),
					orders.getQuantity(),
					orders.getPrice()
				);
		
	}

}
