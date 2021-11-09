package com.estudegrupo1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudegrupo1.model.User;
import com.estudegrupo1.repository.UserRepository;

@Service
public class UserService {

	@Autowired
    private UserRepository userRepository;
	

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> createUserList(List<User> list) {
        return userRepository.saveAll(list);
    }

    public List<User> getUserList() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUserById(User user) {
        Optional<User> userFound = userRepository.findById(user.getIdUser());

        if (userFound.isPresent()) {
            User userUpdate = userFound.get();
            userUpdate.setUserName(user.getUserName());
            userUpdate.setUserName(user.getUserName());
           
            return userRepository.save(user);
        
        } else {
            return null;
        }
    }

    public String deleteUserById(int id) {
        userRepository.deleteById(id);
        return "User "+ id +" deleted";
    }
}


