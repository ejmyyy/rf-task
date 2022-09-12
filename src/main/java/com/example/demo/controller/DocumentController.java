package com.example.demo.controller;

import com.example.demo.model.Document;
import com.example.demo.service.DocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/documents")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }


    @PostMapping
    public ResponseEntity<Object> createDocument(@RequestBody Document document) {
        return documentService.createDocument(document);
    }

    @PutMapping ("/{documentId}")
    public ResponseEntity<Object> updateDocument(@RequestBody Document document, @PathVariable Long documentId) {
        return documentService.updateDocument(document, documentId);
    }

    @DeleteMapping("/{documentId}")
    public ResponseEntity<Object> deleteDocument(@PathVariable Long documentId) {
        return documentService.deleteDocument(documentId);
    }



}
