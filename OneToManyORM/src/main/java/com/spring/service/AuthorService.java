package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Author;
import com.spring.repository.AuthorRepository;

@Service
public class AuthorService implements AuthorDAO {

	@Autowired
	private AuthorRepository authorRepository;

	public Author saveAuthor(Author author) {
		return authorRepository.save(author);
	}

	public Optional<Author> findAuthorById(Long i) {
		return authorRepository.findById(i);
	}

	@Override
	public List<Author> getAllAuthors() {
		// TODO Auto-generated method stub
		return authorRepository.findAll();
	}

}