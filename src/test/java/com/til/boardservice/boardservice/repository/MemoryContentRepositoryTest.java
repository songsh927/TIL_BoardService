package com.til.boardservice.boardservice.repository;

import com.til.boardservice.boardservice.domain.Content;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryContentRepositoryTest {

    MemoryContentRepository repository = new MemoryContentRepository();

    @AfterEach
    void afterEach(){
        repository.clearStore();
    }

    @Test
    void save() {
        //given
        Content content = new Content();
        content.setTitle("mdsz");
        content.setText("sun and moon and stars can you see me  \n I don't care lost in the space \n in to the space!");
        //when
        repository.save(content);
        Content result = repository.findById(content.getId()).get();
        //then
        Assertions.assertThat(content).isEqualTo(result);
    }

    @Test
    void remove() {

        Content content1 = new Content();
        content1.setTitle("mdsz");
        content1.setText("sun and moon and stars can you see me  \n I don't care lost in the space \n in to the space!");

        Content content2 = new Content();
        content2.setTitle("mdsz2");
        content2.setText("sun and moon and stars can you see me  \n I don't care lost in the space \n in to the space!");

        repository.save(content1);
        repository.save(content2);
        repository.remove(content1.getId());

        List<Content> result = repository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(1);

    }

    @Test
    void findById() {
    }

    @Test
    void findByTitle() {

        Content content1 = new Content();
        content1.setTitle("mdsz asdf");
        content1.setText("sun and moon and starts can you see me  \n I don't care lost in the space \n in to the space!");

        Content content2 = new Content();
        content2.setTitle("mdsz2");
        content2.setText("sun and moon and starts can you see me  \n I don't care lost in the space \n in to the space!");

        repository.save(content1);
        repository.save(content2);

        Content result = repository.findByTitle("mdsz asdf").get();

        Assertions.assertThat(content1).isEqualTo(result);

    }

    @Test
    void findAll() {
    }
}