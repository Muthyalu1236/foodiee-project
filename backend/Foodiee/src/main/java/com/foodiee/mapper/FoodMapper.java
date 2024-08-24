package com.foodiee.mapper;

import com.foodiee.dao.Food;
import com.foodiee.dto.FoodDto;

public class FoodMapper {
	
	public static FoodDto mapToFoodDto(Food food) {
		return new FoodDto(
				food.getId(),
				food.getName(),
				food.getDescription(),
				food.getRating(),
				food.getPrice(),
				food.getImage(),
				food.getType()
				);
	}
	
	public static Food mapToFood(FoodDto foodDto) {
		return new Food(
				foodDto.getId(),
				foodDto.getName(),
				foodDto.getDescription(),
				foodDto.getRating(),
				foodDto.getPrice(),
				foodDto.getImage(),
				foodDto.getType()
				);
	}
	
}
