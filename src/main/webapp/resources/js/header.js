/**
 * 헤더
 */
 
 //document가 준비되었을때 
$(function(){
	//컨택스트 패스
	const path = $('#contextpath').val();
	
	const sessionEmail = $('#sessionEmail').text().trim();
	console.log(sessionEmail);
	//로그인, 로그아웃, 회원가입 제어
	if (!sessionEmail){ //로그인 전
		$('#aLogin').show();
		$('#aLogout').hide();
		$('#aJoin').show();
	}else{  //로그인 후
		$('#aLogin').hide();
		$('#aLogout').show();
		$('#aJoin').hide();
	}
	
	//로그아웃 버튼을 클릭했을때
	$('#aLogout').click(e=>{
		e.preventDefault(); //기본이벤트 제거
		if (confirm('로그아웃하시겠습니까?')){
			location.href=`${path}/logout`;
		}		
		
	});
	
	
	
	
});