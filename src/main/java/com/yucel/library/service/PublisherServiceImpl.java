package com.yucel.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yucel.library.model.Publisher;
import com.yucel.library.repository.PublisherRepository;

@Service
public class PublisherServiceImpl implements PublisherService {

	@Autowired
	private PublisherRepository publisherRepository;
	
	@Override
	public List<Publisher> getAllPublisher() {
		return publisherRepository.findAll();
	}

	@Override
	public void savePublisher(Publisher publisher) {
		publisherRepository.save(publisher);
	}

	@Override
	public Publisher getPublisherById(long id) {
		Optional<Publisher> optional = publisherRepository.findById(id);
		Publisher publisher = null;
		if(optional.isPresent()) {
			publisher=optional.get();
		}else {
			throw new RuntimeException("Yayın Evi bulunamadı");
		}
		return publisher;
	}

	@Override
	public void deletePublisher(long id) {
		publisherRepository.deleteById(id);		
	}

}
