package org.company.myapp.dto;

public class Joininfo {
	private String joindate;
	private int join0;
	private int join1;
	private int join2;
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public int getJoin0() {
		return join0;
	}
	public void setJoin0(int join0) {
		this.join0 = join0;
	}
	public int getJoin1() {
		return join1;
	}
	public void setJoin1(int join1) {
		this.join1 = join1;
	}
	public int getJoin2() {
		return join2;
	}
	public void setJoin2(int join2) {
		this.join2 = join2;
	}
	
	@Override
	public String toString() {
		return "Joininfo [joindate=" + joindate + ", join0=" + join0 + ", join1=" + join1 + ", join2=" + join2 + "]";
	}
	
	
}
