package com.yucel.library.service;

import java.util.List;

import com.yucel.library.model.Publisher;

public interface PublisherService {
	List<Publisher> getAllPublisher();
	void savePublisher(Publisher publisher);
	Publisher getPublisherById(long id);
	void deletePublisher(long id);
}
