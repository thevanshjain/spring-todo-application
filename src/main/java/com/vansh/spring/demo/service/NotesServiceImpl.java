package com.vansh.spring.demo.service;

import com.vansh.spring.demo.dao.NotesRepository;
import com.vansh.spring.demo.entity.Notes;
import com.vansh.spring.demo.entity.Task;
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
    public List<Notes> findAll() {
        return notesRepository.findAll();
    }

    @Override
    public Notes findById(int id) {

        Optional<Notes> result=notesRepository.findById(id);

        Notes note=null;
        if (result.isPresent()) {
            note=result.get();
        }
        else{
            throw new RuntimeException("Invalid Notes id -- "+id);
        }

        return note;
    }

    @Override
    public void save(Notes note) {
        notesRepository.save(note);
    }

    @Override
    public void deleteById(int id) {
        notesRepository.deleteById(id);
    }
}
