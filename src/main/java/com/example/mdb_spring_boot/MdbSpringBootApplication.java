package com.example.mdb_spring_boot;

import com.example.mdb_spring_boot.model.GroceryItem;
import com.example.mdb_spring_boot.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MdbSpringBootApplication {

	@Autowired
	ItemRepository groceryItemRepo;

	public static void main(String[] args) {
		SpringApplication.run(MdbSpringBootApplication.class, args);
	}

// CREATE
	void createGroceryItems() {
		System.out.println("Data creation started...");
		groceryItemRepo.save(new GroceryItem("Whole Wheat Biscuit", "Whole Wheat Biscuit", 5, "snacks"));
		groceryItemRepo.save(new GroceryItem("KodoMillet", "XYZ Kodo Millet healthy", 2, "millets"));
		groceryItemRepo.save(new GroceryItem("Dried REd Chilli", "Dried Whole Red Chilli", 2, "spices"));
		groceryItemRepo.save(new GroceryItem("Pearl Millet", "Healthy Pearl Millet", 1, "millets"));
		groceryItemRepo.save(new GroceryItem("Cheese Crakers", "Bonny Cheese Crackers Plain", 6, "snacks"));
		System.out.println("Data creation complete...");
	}

// READ
	// 1. Show all the data
	public void showAllGroceryItems() {
		groceryItemRepo.findAll().forEach(item -> System.out.println(getItemDetails(item)));
	}

	// 2. Get item by name
	public void getGroceryItemByName(String name) {
		System.out.println("Getting item by name: " + name);
		GroceryItem item = groceryItemRepo.findItemByName(name);
	}

	// 3. Get name and quantity of a all items of particular category
	public void getItemsByCategory(String category) {
		System.out.println("Getting items for the category " + category);
		List<GroceryItem> list = groceryItemRepo.findAll(category);

		list.forEach(item -> System.out.println("Name: " + item.getName() + ", Quantity: " + item.getQuantity()));
	}

	// 4. Get count of documents in the collection
	public void findCountOfGroceryItems() {
		long count = groceryItemRepo.count();
		System.out.println("Number of documents in the collection: " + count);
	}



}
