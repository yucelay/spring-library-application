package com.yucel.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yucel.library.model.Author;
import com.yucel.library.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public List<Author> getAllAuthors() {
		return authorRepository.findAll();
	}

	@Override
	public void saveAuthor(Author author) {
		this.authorRepository.save(author);
	}

	@Override
	public Author getAuthorById(long id) {
		Optional<Author> optional = authorRepository.findById(id);
		Author author = null;
		if(optional.isPresent()) {
			author=optional.get();
		}else {
			throw new RuntimeException("Yazar bulunamadı");
		}
		return author;
	}

	@Override
	public void deleteAuthor(long id) {
		this.authorRepository.deleteById(id);
		
	}

}
