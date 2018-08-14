package com.wf.controllers.dto;

public class CenterDto implements AbstractDTO{
	
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCentername() {
		return centername;
	}

	public void setCentername(String centername) {
		this.centername = centername;
	}

	public CenterDto(int id, String centername) {
		super();
		this.id = id;
		this.centername = centername;
	}

	private String centername;
}
