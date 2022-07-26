package com.til.boardservice.boardservice.service;

import com.til.boardservice.boardservice.repository.ContentRepository;
import com.til.boardservice.boardservice.repository.MemoryContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

//    private final ContentRepository contentRepository;
//
//    public SpringConfig(ContentRepository contentRepository){
//        this.contentRepository = contentRepository;
//    }


    @Bean
    public ContentService contentService(){
        return new ContentService(contentRepository());
    }

    @Bean
    public ContentRepository contentRepository(){
        return new MemoryContentRepository();
    }
}
