package com.yucel.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yucel.library.model.Author;
import com.yucel.library.model.Book;
import com.yucel.library.model.Publisher;
import com.yucel.library.repository.AuthorRepository;
import com.yucel.library.repository.BookRepository;
import com.yucel.library.repository.PublisherRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private PublisherRepository publisherRepository;

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();

	}

	@Override
	public void saveBook(Book book) {
		bookRepository.save(book);

	}

	@Override
	public Book getBookById(long id) {
		Optional<Book> optional = bookRepository.findById(id);
		Book book = null;
		if (optional.isPresent()) {
			book = optional.get();
		} else {
			throw new RuntimeException("kitap bulunamadi");
		}
		return book;
	}

	@Override
	public void deleteBook(long id) {
		bookRepository.deleteById(id);

	}

	@Override
	public List<Book> getSearchBooks(String searchWord) {
		List<Book> foundedBooks = bookRepository.findBooksByKeyword(searchWord);
		return foundedBooks;

	}

	@Override
	public List<Author> getAllAuthorForBooks() {
		return authorRepository.findAll();
	}

	@Override
	public List<Publisher> getAllPublisherForBooks() {
		return publisherRepository.findAll();
	}

	@Override
	public List<Book> getAllOrderedBooks() {
		return bookRepository.getOrderedBooks();
	}

	@Override
	public List<Book> getAllOrderedBooksWithLimit() {
		return bookRepository.getOrderedBooksWithLimit();
	}

}
