package com.vansh.spring.demo.service;

import com.vansh.spring.demo.entity.Notes;
import com.vansh.spring.demo.entity.Task;

import java.util.List;

public interface NotesService {

    public List<Notes> findAll();

    public Notes findById(int id);

    public void save(Notes note);

    public void deleteById(int id);


}
