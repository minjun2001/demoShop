package com.example.demoShop.service;

import com.example.demoShop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemService {

    public List<Item> getAllItems();

    public Item getItemById(int id);

    public Item addItem(Item item);

    public Item updateItem(Item item);

    public void deleteItem(int id);

}
