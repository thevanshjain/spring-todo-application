package com.vansh.spring.demo.service;

import com.vansh.spring.demo.dao.NotesRepository;
import com.vansh.spring.demo.dto.Note;
import com.vansh.spring.demo.entity.NoteEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotesServiceImpl implements NotesService{

    private NotesRepository notesRepository;

    @Autowired
    public NotesServiceImpl(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    @Override
    public Note findById(int id) {
    Note note = new Note();
        Optional<NoteEntity> result=notesRepository.findById(id);

        NoteEntity noteEntity;
        if (result.isPresent()) {
            noteEntity=result.get();
        }
        else{
            throw new RuntimeException("Invalid Notes id -- "+id);
        }
        BeanUtils.copyProperties(noteEntity,note);
        note.setTaskId(noteEntity.getTheTask().getId());
        return note;
    }

    @Override
    public void deleteById(int id) {
        notesRepository.deleteById(id);
    }

}
