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
		ArrayList<Note> div0 = noteRepo.findAllByDiv("div0");
		ArrayList<Note> div1 = noteRepo.findAllByDiv("div1");
		ArrayList<Note> div2 = noteRepo.findAllByDiv("div2");
		ArrayList<Note> div3 = noteRepo.findAllByDiv("noteholder");

		model.put("div0", div0);
		model.put("div1", div1);
		model.put("div2",div2);
		model.put("noteholder",div3);
		model.put("max_id",NoteHelper.findGreatestHtmlId(noteRepo.findAll()));
		
		
		return "index";
	}

	@RequestMapping(value="/saveNote", method=RequestMethod.POST)
	public String saveNote(Model model,HttpServletRequest request)
	{	
		Note note = new Note(request.getParameter("name"),
									request.getParameter("content"),
									request.getParameter("div"),
									request.getParameter("id")
									);
		noteRepo.save(note);
		return "/"; 
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
