package com.spring.service;

import java.util.List;
import java.util.Optional;

import com.spring.model.Author;

public interface AuthorDAO {

	public Author saveAuthor(Author author);

	public Optional<Author> findAuthorById(Long id);

	public List<Author> getAllAuthors();
}