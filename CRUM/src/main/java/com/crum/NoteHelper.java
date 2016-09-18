package com.crum;

import java.util.ArrayList;

public class NoteHelper {
	public static String findGreatestHtmlId(ArrayList<Note> notes)
	{
		if (notes == null) 
			return 0;

		Collections.sort(notes);
		return notes.get(0);

			
		
	}
}
