package com.foodiee.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodiee.dao.Food;
import com.foodiee.repository.FoodRepository;
import com.foodiee.service.FoodService;

@Service
public class FoodImplementation implements FoodService{
	
	@Autowired
	FoodRepository foodRepo;

	@Override
	public List<Food> getFoodByType(String type) {
		List<Food> foodItems = foodRepo.findByType(type);
		return foodItems;
	}

}
