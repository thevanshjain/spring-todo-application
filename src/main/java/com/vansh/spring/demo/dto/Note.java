package com.vansh.spring.demo.dto;

import lombok.*;

import java.sql.Date;

@Data
public class Note {

    private int id;
    private String description;
    private Date createdAt;
    private Date modifiedAt;
    private int taskId;
}