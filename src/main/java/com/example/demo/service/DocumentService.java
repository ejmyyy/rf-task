package com.example.demo.service;

import com.example.demo.dto.DocumentDto;
import com.example.demo.model.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface DocumentService {

    ResponseEntity<Object> createDocument(Document document);

    ResponseEntity<Object> updateDocument(DocumentDto documentDto, Long id);

    ResponseEntity<Object> deleteDocument(Long id);


}
