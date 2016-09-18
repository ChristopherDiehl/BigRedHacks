package com.crum;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepository extends MongoRepository<Note, String> {

	public Note findById(String id);
	public Note findByHtmlid(String htmlid);
	public Note findByName(String name);
	public ArrayList<Note> findAll(); //sort  by id
	public ArrayList<Note> findAllByDiv(String div);

}