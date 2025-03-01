package com.example.book_management.service;

import com.example.book_management.model.User;
import com.example.book_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllBooks(){
        return userRepository.findAll();
    }

    public User saveBooks(User user){
        return userRepository.save(user);
    }
    public String findBookStatusById(Long id) {
        User user = userRepository.findById(id).get();
        return user.getStatus();
    }
}
