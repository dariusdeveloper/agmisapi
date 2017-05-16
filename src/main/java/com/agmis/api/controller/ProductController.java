package com.agmis.api.controller;

import com.agmis.api.entity.Item;
import com.agmis.api.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/items")
public class ProductController {

    private ItemRepository repository;

    @Autowired
    ProductController(ItemRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/search")
    public Collection<Item> search(@RequestParam("keyword") String keyword) {
        return this.repository.findByKeyword(keyword);
    }
}