package com.example.demo.service;

import com.example.demo.dto.ProtocolDto;
import com.example.demo.dto.ProtocolStateDto;
import com.example.demo.exceptions.EmptyFieldException;
import com.example.demo.exceptions.IdNotFoundException;
import com.example.demo.model.Protocol;
import com.example.demo.model.ProtocolState;
import com.example.demo.repository.ProtocolRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProtocolServiceImpl implements ProtocolService {

    private final static Logger LOGGER =
            LoggerFactory.getLogger(ProtocolServiceImpl.class);

    private final ProtocolRepository protocolRepository;

    public ProtocolServiceImpl(ProtocolRepository protocolRepository) {
        this.protocolRepository = protocolRepository;
    }

    @Override
    public ResponseEntity<Protocol> createProtocol(ProtocolDto protocol) {
        if (protocol.author() == null || protocol.state() == null) {
            EmptyFieldException exception = new EmptyFieldException("Some of the fields are empty"); // 409
            LOGGER.error("Error in creating protocol", exception);
            throw exception;
        }

        Protocol newProtocol = new Protocol(protocol.author(), ProtocolState.valueOf(protocol.state()));
        protocolRepository.save(newProtocol);

        LOGGER.info("New protocol created: {}", newProtocol);
        return new ResponseEntity<>(newProtocol, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Protocol> updateProtocol(ProtocolDto protocol, Long id) {
        Protocol toBeUpdatedProtocol = protocolRepository.findById(id)
                .orElseThrow(() -> {
                    IdNotFoundException exception = new IdNotFoundException("Id of the protocol doesn't exist"); // 404
                    LOGGER.error("Error in finding protocol with id {}", id, exception);
                    throw exception;
                });

        // Only whole protocol can be updated here
        if (protocol.author() == null || protocol.state() == null) {
            EmptyFieldException exception = new EmptyFieldException("Some of the fields are empty"); // 409
            LOGGER.error("Error in updating protocol", exception);
            throw exception;
        }

        toBeUpdatedProtocol.setAuthor(protocol.author());
        toBeUpdatedProtocol.setProtocolState(ProtocolState.valueOf(protocol.state()));

        protocolRepository.save(toBeUpdatedProtocol);

        LOGGER.info("Protocol has been updated: {}", toBeUpdatedProtocol);
        return new ResponseEntity<>(toBeUpdatedProtocol, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Protocol> updateProtocolState(Long id, ProtocolStateDto protocolStateDto) {
        Protocol protocol = protocolRepository.findById(id)
                .orElseThrow(() -> {
                    IdNotFoundException exception = new IdNotFoundException("Id of the protocol doesn't exist"); // 404
                    LOGGER.error("Error in finding protocol with id {}", id, exception);
                    throw exception;
                });

        if (protocolStateDto.state() == null) {
            EmptyFieldException exception = new EmptyFieldException("Some of the fields are empty"); // 409
            LOGGER.error("Error in updating protocol", exception);
            throw exception;
        }

        protocol.setProtocolState(ProtocolState.valueOf(protocolStateDto.state()));

        protocolRepository.save(protocol);

        LOGGER.info("Protocol has been updated: {}", protocol);
        return new ResponseEntity<>(protocol, HttpStatus.OK);
    }
}
