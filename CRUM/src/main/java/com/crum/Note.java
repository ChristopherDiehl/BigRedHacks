package com.crum;

import org.springframework.data.annotation.Id;

public class Note implements Comparable<Note>
{
	@Id
	private String id;
	private String content;
	private String name;
	private String div;
	private String htmlid;

	public Note(String name, String content,String div,String htmlid) {
		this.content = content;
		this.name = name;
		this.div = div;
		this.htmlid = htmlid;
	}
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDiv() {
		return div;
	}
	public void setDiv(String div) {
		this.div = div;
	}
	public void setHtmlId(String htmlid){
		this.htmlid = htmlid;
	}
	public String getHtmlId() {
		return htmlid;
	}
	@Override
	public int compareTo(Note o) {
		int htmlid1 = Integer.parseInt(htmlid);
		int htmlid2 = Integer.parseInt(o.getHtmlId());
		if(htmlid1 == htmlid2) {
			return 0;
		} else if(htmlid1 > htmlid2) {
			return 1;
		} else {
			return -1;
		}		
	}
	

}