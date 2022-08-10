package com.til.boardservice.boardservice.controller;

import com.til.boardservice.boardservice.domain.Content;
import com.til.boardservice.boardservice.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/contents")
@RequiredArgsConstructor
public class ContentController {

    private final ContentService contentService;

//    public ContentController(ContentService contentService){
//        this.contentService = contentService;
//    }



    @GetMapping("/new-form")
    public String createForm(){
        return "new-contentForm.html";
    }

    @PostMapping("/create")
    public String create(ContentForm form){
        Content content = new Content(form.getTitle(),form.getText(),form.getWriter());
        contentService.createContent(content);
        return "redirect:/";
    }

    @GetMapping
    public String boardList(Model model){
        List<Content> contents = contentService.findAllContents();
        model.addAttribute("contents", contents);
        return "home.html";
    }

    @GetMapping("/view")
    public String contentForm(Model model,String id) throws Exception{

        Optional<Content> result = contentService.findContentById(Long.parseLong(id));
        System.out.println(result.getClass().getSimpleName());
        model.addAttribute("content", result.get());

        return "content.html";
    }

}
