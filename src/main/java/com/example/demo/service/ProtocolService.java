package com.example.demo.service;

import com.example.demo.dto.ProtocolDto;
import com.example.demo.dto.ProtocolStateDto;
import com.example.demo.model.Protocol;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ProtocolService {

    ResponseEntity<Object> createProtocol(Protocol protocol);

    ResponseEntity<Object> updateProtocol(ProtocolDto protocol, Long id);

    ResponseEntity<Object> updateProtocolState(Long id, ProtocolStateDto protocolStateDto);
}
