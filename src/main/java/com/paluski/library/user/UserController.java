package com.paluski.library.user;

import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/v1/newUser")
    public ResponseEntity<User> postUser(@RequestBody User user){
        try{
            userService.createUser(user);
            return ResponseEntity.ok(user);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(user);
        }
    }

    @GetMapping("/v1/getUsers")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(userService.getUsers());
    }

    @PutMapping("/v1/editUser/{id}")
    public ResponseEntity<User> putUser(@PathVariable Long id, @RequestBody User user){
        try{
            userService.editUser(id, user);
            return ResponseEntity.ok(user);
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(user);
        }
    }

    @DeleteMapping("/v1/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        try{
            userService.deleteUser(id);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        return ResponseEntity.ok("User deleted Successfully!");
    }

}
