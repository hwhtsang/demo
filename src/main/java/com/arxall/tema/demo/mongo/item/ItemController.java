package com.arxall.tema.demo.mongo.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mongo")
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/items")
	public ResponseEntity<List<Item>> getAllItems() {
		return ResponseEntity.ok().body(itemService.getAllItems());
	}

	@GetMapping("/items/{id}")
	public ResponseEntity<Item> getItemById(@PathVariable long id) {
		return ResponseEntity.ok().body(itemService.getItemById(id));
	}
	
	@PostMapping("/items")
	public ResponseEntity<Item> createItem(@RequestBody Item item) {
		return ResponseEntity.ok().body(itemService.createItem(item));
	}

	@PutMapping("/items/{id}")
	public ResponseEntity<Item> updateItem(@PathVariable long id, @RequestBody Item item) {
		return ResponseEntity.ok().body(itemService.updateItem(item));
	}

	@DeleteMapping("/items/{id}")
	public HttpStatus deleteItem(@PathVariable long id) {
		itemService.deleteItem(id);
		return HttpStatus.OK;
	}
}
