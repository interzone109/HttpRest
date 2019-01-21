package com.http.rest.entity.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.http.rest.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, String> {

	Optional<Document> findById(String string);

}
