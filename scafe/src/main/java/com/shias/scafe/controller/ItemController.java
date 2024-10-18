package com.shias.scafe.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shias.scafe.model.Item;
import com.shias.scafe.repository.ItemRepository;
import com.shias.scafe.repository.SearchRepository;


@RestController
public class ItemController {
	
	
	private ItemRepository iRepo;
	private SearchRepository sRepo;
	
	public ItemController(ItemRepository repo, SearchRepository sRepo) {
		this.iRepo = repo;
		this.sRepo = sRepo;
	}
	
	@GetMapping("/items")
	public List<Item> getAllItems(){
		
		return iRepo.findAll();
	}
	
	@PostMapping("/items")
	public Item addItem(@RequestBody Item item) {
		return iRepo.save(item);
	}
	
	@GetMapping("/items/{text}")
	public List<Item> search(@PathVariable String text){
		return sRepo.findByText(text);
	}

}
