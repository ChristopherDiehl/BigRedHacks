package com.crum;

import java.util.ArrayList;
import java.util.Collections;

public class NoteHelper {
	public static String findGreatestHtmlId(ArrayList<Note> notes)
	{
		if (notes == null || notes.size() == 0) 
			return "0";

		Collections.sort(notes);
		return notes.get(0).getHtmlId();

			
		
	}
}
