package com.assignment2.assignment2.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.assignment2.assignment2.models.User;
import com.assignment2.assignment2.models.UserRepository;

import jakarta.servlet.http.HttpServletResponse;


@Controller
public class UsersController {
    
    @Autowired
    private UserRepository userRepo;

    
    // data coming from form would be a PostMapping
    @GetMapping("/users/mainPage")
    public String getAllUsers(Model model){
        System.out.println("getting users");
        List<User> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "users/showAll";
    }
    @PostMapping("/users/add")
    public String addUser(@RequestParam Map<String, String> newuser, HttpServletResponse response, Model model){
        System.out.println("ADD user");
        String newName = newuser.get("name");
        String newPwd = newuser.get("password"); 
        double newGpa = Double.parseDouble(newuser.get("gpa"));
        int newHeight = Integer.parseInt(newuser.get("height"));
        int newWeight = Integer.parseInt(newuser.get("weight"));
        String newColour = newuser.get("colour");
        String newIG = newuser.get("ig");
        userRepo.save(new User(newName, newPwd, newGpa, newHeight, newWeight, newColour, newIG));
        response.setStatus(201);
        System.out.println("getting users");
        List<User> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "redirect:/users/mainPage";
    }
     @PostMapping("/users/remove")
    public String removeUser(@RequestParam("uid") int uid, HttpServletResponse response, Model model){
        userRepo.deleteById(uid);
        System.out.println("getting users");
        List<User> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "redirect:/users/mainPage";
    }
    @PostMapping("/users/edit") 
public String editUser(@RequestParam Map<String, String> edituser, HttpServletResponse response, Model model) { 
    System.out.println("Edit user"); 
    String newName = edituser.get("name"); 
    String newPwd = edituser.get("password"); 
    int id =  Integer.parseInt(edituser.get("uid")); 
    double gpa = Double.parseDouble(edituser.get("gpa"));
    int height = Integer.parseInt(edituser.get("height"));
    int weight = Integer.parseInt(edituser.get("weight"));
    String colour = edituser.get("colour");
    String IG = edituser.get("ig");
    User u = userRepo.findById(id).get(); 
    u.setName(newName); 
    u.setPassword(newPwd); 
    u.setGpa(gpa); 
    u.setHeight(height);
    u.setWeight(weight);
    u.setColour(colour);
    u.setIg(IG);
    userRepo.save(u); 

        response.setStatus(201); 
        System.out.println("getting users"); 
        List<User> users = userRepo.findAll(); 
        model.addAttribute("users", users); 
        return "redirect:/users/mainPage";

} 

  @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        model.addAttribute("errorMessage", "An unexpected error occurred: " + e.getMessage());
        return "error";
    }
    @GetMapping("/users/addNewUser")
    public String showAddNewUserPage() {
        return "users/addNewUser";
    }
    @GetMapping("/users/editUser")
    public String showEditUserPage(@RequestParam("uid") int uid, @RequestParam("name") String name,  @RequestParam("password") String password, @RequestParam("gpa") double gpa, @RequestParam("height") int height, @RequestParam("weight") int weight, @RequestParam("colour") String colour, @RequestParam("ig") String ig,   Model model) {
        model.addAttribute("uid", uid);
        model.addAttribute("name", name);
        model.addAttribute("password", password);
        model.addAttribute("gpa", gpa);
        model.addAttribute("height", height);
        model.addAttribute("weight", weight);
        model.addAttribute("colour", colour);
        model.addAttribute("ig", ig);
        return "users/editUser";
    }
    
}