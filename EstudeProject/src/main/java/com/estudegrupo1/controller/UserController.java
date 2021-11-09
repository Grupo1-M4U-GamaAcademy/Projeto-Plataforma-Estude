package com.estudegrupo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudegrupo1.model.User;
import com.estudegrupo1.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	
	@GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getUserList());
    }

    @GetMapping("/user/{id_user}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return ResponseEntity.ok().body(this.userService.getUserById(id));
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(this.userService.createUser(user));
    }

    @PostMapping("/addUsers")
    public ResponseEntity<List<User>> addUsers(@RequestBody List<User> list) {
        return ResponseEntity.ok(this.userService.createUserList(list));
    }

    @PutMapping("/updateUsers/")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return ResponseEntity.ok().body(this.userService.updateUserById(user));
    }

    @DeleteMapping("/deleteUsers/{id}")
    public HttpStatus deleteUser(@PathVariable int id) {
        this.userService.deleteUserById(id);
        return HttpStatus.OK;
    }
}
	


