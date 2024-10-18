package com.shias.scafe.repository;

import java.util.List;

import com.shias.scafe.model.Item;

public interface SearchRepository {
	
	List<Item> findByText(String text);

}
