package com.example.demo.model;

public enum ProtocolState {
    NEW("new"),
    PREPARE_FOR_SHIPMENT("prepare"),
    CANCELLED("cancelled");


    ProtocolState(String name) {
    }
}
