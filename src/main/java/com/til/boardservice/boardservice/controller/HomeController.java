package com.til.boardservice.boardservice.controller;

import com.til.boardservice.boardservice.domain.Content;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping
    public String home(){
        return "redirect:/contents";
    }
}
