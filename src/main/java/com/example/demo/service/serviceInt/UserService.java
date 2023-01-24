package com.example.demo.service.serviceInt;


import com.example.demo.entity.User;
import java.util.List;

public interface UserService {


    public List<User> findAll();
    public void save(User user);

    public User findById(Long theId);

    public void deleteById(Long theId);

    public List<User> searchBy(String username);




}
