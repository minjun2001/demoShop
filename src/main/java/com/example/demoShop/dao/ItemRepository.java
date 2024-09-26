package com.example.demoShop.dao;

import com.example.demoShop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
