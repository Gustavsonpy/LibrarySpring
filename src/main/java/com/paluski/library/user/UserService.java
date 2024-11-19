package com.paluski.library.user;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User editUser(Long id, User user) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setName(user.getName());
                    existingUser.setCpf(user.getCpf());
                    existingUser.setEmail(user.getEmail());
                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }

//    public ResponseEntity<String> deleteUser(Long id){
//        userRepository.findById(id)
//                .ifPresent(existingUser -> userRepository.delete(existingUser));
//        return ResponseEntity.ok("User deleted Successfully");
//    }

    public void deleteUser(Long id) {
        if(userRepository.existsById(id)){
            System.out.println("\n\nEntrou aqui!\n\n");
            userRepository.deleteById(id);
        }else{
            throw new EntityNotFoundException();
        }
    }
}