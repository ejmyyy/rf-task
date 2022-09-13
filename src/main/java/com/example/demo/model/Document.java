package com.example.demo.model;



import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String author;

    @Column(name = "created_at")
    private Date createdAt;

    @Enumerated(EnumType.STRING)
    private DocumentType type;

    @ManyToOne
    private Protocol protocol;

    public Document(String name, String author, DocumentType type, Protocol protocol) {
        this.name = name;
        this.author = author;
        this.type = type;
        this.protocol = protocol;
        this.createdAt = new Date();
    }
}
