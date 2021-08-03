package com.vansh.spring.demo.controller;

import com.vansh.spring.demo.entity.Notes;
import com.vansh.spring.demo.entity.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {

    private List<Task> taskList;

    @PostConstruct
    public void loadTasks(){

        Task task1=new Task("Java","On Going", Date.valueOf("2021-08-01"));
        task1.addNotes(new Notes("conditional and iteration statements"));
        task1.addNotes(new Notes("arrays and string"));

        Task task2=new Task("Collections", "Not Started", Date.valueOf("2021-08-15"));
        task2.addNotes(new Notes("list"));
        task2.addNotes(new Notes("set"));
        task2.addNotes(new Notes("map"));

        Task task3=new Task("OOPS","Not Started",Date.valueOf("2021-08-25"));
        task3.addNotes(new Notes("Inheritance"));
        task3.addNotes(new Notes("Abstraction"));
        task3.addNotes(new Notes("Encapsulation"));
        task3.addNotes(new Notes("Polymorphism"));


        taskList=new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);

    }

    @GetMapping("/list")
    public String listTasks(Model model){

        model.addAttribute("tasks",taskList);
        return "list-task";
    }

}
