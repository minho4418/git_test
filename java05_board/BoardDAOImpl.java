package java05_board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java03_student.DBConn;

public class BoardDAOImpl implements BoardDAO{
	private Connection con;
	private PreparedStatement pstmt;
	private String sql;
	
	@Override
	public int insert(Board board) {
		int cnt=0;
		con = DBConn.getConnection();
		sql="INSERT INTO board (seq, writer, subject, content)\r\n"
				+ "VALUES (s_seq.nextval, ?, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getSubject());
			pstmt.setString(3, board.getContent());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int update(Board board) {
		int cnt=0;
		con = DBConn.getConnection();
		sql="UPDATE board\r\n"
				+ "SET  writer = ?,\r\n"
				+ "     subject = ?,\r\n"
				+ "     content = ?\r\n"
				+ "WHERE seq = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getSubject());
			pstmt.setString(3, board.getContent());
			pstmt.setInt(4, board.getSeq());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int delete(int seq) {
		int cnt=0;
		con = DBConn.getConnection();
		sql="DELETE FROM board\r\n"
				+ "WHERE seq = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seq);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}
	
	@Override
	public int delete(String writer) {
		//writer기준 삭제
		int cnt=0;
		con = DBConn.getConnection();
		sql="DELETE FROM board\r\n"
				+ "WHERE writer =?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, writer);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public Board selctOne(int seq) {
		Board board = null;
		con = DBConn.getConnection();
		sql="SELECT * FROM board WHERE seq=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seq);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String writer = rs.getString("writer");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				Date regidate = rs.getTimestamp("regidate");
				board = new Board(seq, writer, subject, content, regidate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return board;
	}

	@Override
	public List<Board> selectList() {
		List<Board> blist = new ArrayList<>();
		con = DBConn.getConnection();
		sql="SELECT * FROM board ORDER BY seq";
		
		try {
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int seq = rs.getInt("seq");
				String writer = rs.getString("writer");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				Date regidate = rs.getTimestamp("regidate");
				Board board = new Board(seq, writer, subject, content, regidate);
				blist.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return blist;
	}

	@Override
	public List<Board> selectList(String writer) {
		List<Board> blist = new ArrayList<>();
		con = DBConn.getConnection();
		sql="SELECT * FROM board \r\n"
				+ "WHERE writer = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, writer);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int seq = rs.getInt("seq");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				Date regidate = rs.getTimestamp("regidate");
				Board board = new Board(seq, writer, subject, content, regidate);
				blist.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return blist;
	}

	@Override
	public List<Map<String, Object>> selectListMember(String findvalue) {
		// 보드+멤버 조인 리스트
		List<Map<String, Object>> mlist = new ArrayList<>();
		
		con = DBConn.getConnection();
		sql = "select b.seq, b.writer, m.email , b.subject, b.regidate\r\n"
				+ "from board b join member m on (b.writer = m.userid)\r\n"
				+ "where b.subject like '%' || ? || '%'\r\n" // || 문자열의 연결(오라클에서)
				+ "order by b.seq desc";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, findvalue);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int seq = rs.getInt("seq");
				String writer = rs.getString("writer");
				String subject = rs.getString("subject");
				String email = rs.getString("email");
				Date regidate = rs.getTimestamp("regidate");
				Map<String, Object> map = new HashMap<>();
				map.put("seq",seq);
				map.put("writer",writer);
				map.put("subject",subject);
				map.put("email",email);
				map.put("regidate",regidate);
				mlist.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mlist;
	}

	@Override
	public List<Map<String, Object>> selectListMemberYear(String findvalue) {
		List<Map<String, Object>> mlist = new ArrayList<>();
		
		con = DBConn.getConnection();
//		sql = "select b.seq, b.writer,  m.birthyear , b.subject, b.regidate\r\n"
//				+ "from board b join member m on (b.writer = m.userid)\r\n"
//				+ "where  b.writer like '%' || ? || '%'\r\n"
//				+ "order by b.seq";
//		
		StringBuilder sb = new StringBuilder();
		sb.append("select b.seq, b.writer,  m.birthyear , b.subject, b.regidate\r\n");
		sb.append("from board b join member m on (b.writer = m.userid)\r\n");
		sb.append("where b.writer like '%' || ? || '%'\r\n");
		sb.append("order by b.seq");
		try {
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, findvalue);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int seq = rs.getInt("seq");
				String writer = rs.getString("writer");
				int birthyear = rs.getInt("birthyear");
				String subject = rs.getString("subject");
				Date regidate = rs.getTimestamp("regidate");
				Map<String, Object> map = new HashMap<>();
				map.put("seq",seq);
				map.put("writer",writer);
				map.put("subject",subject);
				map.put("birthyear",birthyear);
				map.put("regidate",regidate);
				mlist.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mlist;
	}
}