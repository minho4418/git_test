package org.company.myapp.advice;

//열거형
//코드와 메시지 관리
public enum ErrorCode {
	SUCCESS_ADD(0, "추가 성공"),
	SUCCESS_MODIFY(0, "수정 성공"),
	SUCCESS_REMOVE(0, "삭제 성공"),
	ERROR_LOGIN_EMAIL(1, "등록된 이메일이 없습니다."),
	ERROR_LOGIN_PASSWD(2, "비밀번호 불일치."),
	ERROR_LOGIN_EMAILAUTH(3, "이메일 미인증"),
	SUCCESS_LOGIN(0, "환영합니다."),
	ERROR_JOIN_ID_EXIST(1,"이미 등록된 아이디" ),
	SUCCESS_JOIN(0,"이메일 인증 진행해 주세요" ),
	SUCCESS_EMAILAUTH(0,"이메일 인증이 완료 되었습니다." ),
	ERROR_EMAILAUTH(1,"인증코드가 일치 하지 않습지다." ),
	ERROR_NO_NAVER_JOIN(1, "네이버 간편가입 회원이 아닙니다.!"),
	SUCCESS_NAVER_LOGIN(0, "네이버 간편가입으로 로그인 완료!"),
	SUCCESS_NAVER_JOIN(0, "간편가입이 완료 되었습니다."),
	ERROR_NAVERAUTH(1, "네이버 인증이 유효하지 않습니다.!");

	
	private int code;
	private String msg;
	//생성자
	private ErrorCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	//게터
	public int getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	
}
