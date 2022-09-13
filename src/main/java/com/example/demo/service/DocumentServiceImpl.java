package com.example.demo.service;

import com.example.demo.dto.DocumentDto;
import com.example.demo.exceptions.EmptyFieldException;
import com.example.demo.exceptions.IdNotFoundException;
import com.example.demo.model.Document;
import com.example.demo.model.DocumentType;
import com.example.demo.model.Protocol;
import com.example.demo.repository.DocumentRepository;
import com.example.demo.repository.ProtocolRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class DocumentServiceImpl implements DocumentService {

    private final static Logger LOGGER =
            LoggerFactory.getLogger(DocumentServiceImpl.class);

    private final DocumentRepository documentRepository;
    private final ProtocolRepository protocolRepository;

    public DocumentServiceImpl(DocumentRepository documentRepository, ProtocolRepository protocolRepository) {
        this.documentRepository = documentRepository;
        this.protocolRepository = protocolRepository;
    }

    @Override
    public ResponseEntity<Document> createDocument(DocumentDto document) {
        if (document.name() == null || document.author() == null
                || document.documentType() == null || document.protocolId() == null) {
            EmptyFieldException exception = new EmptyFieldException("Some of the fields are empty"); // 409
            LOGGER.error("Error in creating document", exception);
            throw exception;
        }

        Protocol protocol = protocolRepository.findById(document.protocolId())
                .orElseThrow(() -> {
                    IdNotFoundException exception = new IdNotFoundException("Id of the protocol doesn't exist"); // 404
                    LOGGER.error("Error in finding protocol with id {}", document.protocolId(), exception);
                    throw exception;
                });

        Document newDocument = new Document(document.name(),
                document.author(),
                DocumentType.valueOf(document.documentType()),
                protocol);
        documentRepository.save(newDocument);
        LOGGER.info("New document created: {}", newDocument);
        return new ResponseEntity<>(newDocument, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Document> updateDocument(DocumentDto document, Long id) {
        Document toBeUpdatedDocument = documentRepository.findById(id)
                .orElseThrow(() -> {
                    IdNotFoundException exception = new IdNotFoundException("Id of the document doesn't exist"); // 404
                    LOGGER.error("Error in document  with id {}", id, exception);
                    throw exception;
                });

        if (document.author() != null) toBeUpdatedDocument.setAuthor(document.author());
        if (document.name() != null) toBeUpdatedDocument.setName(document.name());
        if (document.protocolId() != null) {
            Protocol protocol = protocolRepository.findById(document.protocolId())
                    .orElseThrow(() -> {
                        IdNotFoundException exception = new IdNotFoundException("Id of the protocol doesn't exist"); // 404
                        LOGGER.error("Error in finding protocol with id {}", document.protocolId(), exception);
                        throw exception;
                    });
            toBeUpdatedDocument.setProtocol(protocol);
        }
        if (document.documentType() != null) toBeUpdatedDocument
                .setType(DocumentType.valueOf(document.documentType()));

        documentRepository.save(toBeUpdatedDocument);

        LOGGER.info("Document has been updated: {}", toBeUpdatedDocument);
        return new ResponseEntity<>(toBeUpdatedDocument, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> deleteDocument(Long id) {
        documentRepository.findById(id)
                .orElseThrow(() -> {
                    IdNotFoundException exception = new IdNotFoundException("Id of the document doesn't exist"); // 404
                    LOGGER.error("Error in finding document with id {}", id, exception);
                    throw exception;
                });

        documentRepository.deleteById(id);
        LOGGER.info("Document deleted with id {}", id);
        return new ResponseEntity<>("Document with id: " + id + " successfully deleted", HttpStatus.OK);
    }
}
