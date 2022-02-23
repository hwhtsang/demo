package com.arxall.tema.demo.mongo.item;

import java.util.List;

public interface ItemService {
    Item createItem(Item item);

    Item updateItem(Item item);

    List<Item> getAllItems();

    Item getItemById(long id);

    void deleteItem(long id);
}
