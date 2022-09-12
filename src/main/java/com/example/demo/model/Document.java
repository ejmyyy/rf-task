package com.example.demo.model;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Document {

    @Id
    private Long id;

    private String name;

    private String author;

    private Date createdAt;

    private DocumentType type;

    @ManyToOne
    private Protocol protocol;


}
