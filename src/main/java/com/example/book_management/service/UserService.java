package com.example.book_management.service;

import com.example.book_management.model.User;
import com.example.book_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Cacheable(value = "books")
    public List<User> getAllBooks(){
        System.out.println("fetching data from database");
        return userRepository.findAll();
    }
    @CacheEvict(value = "books",allEntries = true)
    public User saveBooks(User user){

        return userRepository.save(user);
    }
    @Cacheable(value = "book_status", key="#id")
    public String findBookStatusById(Long id) {
        User user = userRepository.findById(id).get();
        return user.getStatus();
    }
}
