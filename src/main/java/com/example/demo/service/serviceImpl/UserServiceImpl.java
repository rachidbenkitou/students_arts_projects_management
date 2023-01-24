package com.example.demo.service.serviceImpl;

import com.example.demo.dao.RoleRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;

import com.example.demo.service.serviceInt.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);

    }

    @Override
    public User findById(Long theId) {
        Optional<User> result=userRepository.findById(theId);

        User theUser=null;
        if(result.isPresent()){
            theUser=result.get();
        }
        else {
            throw  new RuntimeException("L'utilisateur qui a Id :"+theId+"n'existe pas");
        }
        return theUser;
    }



    @Override
    public void deleteById(Long theId) {
        userRepository.deleteById(theId);
    }

    @Override
    public List<User> searchBy(String username) {
        return userRepository.findByUsername(username);
    }


}
