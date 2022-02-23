package com.arxall.tema.demo.mongo.item;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemRepository itemRepository;

	@Override
	public Item createItem(Item item) {
		return this.itemRepository.save(item);
	}

	@Override
	public Item updateItem(Item item) {
	    Optional<Item> itemFromDBOrNot = this.itemRepository.findById(item.getId());
		if (itemFromDBOrNot.isPresent()) {
		    Item itemFromDB = itemFromDBOrNot.get();
		    itemFromDB.setId(item.getId());
		    itemFromDB.setItemCode(item.getItemCode());
		    itemFromDB.setItemName(item.getItemName());
		    itemFromDB.setUnitPrice(item.getUnitPrice());
		    this.itemRepository.save(itemFromDB);
		    return itemFromDB;
		} else {
		    throw new NoSuchElementException("Record not found with id : " + item.getId());
		}
	}

	@Override
	public List<Item> getAllItems() {
		return this.itemRepository.findAll();
	}

	@Override
	public Item getItemById(long id) {
		Optional<Item> itemOrNot = this.itemRepository.findById(id);
		if (itemOrNot.isPresent()) {
			return itemOrNot.get();
		} else {
			return null;
		}
	}

	@Override
	public void deleteItem(long id) {
		this.itemRepository.deleteById(id);
	}
}
