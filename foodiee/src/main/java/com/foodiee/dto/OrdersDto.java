package com.foodiee.dto;

public class OrdersDto {
	
	int id;
	String username;
	String fooditem;
	int quantity;
	int price;
	
	public OrdersDto() {
		
	}
	public OrdersDto(int id, String username, String fooditem, int quantity, int price) {
		super();
		this.id = id;
		this.username = username;
		this.fooditem = fooditem;
		this.quantity = quantity;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFooditem() {
		return fooditem;
	}
	public void setFooditem(String fooditem) {
		this.fooditem = fooditem;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "OrdersDto [id=" + id + ", username=" + username + ", fooditem=" + fooditem + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}
	
	

}
