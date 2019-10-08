package com.sectordefectuoso.service;

import com.sectordefectuoso.model.User;
import com.sectordefectuoso.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class UserService implements GenericService<User, String> {
    List<User> users = new ArrayList<>(
            Arrays.asList(
                    new User(
                            1, "xdd", "logged"),
                    new User(
                            1, "xdd", "logged"),
                    new User(
                            1, "xdd", "logged"),
                    new User(
                            1, "xdd", "logged"),
                    new User(
                            1, "xdd", "logged"),
                    new User(
                            1, "xdd", "logged")
            )
    );


    @Override
    public void create(User user) {
        users.add(user);
    }

    @Override
    public void update(User user) {
        User currentProduct = findById(String.valueOf(user.getUserid()));
        int index = users.indexOf(currentProduct);
        users.set(index, user);
    }

    @Override
    public void delete(User user) {
        users.remove(user);
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findById(String s) {
        return users.stream()
                .filter(p -> Integer.parseInt(s) == p.getUserid())
                .findFirst()
                .orElse(null);
    }
}
