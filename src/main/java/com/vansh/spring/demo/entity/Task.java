package com.vansh.spring.demo.entity;

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
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "status")
    private String status;

    @Column(name = "startdate")
    private Date startDate;

    @Column(name = "enddate")
    private Date endDate;

    public Task(String title, String status) {
        this.title = title;
        this.status = status;
        this.startDate = null;
        this.endDate = null;
    }

    @OneToMany(mappedBy = "theTask",cascade = CascadeType.ALL)
    private List<Notes> notes;


    public void addNotes(Notes note){
        if(notes==null)
            notes=new ArrayList<>();

        Iterator<Notes> itr = notes.iterator();
        while (itr.hasNext()){
            Notes currentNote = itr.next();
            if(currentNote.getId()==note.getId()){
                itr.remove();
                break;
            }
        }
        notes.add(note);
        note.setTheTask(this);
    }


    public void setStartDate(String startDateString) {
        this.startDate = Date.valueOf(startDateString);
    }

    public void setEndDate(String endDateString) {
        this.endDate = Date.valueOf(endDateString);
    }


    public String getStartDate() {
        if(startDate==null)
            return "";

        return startDate.toString();
    }

    public String getEndDate() {

        if(endDate==null)
            return "";
        return endDate.toString();
    }
}
