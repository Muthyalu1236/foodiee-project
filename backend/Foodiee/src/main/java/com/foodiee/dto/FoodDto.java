package com.foodiee.dto;

public class FoodDto {
	
	int id;
	String name;
	String description;
	float rating;
	int price;
	String image;
	String type;
	
	public FoodDto() {

	}
	
	public FoodDto(int id, String name, String description, float rating, int price, String image, String type) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.rating = rating;
		this.price = price;
		this.image = image;
		this.type = type;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public float getRating() {
		return rating;
	}
	
	public void setRating(float rating) {
		this.rating = rating;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "FoodDto [id=" + id + ", name=" + name + ", description=" + description + ", rating=" + rating
				+ ", price=" + price + ", image=" + image + ", type=" + type + "]";
	}
	
	
}
