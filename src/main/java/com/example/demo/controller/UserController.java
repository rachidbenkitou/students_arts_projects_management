package com.example.demo.controller;


import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.service.serviceInt.RoleService;
import com.example.demo.service.serviceInt.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    @GetMapping("/list")
    public String showEntretiensList(Model model){

        List<User> userList=userService.findAll();
        model.addAttribute("userList",userList);

        return "lists/list-user";

    }

    @GetMapping("/form")
    public String showFormForAdd(Model model){

        User user=new User();
        model.addAttribute("user",user);

        List<Role> roleList=roleService.findAll();
        model.addAttribute("roleList",roleList);

        return "forms/form-user";
    }


    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("user") @Validated User user, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "lists/list-user";
        }
        else {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            userService.save(user);
            return "redirect:/users/list";

        }

    }


    @GetMapping("/delete/{userId}")
    public String deleteEntretien(@PathVariable Long userId){

        userService.deleteById(userId);

        return "redirect:/users/list";
    }




    @GetMapping("/edit/{userId}")
    public String showEditForm(@PathVariable  Long userId,Model model){
        User user=userService.findById(userId);
        model.addAttribute("user",user);
        List<Role> roleList=roleService.findAll();
        model.addAttribute("roleList",roleList);

        return "forms/form-user";
    }

    @GetMapping("/search")
    public String searchByType(@RequestParam("username") String username,Model model){

        if(username.trim().isEmpty()){
            return "redirect:/users/list";
        }else {
            List<User> userList=userService.searchBy(username);

            model.addAttribute("userList",userList);

            return "lists/list-user";
        }
    }
}
