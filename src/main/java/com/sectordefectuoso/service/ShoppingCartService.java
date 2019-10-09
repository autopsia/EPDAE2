package com.sectordefectuoso.service;

import com.sectordefectuoso.model.ShoppingCart;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ShoppingCartService {

    List<ShoppingCart> shoppingCarts = new ArrayList<>(
            Arrays.asList(
                    new ShoppingCart("1212","1",2)
            )
    );

    public void addCartItem(ShoppingCart shoppingCart){
        shoppingCarts.add(shoppingCart);
    }

    public void updateQuantity(){

    }

    public void viewCartDetail(){

    }


    public List<ShoppingCart> getAll() {
        return shoppingCarts;
    }
}