package com.example.demo.service;

import com.example.demo.dto.DocumentDto;
import com.example.demo.model.Document;
import org.springframework.http.ResponseEntity;

public interface DocumentService {

    ResponseEntity<Document> createDocument(DocumentDto document);

    ResponseEntity<Document> updateDocument(DocumentDto documentDto, Long id);

    ResponseEntity<Object> deleteDocument(Long id);


}
