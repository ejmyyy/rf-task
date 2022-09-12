package com.example.demo.service;

import com.example.demo.dto.ProtocolDto;
import com.example.demo.dto.ProtocolStateDto;
import com.example.demo.model.Protocol;
import com.example.demo.model.ProtocolState;
import com.example.demo.repository.ProtocolRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class ProtocolServiceImpl implements ProtocolService {

    private final ProtocolRepository protocolRepository;

    public ProtocolServiceImpl(ProtocolRepository protocolRepository) {
        this.protocolRepository = protocolRepository;
    }

    @Override
    public ResponseEntity<Object> createProtocol(Protocol protocol) {
        protocolRepository.save(protocol);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> updateProtocol(ProtocolDto protocol, Long id) {
        Protocol toBeUpdatedProtocol = protocolRepository.findById(id).get();
        toBeUpdatedProtocol.setAuthor(protocol.author());
        toBeUpdatedProtocol.setCreatedAt(protocol.createdAt());
        toBeUpdatedProtocol.setProtocolState(protocol.state()));
        protocolRepository.save(toBeUpdatedProtocol);
        return new ResponseEntity<>(protocol, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> updateProtocolState(Long id, ProtocolStateDto protocolStateDto) {
        Protocol protocol = protocolRepository.findById(id).get();
        protocol.setProtocolState(ProtocolState.valueOf(protocolStateDto.state()));
        protocolRepository.save(protocol);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
