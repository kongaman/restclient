package com.bharath.restwsclient.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Patient") // JAXB anntoation -> can be serialized and deserialized into xml and back to java object
public class Patient {

	private long id;
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
