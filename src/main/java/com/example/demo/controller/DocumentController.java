package com.example.demo.controller;

import com.example.demo.dto.DocumentDto;
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
    public ResponseEntity<Document> createDocument(@RequestBody DocumentDto document) {
        return documentService.createDocument(document);
    }

    @PutMapping("/{documentId}")
    public ResponseEntity<Document> updateDocument(@RequestBody DocumentDto document,
                                                   @PathVariable(name = "documentId") Long documentId) {
        return documentService.updateDocument(document, documentId);
    }

    @DeleteMapping("/{documentId}")
    public ResponseEntity<Object> deleteDocument(@PathVariable(name = "documentId") Long documentId) {
        return documentService.deleteDocument(documentId);
    }


}
