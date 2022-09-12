package com.example.demo.controller;


import com.example.demo.dto.ProtocolDto;
import com.example.demo.dto.ProtocolStateDto;
import com.example.demo.model.Protocol;
import com.example.demo.service.ProtocolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/protocols")
public class ProtocolController {

    private final ProtocolService protocolService;

    public ProtocolController(ProtocolService protocolService) {
        this.protocolService = protocolService;
    }

    @PostMapping
    public ResponseEntity<Object> createProtocol(@RequestBody Protocol protocol) {
        return protocolService.createProtocol(protocol);
    }

    @PutMapping("/{protocolId}")
    public ResponseEntity<Object> updateProtocol(@RequestBody ProtocolDto protocol, @PathVariable Long protocolId) {
        return protocolService.updateProtocol(protocol, protocolId);
    }

    @PutMapping("/{protocolId}")
    public ResponseEntity<Object> updateProtocolState(@RequestBody ProtocolStateDto protocolStateDto, @PathVariable Long protocolId) {
        return protocolService.updateProtocolState(protocolId, protocolStateDto);
    }


}
