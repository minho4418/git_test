package org.company.myapp.dto;

public class Highoption {
	private String hcode;
	private String hname;
	public Highoption() {
		super();
	}
	public Highoption(String hcode, String hname) {
		super();
		this.hcode = hcode;
		this.hname = hname;
	}
	public String getHcode() {
		return hcode;
	}
	public void setHcode(String hcode) {
		this.hcode = hcode;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	@Override
	public String toString() {
		return "Highoption [hcode=" + hcode + ", hname=" + hname + "]";
	}
	
	
}
