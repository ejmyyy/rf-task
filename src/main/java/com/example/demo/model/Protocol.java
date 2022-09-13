package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "protocols")
public class Protocol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private ProtocolState protocolState;

    @JsonIgnore
    @OneToMany(mappedBy = "protocol")
    private List<Document> documents;

    public Protocol(String author, ProtocolState protocolState) {
        this.author = author;
        this.createdAt = new Date();
        this.protocolState = protocolState;
    }
}
