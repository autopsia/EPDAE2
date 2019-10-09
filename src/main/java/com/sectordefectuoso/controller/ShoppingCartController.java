package com.sectordefectuoso.controller;

import com.sectordefectuoso.model.ShoppingCart;
import com.sectordefectuoso.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping("/shoppingCarts")
    public String getStudentList(Model model) {
        //list
        List<ShoppingCart> shoppingCarts = shoppingCartService.getAll();
        model.addAttribute("shoppingCarts", shoppingCarts);
        return "shoppingCart";
    }

    @GetMapping("/shoppingCarts/add")
    public String addCartItem(Model model){

        model.addAttribute("shoppingCart", new ShoppingCart());
        return "shoppingCart-add";
    }

    @PostMapping("/shoppingCarts/add")
    public String addCartItem(ShoppingCart shoppingCart,
                              Model model) {
        //add
        shoppingCartService.addCartItem(shoppingCart);

        //list
        List<ShoppingCart> shoppingCarts = shoppingCartService.getAll();
        model.addAttribute("shoppingCarts", shoppingCarts);

        return "shoppingCart";
    }


}