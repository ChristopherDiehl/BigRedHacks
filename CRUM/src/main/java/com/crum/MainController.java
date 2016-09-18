package com.crum;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class MainController {

	@Autowired 
	private NoteRepository noteRepo;
	
	@RequestMapping(value={"/","/index"})
	public String index(ModelMap model)
	{
		model.put("div0", noteRepo.findAllByDiv("div0"));
		model.put("div1", noteRepo.findAllByDiv("div1"));
		model.put("div2", noteRepo.findAllByDiv("div2"));
		ArrayList<Note> notes = noteRepo.findAll();
		model.put("notes",notes);
		model.put("max_id",NoteHelper.findGreatestHtmlId(notes));
		return "index";
	}

	@RequestMapping(value="/saveNote", method=RequestMethod.POST)
	public String saveNote(Model model,HttpServletRequest request)
	{	
		String id = request.getParameter("id");
		System.out.println("id: "+id);

		if(id != null && !"".equals(id)) {
			Note note = noteRepo.findByHtmlid(id);
			if(note != null) {
				note.setName(request.getParameter("name"));
				note.setDiv(request.getParameter("div"));
				note.setContent(request.getParameter("content"));
			} else {
				note = new Note(request.getParameter("name"),
						request.getParameter("content"),
						request.getParameter("div"),
						id
						);
			}
			noteRepo.save(note);
		} else {
			System.out.println("Post failed");
		}

		
		return "index"; 
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model,HttpServletRequest request)
	{	
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginPost(Model model)
	{	

		return "index";
	}

}
