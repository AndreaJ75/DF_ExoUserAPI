package com.bnppf.df.upskilling.controller;

import com.bnppf.df.upskilling.model.User;
import com.bnppf.df.upskilling.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class UserController {

    private UserRepository userrepository;

    public UserController(UserRepository userrepository){
        this.userrepository = userrepository;
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userrepository.findAll());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Long userId) {
        Optional<User> user = userrepository.findById(userId);

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userrepository.save(user));
    }

    @PutMapping("/user")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        if (userrepository.existsById(user.getId())) {
            return ResponseEntity.ok(userrepository.save(user));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        if (userrepository.existsById(userId)) {
            userrepository.deleteById(userId);
            return ResponseEntity.ok().body(null);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
