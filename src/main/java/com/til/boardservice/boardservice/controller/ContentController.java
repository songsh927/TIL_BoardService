package com.til.boardservice.boardservice.controller;

import com.til.boardservice.boardservice.domain.Content;
import com.til.boardservice.boardservice.service.ContentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ContentController {

    private final ContentService contentService;

    public ContentController(ContentService contentService){
        this.contentService = contentService;
    }



    @GetMapping("/contents/new-form")
    public String createForm(){
        return "new-contentForm.html";
    }

    @PostMapping("/contents/create")
    public String create(ContentForm form){
        Content content = new Content(form.getTitle(),form.getText(),form.getWriter());
        contentService.createContent(content);
        return "redirect:/";
    }

    @GetMapping("/")
    public String boardList(Model model){
        List<Content> contents = contentService.findAllContents();
        model.addAttribute("contents", contents);
        return "home.html";
    }

}
