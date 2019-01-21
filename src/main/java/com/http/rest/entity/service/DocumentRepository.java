package com.http.rest.entity.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.http.rest.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

}
