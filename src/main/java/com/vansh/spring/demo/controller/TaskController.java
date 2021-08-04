package com.vansh.spring.demo.controller;

import com.vansh.spring.demo.entity.Notes;
import com.vansh.spring.demo.entity.Task;
import com.vansh.spring.demo.service.NotesService;
import com.vansh.spring.demo.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {

    private TaskService taskService;
    private NotesService noteService;

    public TaskController(TaskService taskService,NotesService noteService) {
        this.taskService = taskService;
        this.noteService=noteService;
    }

    @GetMapping("/list")
    public String listTasks(Model model){

        List<Task> taskList=taskService.findAll();

        model.addAttribute("tasks",taskList);
        return "list-task";
    }
     @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){

        Task task=new Task();
        model.addAttribute("task",task);
        return "form-task";

    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("task") Task task){
        taskService.save(task);

        return "redirect:/task/list";

    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id") int id,Model model){

        Task task=taskService.findById(id);
        model.addAttribute("task",task);
        return "form-task";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id){
        taskService.deleteById(id);
        return "redirect:/task/list";

    }

    @GetMapping("/showNotes")
    public String showNotes(@RequestParam("id") int id, Model model){

        Task task=taskService.findById(id);
        List<Notes> notesList=task.getNotes();
        model.addAttribute("taskName",task.getTitle());
        model.addAttribute("notes",notesList);
        model.addAttribute("taskId",id);
        return "list-notes";

    }



    @GetMapping("/showFormForNotes")
    public String showFormForNotes(@RequestParam("id") int id,Model model){
        Notes note=new Notes();
        model.addAttribute("taskId",id);
        model.addAttribute("note",note);
        return "form-note";
    }

    @PostMapping("/saveNote")
    public String saveEmployee(@ModelAttribute("note") Notes note){
        noteService.save(note);

        return "redirect:/task/list";

    }
    @GetMapping("/showFormForUpdateNote")
    public String showFormForUpdateNote(@RequestParam("id") int id,Model model){

        Notes note=noteService.findById(id);

        model.addAttribute("taskId",id);
        model.addAttribute("notes",note);

        return "form-note";

    }
    @GetMapping("/deleteNote")
    public String deleteNote(@RequestParam("id") int id){
        noteService.deleteById(id);
        return "redirect:/task/list";

    }
}
