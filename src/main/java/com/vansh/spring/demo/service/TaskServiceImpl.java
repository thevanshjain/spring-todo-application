package com.vansh.spring.demo.service;

import com.vansh.spring.demo.dao.TaskRepository;
import com.vansh.spring.demo.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;
    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
        public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(int id) {
        Optional<Task> result=taskRepository.findById(id);

        Task task=null;
        if (result.isPresent()) {
            task=result.get();
        }
        else{
            throw new RuntimeException("Invalid tasks id -- "+id);
        }

        return task;
    }

    @Override
    public void save(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void deleteById(int id) {
        taskRepository.deleteById(id);
    }
}
