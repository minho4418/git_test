package org.company.myapp.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Member {
	private String email;
	private String passwd;
	private String username;
	private String zipcode;
	private String addrload;
	private String addrdetail;
	private String filename; //파일이름
	private String emailauth;
	private String simplejoin;
	private Date regidate;
	private Date modidate;
	
	//파일
	MultipartFile photofile;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddrload() {
		return addrload;
	}
	public void setAddrload(String addrload) {
		this.addrload = addrload;
	}
	public String getAddrdetail() {
		return addrdetail;
	}
	public void setAddrdetail(String addrdetail) {
		this.addrdetail = addrdetail;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getEmailauth() {
		return emailauth;
	}
	public void setEmailauth(String emailauth) {
		this.emailauth = emailauth;
	}
	public String getSimplejoin() {
		return simplejoin;
	}
	public void setSimplejoin(String simplejoin) {
		this.simplejoin = simplejoin;
	}
	public Date getRegidate() {
		return regidate;
	}
	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}
	public Date getModidate() {
		return modidate;
	}
	public void setModidate(Date modidate) {
		this.modidate = modidate;
	}
	public MultipartFile getPhotofile() {
		return photofile;
	}
	public void setPhotofile(MultipartFile photofile) {
		this.photofile = photofile;
	}
	@Override
	public String toString() {
		return "Member [email=" + email + ", passwd=" + passwd + ", username=" + username + ", zipcode=" + zipcode
				+ ", addrload=" + addrload + ", addrdetail=" + addrdetail + ", filename=" + filename + ", emailauth="
				+ emailauth + ", simplejoin=" + simplejoin + ", regidate=" + regidate + ", modidate=" + modidate
				+ ", photofile=" + photofile + "]";
	}

	
	
}
