package com.sectordefectuoso.service;

import com.sectordefectuoso.model.Costumer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CostumerService implements GenericService<Costumer, String> {
    List<Costumer> costumers = new ArrayList<>(
            Arrays.asList(
                    new Costumer(
                             "1", "","oscar", "asd", "1",  "3411241", 0.2d)
            )
    );

    @Override
    public void create(Costumer costumer) {
        costumers.add(costumer);
    }

    @Override
    public void update(Costumer costumer) {
        Costumer currentProduct = findById(String.valueOf(costumer.getUserid()));
        int index = costumers.indexOf(currentProduct);
        costumers.set(index, costumer);
    }

    @Override
    public void delete(Costumer costumer) {
        costumers.remove(costumer);
    }

    @Override
    public List<Costumer> findAll() {
        return costumers;
    }

    @Override
    public Costumer findById(String s) {
        return costumers.stream()
                .filter(p -> Integer.parseInt(s) == p.getUserid())
                .findFirst()
                .orElse(null);
    }
    public Costumer login(String email, String password){
        return costumers.stream()
                .filter(c -> email.equalsIgnoreCase(c.getEmail()) && password.equalsIgnoreCase(c.getPassword()))
                .findFirst()
                .orElseGet(null);
    }

    public void register(Costumer customer){
        costumers.add(customer);
    }
}
