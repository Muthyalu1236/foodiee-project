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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.foodiee.dto.OrdersDto;
import com.foodiee.service.OrdersService;

@CrossOrigin("*")
@RequestMapping("/orders")
@RestController
public class OrdersController {
	
	@Autowired
	OrdersService ordersService;
	
	@PostMapping("/insert")
	public ResponseEntity<String> insertOrder(@RequestBody OrdersDto orderData){
		
		ordersService.createOrder(orderData);
		
		return new ResponseEntity<>("Order inserted successfully."+orderData.getFooditem(),HttpStatus.OK);
		
	}
	
	@PostMapping("/insertAll")
	public ResponseEntity<String> insertAllOrders(@RequestBody List<OrdersDto> ordersDto){
		
		ordersService.createOrders(ordersDto);
		
		return new ResponseEntity<>("Multiple orders inserted successfully.",HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<OrdersDto>> getOrders(){
		
		List<OrdersDto> ordersDto = ordersService.getOrders();
		
		return new ResponseEntity<>(ordersDto,HttpStatus.OK);
		
	}
	
	@GetMapping("/getBy/{username}")
	public ResponseEntity<List<OrdersDto>> getOrders(@PathVariable String username){
		
		List<OrdersDto> ordersDto = ordersService.getOrdersByUsername(username);
		
		return new ResponseEntity<>(ordersDto,HttpStatus.OK);
		
	}
	

}
