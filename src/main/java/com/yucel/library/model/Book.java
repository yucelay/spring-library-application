package com.yucel.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="book_name")
	private String bookName;
	
	@Column(name="book_subname")
	private String bookSubname;
	
	@Column(name="book_serial")
	private String bookSerial;
	
	@Column(name="book_author")
	private String bookAuthor;
	
	@Column(name="book_publisher_name")
	private String bookPublisherName;
	
	@Column(name="book_isbn")
	private String bookIsbn;
	
	@Column(name="book_explanation")
	private String bookExplanation;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookSubname() {
		return bookSubname;
	}
	public void setBookSubname(String bookSubname) {
		this.bookSubname = bookSubname;
	}
	public String getBookSerial() {
		return bookSerial;
	}
	public void setBookSerial(String bookSerial) {
		this.bookSerial = bookSerial;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookPublisherName() {
		return bookPublisherName;
	}
	public void setBookPublisherName(String bookPublisherName) {
		this.bookPublisherName = bookPublisherName;
	}
	public String getBookIsbn() {
		return bookIsbn;
	}
	public void setBookIsbn(String bookIsbn) {
		this.bookIsbn = bookIsbn;
	}
	public String getBookExplanation() {
		return bookExplanation;
	}
	public void setBookExplanation(String bookExplanation) {
		this.bookExplanation = bookExplanation;
	}
	
	
	
}
