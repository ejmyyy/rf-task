package com.example.demo.service;

import com.example.demo.dto.DocumentDto;
import com.example.demo.model.Document;
import com.example.demo.model.DocumentType;
import com.example.demo.model.Protocol;
import com.example.demo.model.ProtocolState;
import com.example.demo.repository.DocumentRepository;
import com.example.demo.repository.ProtocolRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;
    private final ProtocolRepository protocolRepository;

    public DocumentServiceImpl(DocumentRepository documentRepository, ProtocolRepository protocolRepository) {
        this.documentRepository = documentRepository;
        this.protocolRepository = protocolRepository;
    }

    @Override
    public ResponseEntity<Object> createDocument(Document document) {
        documentRepository.save(document);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> updateDocument(DocumentDto document, Long id) {
        Document toBeUpdatedDocument = documentRepository.findById(id).get();
        toBeUpdatedDocument.setAuthor(document.author());
        toBeUpdatedDocument.setName(document.name());
        Protocol protocol = protocolRepository.findByProtocolState(ProtocolState.valueOf(document.protocolState()));
        toBeUpdatedDocument.setProtocol(protocol);
        toBeUpdatedDocument.setCreatedAt(document.createdAt());
        toBeUpdatedDocument.setType(DocumentType.valueOf(document.documentType()));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> deleteDocument(Long id) {
        documentRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
