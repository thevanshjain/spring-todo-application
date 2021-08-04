package com.vansh.spring.demo.dao;

import com.vansh.spring.demo.entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<Notes, Integer> {

}
