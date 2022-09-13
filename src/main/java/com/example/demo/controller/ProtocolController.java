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
    public ResponseEntity<Protocol> createProtocol(@RequestBody ProtocolDto protocol) {
        return protocolService.createProtocol(protocol);
    }

    @PutMapping("/{protocolId}")
    public ResponseEntity<Protocol> updateProtocol(@RequestBody ProtocolDto protocol,
                                                   @PathVariable(name = "protocolId") Long protocolId) {
        return protocolService.updateProtocol(protocol, protocolId);
    }

    @PutMapping("/{protocolId}/state")
    public ResponseEntity<Protocol> updateProtocolState(@RequestBody ProtocolStateDto protocolStateDto,
                                                        @PathVariable(name = "protocolId") Long protocolId) {
        return protocolService.updateProtocolState(protocolId, protocolStateDto);
    }


}
