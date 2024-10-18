package com.shias.scafe.model;

import java.util.Arrays;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="items")
public class Item {
    
	private String title;
	private String desc;
	private String ingredient[];
	private int calorie;
	
	public Item(String title, String desc, String[] ingredient, int calorie) {
		super();
		this.title = title;
		this.desc = desc;
		this.ingredient = ingredient;
		this.calorie = calorie;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String[] getIngredient() {
		return ingredient;
	}
	
	public void setIngredient(String[] ingredient) {
		this.ingredient = ingredient;
	}
	
	public int getCalorie() {
		return calorie;
	}
	
	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}

	@Override
	public String toString() {
		return "Item [title=" + title + ", desc=" + desc + ", ingredient=" + Arrays.toString(ingredient) + ", calorie="
				+ calorie + "]";
	}

}
