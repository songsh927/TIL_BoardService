package com.til.boardservice.boardservice.repository;

import com.til.boardservice.boardservice.domain.Content;

import java.util.*;

public class MemoryContentRepository implements ContentRepository {

    private static Map<Long, Content> store = new HashMap<>();

    private static long sequence = 0L;

    @Override
    public Content save(Content content) {

        Date today = new Date();
        content.setId(++sequence);
        content.setDate(today);
        store.put(content.getId(), content);
        return content;
    }

    @Override
    public void remove(Long id) {
        store.remove(id);
    }

    @Override
    public Optional<Content> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Content> findByTitle(String title) {
        return store.values().stream()
                .filter(content -> content.getTitle().equals(title)).findAny();
    }

    @Override
    public List<Content> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
