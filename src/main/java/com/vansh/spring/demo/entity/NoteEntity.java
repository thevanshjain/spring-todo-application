package com.vansh.spring.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.sql.Date;


//@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "notes")
public class NoteEntity {

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

    @ManyToOne
    @JoinColumn(name = "task_id")
    private TaskEntity theTask;


    public NoteEntity(String description, Date createdAt, Date modifiedAt) {
        this.description = description;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }
}
