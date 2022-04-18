package java05_board;

import java.util.Date;

public class Board {
	private int seq;
	private String writer;
	private String subject;
	private String content;
	private Date regidate;
	public Board() {
		super();
	}
	
	public Board(String writer, String subject, String content) {
		super();
		this.writer = writer;
		this.subject = subject;
		this.content = content;
	}
	public Board(int seq, String writer, String subject, String content) {
		super();
		this.seq = seq;
		this.writer = writer;
		this.subject = subject;
		this.content = content;
	}

	public Board(int seq, String writer, String subject, String content, Date regidate) {
		super();
		this.seq = seq;
		this.writer = writer;
		this.subject = subject;
		this.content = content;
		this.regidate = regidate;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegidate() {
		return regidate;
	}

	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}

	@Override
	public String toString() {
		return "Board [seq=" + seq + ", writer=" + writer + ", subject=" + subject + ", content=" + content
				+ ", regidate=" + regidate + "]";
	}
	
}
