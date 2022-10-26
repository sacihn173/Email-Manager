package com.assign.emailManager.controllers;

import com.assign.emailManager.models.Email;
import com.assign.emailManager.models.Users;
import com.assign.emailManager.repositories.EmailJPARepository;
import com.assign.emailManager.repositories.UserJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class controller {

    @Autowired
    UserJPARepository userJPARepository;
    @Autowired
    EmailJPARepository emailJPARepository;

    @PostMapping("/user")
    public String createNewUser(@RequestBody Users users){
        userJPARepository.save(users);
        return "Saved";
    }

    @GetMapping("/users")
    public List<Users> getAllUsers(){
        return userJPARepository.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<Users> getUserById(@PathVariable("id") long id){
        return userJPARepository.findById(id);
    }

    @PostMapping("/email")
    public String createNewEmail(@RequestBody Email email){
        emailJPARepository.save(email);
        return "Saved";
    }

    @GetMapping("emails/count?user={userID}")
    public long countOfEmails(@PathVariable("userID") long userId){
        Users user = userJPARepository.findById(userId).orElse(null);
        System.out.println(user.getEmailAddress() + "1");
        if(user != null)
            return emailJPARepository.countOfEmails(user.getEmailAddress());
        else
            return 100;
    }

}
