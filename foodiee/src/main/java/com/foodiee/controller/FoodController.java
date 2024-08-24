package com.foodiee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodiee.dao.Food;
import com.foodiee.dto.FoodDto;
import com.foodiee.mapper.FoodMapper;
import com.foodiee.service.FoodService;

//@CrossOrigin(origins = "http://localhost:5173")
@CrossOrigin("*")
@RequestMapping("/food")
@RestController
public class FoodController {
	
	@Autowired
	FoodService foodService;
	
	@GetMapping("/{type}")
	List<FoodDto> getFood(@PathVariable String type){
		List<Food> foodItems = foodService.getFoodByType(type);
		
		List<FoodDto> foodItemsDto = foodItems.stream().map((food)->FoodMapper.mapToFoodDto(food)).toList();
		
		return foodItemsDto;
	}
	
}
