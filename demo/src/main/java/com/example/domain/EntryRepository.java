package com.example.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EntryRepository extends CrudRepository<Entry, Long> {
    Entry findByHash(String hash);

    List<Entry> findByUserId(Long userId);

    Entry findById(Long id);
}
