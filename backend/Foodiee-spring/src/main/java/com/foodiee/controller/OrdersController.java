package com.foodiee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodiee.dao.Orders;import com.foodiee.repository.OrdersRepository;

@CrossOrigin("*")
@RequestMapping("/orders")
@RestController
public class OrdersController {
	
	@Autowired
	OrdersRepository ordersRepo;
	
	@PostMapping("/insert")
	public ResponseEntity<String> insertOrder(@RequestBody Orders order){
		
		ordersRepo.save(order);
		
		return new ResponseEntity<>("Order inserted successfully."+order.getFooditem(),HttpStatus.OK);
		
	}
	
	@PostMapping("/insertAll")
	public ResponseEntity<String> insertAllOrders(@RequestBody List<Orders> orders){
		
		orders.stream().map((order)->ordersRepo.save(order)).toList();
		
		return new ResponseEntity<>("Multiple orders inserted successfully.",HttpStatus.OK);
	}
	
//	@GetMapping("/get")
//	public ResponseEntity<List<Orders>> getOrders(){
//		
//		List<Orders> orders = ordersRepo.findAll();
//		
//		return new ResponseEntity<>(orders,HttpStatus.OK);
//		
//	}
//	
//	@GetMapping("/getBy/{username}")
//	public ResponseEntity<List<Orders>> getOrders(@PathVariable String username){
//		
//		List<Orders> orders = ordersRepo.findByUsername(username);
//		
//		return new ResponseEntity<>(orders,HttpStatus.OK);
//		
//	}
	

}
