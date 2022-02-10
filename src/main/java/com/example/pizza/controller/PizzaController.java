package com.example.pizza.controller;

import com.example.pizza.model.Pizza;
import com.example.pizza.service.PizzaImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PizzaController {

    private final PizzaImpl pizzaImpl;

    @RequestMapping("/")
    public String findById(Model model){
        Pizza pizza = pizzaImpl.get(1);
        Pizza pizza1 = pizzaImpl.get(2);
        Pizza pizza2 = pizzaImpl.get(3);
        model.addAttribute("pizza", pizza);
        model.addAttribute("pizza1", pizza1);
        model.addAttribute("pizza2", pizza2);
        return "index";
    }
}
