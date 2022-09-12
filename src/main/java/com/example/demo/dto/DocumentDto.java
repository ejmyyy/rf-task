package com.example.demo.dto;

import java.util.Date;

public record DocumentDto(String name, String author, String documentType, Date createdAt, String protocolState) {
}
