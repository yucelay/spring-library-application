package com.yucel.library.service;

import java.util.List;

import com.yucel.library.model.Author;
import com.yucel.library.model.Book;
import com.yucel.library.model.Publisher;

public interface BookService {
	List<Book> getAllBooks();
	void saveBook(Book book);
	Book getBookById(long id);
	void deleteBook(long id);
	List<Book> getSearchBooks(String searchWord);
	List<Author> getAllAuthorForBooks();
	List<Publisher> getAllPublisherForBooks();
	List<Book> getAllOrderedBooks();
	List<Book> getAllOrderedBooksWithLimit();

}
