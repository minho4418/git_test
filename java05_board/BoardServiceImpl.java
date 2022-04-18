package java05_board;

import java.util.List;
import java.util.Scanner;

import java04_squid.Squid;

public class BoardServiceImpl implements BoardService{
	private Scanner sc = new Scanner(System.in);
	private BoardDAO bdao = new BoardDAOImpl();
	@Override
	public void insert() {
		//입력받고 Board생성후 dao전달
		System.out.println("=================");
		System.out.println("***게시물 등록***");
		System.out.println("=================");
		System.out.print("작성자?");
		String writer = sc.next();
		sc.nextLine(); //엔터처리
		System.out.print("제목은?");
		String subject = sc.nextLine();
		System.out.print("내용은?");
		String content = sc.nextLine();
		
		Board board = new Board(writer, subject, content);
		int cnt = bdao.insert(board);
		if (cnt>0)
			System.out.println(cnt+"건이 추가 성공");
		else {
			System.out.println("추가 실패");
		}

	}
	@Override
	public void update() {
		System.out.println("=================");
		System.out.println("***게시물 수정***");
		System.out.println("=================");
		System.out.print("작성자?");
		String writer = sc.next();
		sc.nextLine(); //엔터처리
		System.out.print("제목은?");
		String subject = sc.nextLine();
		System.out.print("내용은?");
		String content = sc.nextLine();
		
		Board board = new Board(writer, subject, content);
		int cnt = bdao.insert(board);
		if (cnt>0)
			System.out.println(cnt+"건이 수정 성공");
		else {
			System.out.println("수정 실패");
		}
	}
	@Override
	public void delete() {
		System.out.println("=================");
		System.out.println("***게시물 삭제***");
		System.out.println("=================");
		System.out.println("작성자?");
		String writer = sc.next();
		int cnt = bdao.delete(writer);
		System.out.println(cnt+"건이 삭제 성공");

	}
	@Override
	public void selectOne() {
		System.out.println("=====================");
		System.out.println("***게시물 한건조회***");
		System.out.println("=====================");
		System.out.println("순번?");
		int seq = sc.nextInt();
		Board board = bdao.selctOne(seq);
		if (board != null) {
			System.out.println("순번 : " + board.getSeq());
			System.out.println("작성자:" + board.getWriter());
			System.out.println("제목::" + board.getSubject());
			System.out.println("내용:" + board.getContent());
			System.out.println("날짜:" + board.getRegidate());
		}
	}
	@Override
	public void selectList() {
		System.out.println("=======================");
		System.out.println("***게시물 전체리스트***");
		System.out.println("=======================");
		List<Board> blist = bdao.selectList();
		for(Board board:blist) {
			System.out.println("-------------------");
			System.out.println("번호:" + board.getSeq());
			System.out.println("작성자:" + board.getWriter());
			System.out.println("제목::" + board.getSubject());
			System.out.println("내용:" + board.getContent());
			System.out.println("날짜:" + board.getRegidate());
		}
	}

	@Override
	public void selectListWriter() {
		System.out.println("=======================");
		System.out.println("***게시물 작성자조회***");
		System.out.println("=======================");
		System.out.println("작성자는?");
		String writer = sc.next();
		List<Board> blist = bdao.selectList(writer);
		for(Board board:blist) {
			System.out.println("-------------------");
			System.out.println("번호:" + board.getSeq());
			System.out.println("작성자:" + board.getWriter());
			System.out.println("제목::" + board.getSubject());
			System.out.println("내용:" + board.getContent());
			System.out.println("날짜:" + board.getRegidate());
		}
	}

}

