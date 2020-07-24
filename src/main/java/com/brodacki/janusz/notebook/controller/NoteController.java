package com.brodacki.janusz.notebook.controller;

import com.brodacki.janusz.notebook.model.Note;
import com.brodacki.janusz.notebook.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/notes")
public class NoteController {

    private NoteRepository noteRepository;

    @Autowired
    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }


    @PostMapping
    public String saveNote(Note note) {
        noteRepository.save(note);
        return "redirect:/notes/listNotes";
    }

    @RequestMapping("/listNotes")
    public String getListNotes(Model model) {
        List<Note> note = noteRepository.findAll();
        model.addAttribute("note", note);
        return "notelist";
    }

    @RequestMapping("/newNote")
    public String addNote(Model model) {
        model.addAttribute("note", new Note());
        return "note";
    }

    @GetMapping("/getById/{id}")
    public String getNoteToUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("note", noteRepository.getOne(id));
        return "updatenote";
    }

    @PostMapping("/update/{id}")
    public String updateNotes(@PathVariable Long id, @Valid Note note, Model model) {
        noteRepository.save(note);
        return "redirect:/notes/listNotes";
    }
}
