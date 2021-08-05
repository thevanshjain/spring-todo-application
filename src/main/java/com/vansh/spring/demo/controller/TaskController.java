package com.vansh.spring.demo.controller;

import com.vansh.spring.demo.entity.Notes;
import com.vansh.spring.demo.entity.Task;
import com.vansh.spring.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;

    }

    @GetMapping("/list")
    public String listTasks(Model model){

        List<Task> taskList=taskService.findAll();

        model.addAttribute("tasks",taskList);
        return "tasks/list-task";
    }
     @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){

        Task task=new Task();
        model.addAttribute("task",task);
        return "tasks/form-task";

    }

    @PostMapping("/save")
    public String saveTask(@ModelAttribute("task") Task task){
        taskService.save(task);

        return "redirect:/task/list";

    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id") int id,Model model){

        Task task=taskService.findById(id);
        model.addAttribute("task",task);
        return "tasks/form-task";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id){
        taskService.deleteById(id);
        return "redirect:/task/list";

    }

    @GetMapping("/showNotes")
    public String showNotes(@RequestParam("id") int taskId, Model model){

        Task task=taskService.findById(taskId);
        List<Notes> notesList=task.getNotes();
        model.addAttribute("taskName",task.getTitle());
        model.addAttribute("notes",notesList);
        model.addAttribute("taskId",taskId);
        return "notes/list-notes";

    }
}
