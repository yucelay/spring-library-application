package com.yucel.library.service;

import java.util.List;

import com.yucel.library.model.Author;

public interface AuthorService {
	List<Author> getAllAuthors();
	void saveAuthor(Author author);
	Author getAuthorById(long id);
	void deleteAuthor(long id);
}
