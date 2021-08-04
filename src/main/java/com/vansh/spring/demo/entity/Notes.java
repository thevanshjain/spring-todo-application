package com.vansh.spring.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.sql.Date;


@Data
@NoArgsConstructor
@Entity
@Table(name = "notes")
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "createdat")
    private Date createdAt;

    @Column(name = "modifiedat")
    private Date modifiedAt;



    public Notes(String description, Date createdAt, Date modifiedAt) {
        this.description = description;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
