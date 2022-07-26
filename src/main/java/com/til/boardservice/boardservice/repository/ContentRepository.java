package com.til.boardservice.boardservice.repository;

import com.til.boardservice.boardservice.domain.Content;

import java.util.List;
import java.util.Optional;

public interface ContentRepository {
    Content save(Content content);

    void remove(Long id);

    Optional<Content> findById(Long id);

    Optional<Content> findByTitle(String title);

    List<Content> findAll();
}
