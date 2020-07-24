package com.brodacki.janusz.notebook.repository;

import com.brodacki.janusz.notebook.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {

}
