package com.notes.application.Notes.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.notes.application.Notes.models.Note;



@Repository("note")
public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query("SELECT n FROM note n WHERE n.collectionId=?1")
    public List<Note> getNotesByCollectionId(Long collectionId);

}
