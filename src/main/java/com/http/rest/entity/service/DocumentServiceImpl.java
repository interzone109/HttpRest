package com.http.rest.entity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.http.rest.entity.Document;

@Service
public class DocumentServiceImpl implements DocumentService {

	private DocumentRepository documentRepository;

	@Autowired
	public DocumentServiceImpl(DocumentRepository documentRepository) {
		this.documentRepository = documentRepository;
	}

	public Document saveDocument(Document document) {

		return documentRepository.save(document);
	}

	public Optional<Document> findById(String string) {
		// TODO Auto-generated method stub
		return documentRepository.findById( string);
	}

}
