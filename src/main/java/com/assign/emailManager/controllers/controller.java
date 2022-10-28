package com.assign.emailManager.controllers;

import com.assign.emailManager.models.Email;
import com.assign.emailManager.models.Users;
import com.assign.emailManager.repositories.EmailJPARepository;
import com.assign.emailManager.repositories.UserJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class controller {

    @Autowired
    UserJPARepository userJPARepository;
    @Autowired
    EmailJPARepository emailJPARepository;

    @PostMapping("/user")
    public ResponseEntity<?> createNewUser(@RequestBody Users users){
        HashMap resp = new HashMap();

        if(users.getFirstName() == null || users.getFirstName().equals("")){
            resp.put("message", "firstName field cannot be null or empty!");
            return ResponseEntity.badRequest().body(resp);
        }
        else if(users.getLastName() == null || users.getLastName().equals("")){
            resp.put("message", "lastName field cannot be null or empty!");
            return ResponseEntity.badRequest().body(resp);
        }
        else if(users.getEmailAddress() == null || users.getEmailAddress().equals("")){
            resp.put("message", "emailAddress cannot be null or empty!");
            return ResponseEntity.badRequest().body(resp);
        }
        else{
            Users user = userJPARepository.save(users);
            resp.put("message", "User saved successfully!");
            resp.put("Generated Id", user.getUserId());
            return ResponseEntity.ok().body(resp);
        }
    }

    @GetMapping("/users")
    public List<Users> getAllUsers(){
        return userJPARepository.findAll();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") long id){
        Users user = userJPARepository.findById(id).orElse(null);
        HashMap resp = new HashMap();

        if(user == null){
            resp.put("message", "No user found with id : " + id);
            return ResponseEntity.status(404).body(resp);
        }
        else{
            resp.put("message", "User found!");
            resp.put("User", user);
            return ResponseEntity.ok().body(resp);
        }
    }

    @PostMapping("/email")
    public ResponseEntity<?> createNewEmail(@RequestBody Email email){
        HashMap resp = new HashMap();

        if(email.getReceivedFrom() == null || email.getReceivedFrom().equals("")){
            resp.put("message", "receivedFrom cannot be null or empty!");
            return ResponseEntity.status(400).body(resp);
        }
        else if(email.getSendTo() == null || email.getSendTo().equals("")){
            resp.put("message", "sendTo cannot be null or empty!");
            return ResponseEntity.status(400).body(resp);
        }
        else {
            Email savedEmail = emailJPARepository.save(email);
            resp.put("message", "Email saved successfully!");
            resp.put("Generated Id", savedEmail.getEmailId());
            return ResponseEntity.ok().body(resp);
        }
    }

    @GetMapping("/emails/count/{userId}")
    public ResponseEntity<?> countOfEmails(@PathVariable("userId") long userId){
        Users user = userJPARepository.findById(userId).orElse(null);
        HashMap resp = new HashMap();

        if(user == null){
            resp.put("message", "No user with id : " + userId);
            return ResponseEntity.badRequest().body(resp);
        }
        else{
            resp.put("count", emailJPARepository.countOfEmails(user.getEmailAddress()));
            return ResponseEntity.ok().body(resp);
        }
    }

}
