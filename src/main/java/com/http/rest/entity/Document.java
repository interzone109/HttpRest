package com.http.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "documents")
@Data
public class Document {
	@Id
	@Column(name = "id", nullable = false, unique = true)
	private String id;
	
	@Column(name = "hash")
	private String hash; 
	
	@Column(name = "language")
	private String language;
	
	@Column(name = "format")
	private String format;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "document_of")
	private String documentOf;
	
	@Column(name = "date_published")
	private String datePublished;

	@Column(name = "document_type")
	private String documentType;
	
	@Column(name = "date_modified")
	private String dateModified;
	
	@Column(name = "related_item")
	private String relatedItem;
	
	@Column(name = "description")
	private String description;
	
}
