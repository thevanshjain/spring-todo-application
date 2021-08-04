package com.vansh.spring.demo.controller;

import com.vansh.spring.demo.entity.Notes;
import com.vansh.spring.demo.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/note")
public class NoteController {

    private NotesService noteService;

    @Autowired
    public NoteController(NotesService noteService) {
        this.noteService = noteService;

    }


    @GetMapping("/showFormForNotes")
    public String showFormForNotes(@RequestParam("taskId") int taskId, Model model){
        Notes note=new Notes();
        model.addAttribute("note",note);
        model.addAttribute("taskId",taskId);
        return "notes/form-note";
    }

    @PostMapping("/saveNote")
    public String saveEmployee(@ModelAttribute("note") Notes note){

        noteService.save(note);

        return "redirect:/task/list";

    }
//<a th:href="@{/note/showFormForUpdateNote(id=${currentNote.id})}"
//    class="btn btn-info btn-sm">
//    Update
//            </a>
    @GetMapping("/showFormForUpdateNote")
    public String showFormForUpdateNote(@RequestParam("id") int id,Model model){

        Notes note=noteService.findById(id);

        model.addAttribute("taskId",id);
        model.addAttribute("notes",note);

        return "notes/form-note";

    }

    @GetMapping("/deleteNote/{id}/{taskId}")
    public String deleteNote(@PathVariable int id,@PathVariable int taskId){

        noteService.deleteById(id);
        return "redirect:/task/showNotes?id="+ taskId;
    }

}
