package com.shias.scafe.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.shias.scafe.model.Item;

@Component
public class SearchRepositoryImpl implements SearchRepository{

	MongoClient mongoClient;
	MongoConverter converter;
	
	public SearchRepositoryImpl(MongoClient mongoClient, MongoConverter converter) {
		this.mongoClient = mongoClient;
		this.converter = converter;
	}
	
	@Override
	public List<Item> findByText(String text) {
		
		final List<Item> items = new ArrayList<Item>();
		
		MongoDatabase database = mongoClient.getDatabase("sCafe");
		MongoCollection<Document> collection = database.getCollection("items");

		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search", 
		    new Document("index", "default").append("text", 
		    		new Document("query", text).append("path", Arrays.asList("title", "desc", "ingredient")))), 
			new Document("$sort", 
		    new Document("calorie", 1L))));
		
		
		// Convert the mongo doc to Item type
		result.forEach(doc -> items.add(converter.read(Item.class, doc)));
		
		return items;
	}

}
