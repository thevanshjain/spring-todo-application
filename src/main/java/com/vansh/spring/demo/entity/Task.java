package com.vansh.spring.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "status")
    private String status;

    @Column(name = "date")
    private Date date;

    public Task(String title, String status, Date date) {
        this.title = title;
        this.status = status;
        this.date = date;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    private List<Notes> notes;

    public void addNotes(Notes note){
        if(notes==null)
            notes=new ArrayList<>();
        notes.add(note);

    }

}
