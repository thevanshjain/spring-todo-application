package com.vansh.spring.demo.controller;

import com.vansh.spring.demo.entity.Notes;
import com.vansh.spring.demo.entity.Task;
import com.vansh.spring.demo.service.NotesService;
import com.vansh.spring.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Component
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NotesService noteService;
    @Autowired
    private TaskService taskService;

    @GetMapping("/showFormForNotes")
    public String showFormForNotes(@RequestParam("taskId") int taskId, Model model){

        System.out.println(taskService);
        System.out.println(noteService);
        Notes note=new Notes();
        model.addAttribute("notes",note);
        model.addAttribute("taskId",taskId);
        System.out.println("In show");
        return "notes/form-note";
    }

    @PostMapping("/saveNote")
    public String saveNote(@RequestParam int taskId,@ModelAttribute("note") Notes note){
        Task task= taskService.findById(taskId);
        task.addNotes(note);
       // note.setTheTask(task);

        taskService.save(task);
       // noteService.save(note);
        return "redirect:/task/showNotes?id="+ taskId;

    }
    @GetMapping("/updateNote")
    public String showFormForUpdateNote(@RequestParam(name = "id") int id,Model model){

        Notes note=noteService.findById(id);
        model.addAttribute("taskId",note.getTheTask().getId());
        model.addAttribute("notes",note);

        return "notes/form-note";

    }




    @GetMapping("/deleteNote/{id}/{taskId}")
    public String deleteNote(@PathVariable int id,@PathVariable int taskId){

        noteService.deleteById(id);
        return "redirect:/task/showNotes?id="+ taskId;
    }

}
