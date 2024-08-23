package com.foodiee.service;

import java.util.List;

import com.foodiee.dao.Food;

public interface FoodService {
	
	List<Food> getFoodByType(String type);

}
