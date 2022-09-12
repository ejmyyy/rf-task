package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Protocol {

    @Id
    private Long id;

    private String author;

    private Date createdAt;

    private ProtocolState protocolState;

    @OneToMany
    private List<Document> documents;

    public Protocol(Long id, String author, Date createdAt, ProtocolState protocolState) {
        this.id = id;
        this.author = author;
        this.createdAt = createdAt;
        this.protocolState = protocolState;
    }
}
