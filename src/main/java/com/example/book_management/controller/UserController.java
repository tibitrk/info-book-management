package com.example.book_management.controller;

import com.example.book_management.model.User;
import com.example.book_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/books")
    public String getAll(Model model){
    model.addAttribute("users", userService.getAllBooks());
        return "home";
    }
    @PostMapping("/save")
    public String savePlayers(@RequestParam("name") String name,
                            @RequestParam("author") String author,
                              RedirectAttributes redirectAttributes){

        User user = new User();
        user.setName(name);
        user.setAuthor(author);
        userService.saveBooks(user);
        redirectAttributes.addFlashAttribute("success", "new book added successfully");
        return "redirect:/books";
    }
    @PostMapping("/book-buy/{id}")
    public String findByid(@PathVariable("id") Long id,RedirectAttributes redirectAttributes){
        String status = userService.findBookStatusById(id);

        if(status != null && status.equals("1")){
            redirectAttributes.addFlashAttribute("resultMessage", "Book is already sold.");
        }else {
            redirectAttributes.addFlashAttribute("resultMessage", "Book sold successfully.");
        }
        return "redirect:/books";
    }
}
