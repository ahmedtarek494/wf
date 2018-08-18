package com.wf.controllers.dto;

import java.io.Serializable;

public class CenterDto implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
