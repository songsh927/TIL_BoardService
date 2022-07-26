package com.til.boardservice.boardservice.service;

import com.til.boardservice.boardservice.domain.Content;
import com.til.boardservice.boardservice.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class ContentService {

    private final ContentRepository contentRepository;


    public ContentService(ContentRepository contentRepository){
        this.contentRepository = contentRepository;
    }

    public Long createContent(Content content){

        contentRepository.save(content);
        return content.getId();
    }

    public void removeContent(Long id){
        contentRepository.remove(id);
    }

    public List<Content> findAllContents(){
        return contentRepository.findAll();
    }

    public Optional<Content> findContentById(Long id){
        return contentRepository.findById(id);
    }

    public Optional<Content> findContentByTitle(String title){
        return contentRepository.findByTitle(title);
    }
}
