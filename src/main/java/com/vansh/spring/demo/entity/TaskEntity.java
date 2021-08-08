package com.vansh.spring.demo.entity;
import javax.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "task")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty(message = "Task's title cannot be empty")
    @Column(name = "title")
    private String title;

    @NotEmpty(message = "Task's status cannot be empty")
    @Column(name = "status")
    private String status;

    @NotNull(message = "Task's start date cannot be empty")
    @Column(name = "startdate")
    private Date startDate;

    @NotNull(message = "Task's end date cannot be empty")
    @Column(name = "enddate")
    private Date endDate;

    public TaskEntity(String title, String status) {
        this.title = title;
        this.status = status;
    }

    @OneToMany(mappedBy = "theTask",cascade = CascadeType.ALL)
    private List<NoteEntity> notes;


    public void addNotes(NoteEntity note){
        if(notes==null)
            notes=new ArrayList<>();

        Iterator<NoteEntity> itr = notes.iterator();
        while (itr.hasNext()){
            NoteEntity currentNote = itr.next();
            if(currentNote.getId()==note.getId()){
                itr.remove();
                break;
            }
        }
        notes.add(note);
        note.setTheTask(this);
    }

}
