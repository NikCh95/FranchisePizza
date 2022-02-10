package com.example.pizza.service;

import com.example.pizza.model.Pizza;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaService {

    List<Pizza> list();
    void save(Pizza pizza);
    Pizza get(int id);
    void update(Pizza pizza);
    void delete(int id);
    void insert(Pizza pizza);
}
