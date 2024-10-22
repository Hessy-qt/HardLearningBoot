package com.example.kots.beans.beans.service;

import com.example.kots.beans.beans.models.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void deleteUser(int id);
    List<User> getAllUsers();
    void updateUser(int id,User user);
}
