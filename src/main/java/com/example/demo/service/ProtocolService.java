package com.example.demo.service;

import com.example.demo.dto.ProtocolDto;
import com.example.demo.dto.ProtocolStateDto;
import com.example.demo.model.Protocol;
import org.springframework.http.ResponseEntity;

public interface ProtocolService {

    ResponseEntity<Protocol> createProtocol(ProtocolDto protocol);

    ResponseEntity<Protocol> updateProtocol(ProtocolDto protocol, Long id);

    ResponseEntity<Protocol> updateProtocolState(Long id, ProtocolStateDto protocolStateDto);
}
