package com.techelevator.foodiary.dao;

import com.techelevator.foodiary.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User getUserById(int id);

    User findByUsername(String username);

    int findIdByUsername(String username);

    boolean create(String username, String password, String firstName, String lastName);

}
