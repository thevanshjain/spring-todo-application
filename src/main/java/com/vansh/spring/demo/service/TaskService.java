package com.vansh.spring.demo.service;

import com.vansh.spring.demo.entity.Task;

import java.util.List;

public interface TaskService {

    public List<Task> findAll();

    public Task findById(int id);

    public void save(Task task);

    public void deleteById(int id);


}
