package com.foodiee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodiee.dao.Orders;
import com.foodiee.dto.OrdersDto;
import com.foodiee.mapper.OrderMapper;
import com.foodiee.service.OrdersService;

@CrossOrigin("*")
@RestController
public class OrdersController {
	
	@Autowired
	OrdersService ordersService;
	
	@PostMapping("/insertOrder")
	public ResponseEntity<String> insertOrder(@RequestBody OrdersDto orderData){
		
		ordersService.createOrder(orderData);
		
		return new ResponseEntity<>("Order inserted successfully."+orderData.getFooditem(),HttpStatus.OK);
		
	}
	
	@PostMapping("/insertAllOrders")
	public ResponseEntity<String> insertAllOrders(@RequestBody List<OrdersDto> ordersDto){
		ordersService.createOrders(ordersDto);
		return new ResponseEntity<>("Multiple orders inserted successfully.",HttpStatus.OK);
	}
	
	@GetMapping("/getOrders")
	public ResponseEntity<List<OrdersDto>> getOrders(){
		
		List<Orders> orders = ordersService.getOrders();
		
		List<OrdersDto> ordersDto = orders.stream().map((order)->OrderMapper.mapToOrderDto(order)).toList();
		
		return new ResponseEntity<>(ordersDto,HttpStatus.OK);
		
	}
	
	@GetMapping("/getOrdersBy/{username}")
	public ResponseEntity<List<OrdersDto>> getOrders(@PathVariable String username){
		
		List<Orders> orders = ordersService.getOrdersByUsername(username);
		
		List<OrdersDto> ordersDto = orders.stream().map((order)->OrderMapper.mapToOrderDto(order)).toList();
		
		return new ResponseEntity<>(ordersDto,HttpStatus.OK);
		
	}
	

}
