package com.crum;

import org.springframework.data.annotation.Id;

public class Note 
{
	@Id
	private String id;
	private String content;
	private String name;
	private String div;
	private String htmlid;

	public Note(String name, String content,String div) {
		this.content = content;
		this.name = name;
		this.div = div;
	}
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
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

}