package com.vansh.spring.demo.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

@Data
public class Task {

    private int id;

    @NotEmpty(message = "Task's title cannot be empty")
    private String title;

    @NotEmpty(message = "Task's status cannot be empty")
    private String status;

    @NotNull(message = "Task's start date cannot be empty")
    private Date startDate;

    @NotNull(message = "Task's end date cannot be empty")
    private Date endDate;

    private List<Note> taskNotes;
}
