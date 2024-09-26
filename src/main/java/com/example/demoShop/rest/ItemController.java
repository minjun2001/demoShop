package com.example.demoShop.rest;

import com.example.demoShop.dao.ItemRepository;
import com.example.demoShop.entity.Item;
import com.example.demoShop.service.ItemService;
import com.example.demoShop.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ItemController {
    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

//    get all item
    @GetMapping
    public List<Item> getAllItems() {
        return this.itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable int id) {
        Item item = itemService.getItemById(id);
        if (item != null) {
            return ResponseEntity.ok(item);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        item.setId(0);
        item = itemService.addItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable int id, @RequestBody Item item) {
        Item existingitem = itemService.getItemById(id);
        if (existingitem != null) {
            existingitem.setName(item.getName());
            existingitem.setDescription(item.getDescription());
            existingitem.setPrice(item.getPrice());
            existingitem.setStock(item.getStock());
            itemService.updateItem(existingitem);
            return ResponseEntity.ok(existingitem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Item> deleteItem(@PathVariable int id) {
        Item existingItem = itemService.getItemById(id);
    }


}
