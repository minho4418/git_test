/**
 * 게시물 상세 조회
 */
 //삭제버튼 클릭시
function removeCheck(path, bnum){
	if(!confirm('삭제 하시겠습니까?')) return ;

	location.href=path+'/board/remove?bnum='+bnum;
}

//로딩이 완료된후
window.addEventListener('load',()=>{
	//컨택스트 패스
	const path = $('#contextpath').val();	
	
	//이벤트 달기 : 좋아요+1
	document.getElementById('like').addEventListener('click',()=>{
		//ajax방식 좋아요 update
		const bnum = $('#bnum').text();
		console.log(bnum);
		//브라우저 지원 자바스트립트 함수 
		//비동기방식으로 서버호출
/*		fetch(`/myapp/board/like/${bnum}`, {
			method : 'put',
		})
		.then(res=>res.text()) //전송받은 데이터 문자열로 
		.then(text=>{
			console.log('리턴값:',text); //좋아요 likecnt
			document.getElementById('likecnt').innerText=text;
			
		})
		.catch(err=>console.log(err));
*/
		//jquery 비동기방식 서버 호출
		$.ajax({
			url : `${path}/board/like/${bnum}`,
			type : 'put',
			dataType : 'text', //전송받은 데이터 문자열로 
			success : function(text){
				console.log('리턴값:',text); //좋아요 likecnt
				$('#likecnt').html(text);
			},
			error : function(err){
				console.log(err);
			}
		});
		
	});	
	
	//싫어요+1
	document.getElementById('dislike').addEventListener('click', ()=>{
		const bnum = document.getElementById('bnum').innerText;
		
		//백틱안에 자바스트립트 변수 ${}
		fetch(`${path}/board/dislike/${bnum}`,{
			method : 'put'
		})
		.then(res=> res.text())
		.then(text=>{
			console.log(text);
			document.getElementById('dislikecnt').innerText= text;
		})
		.catch(err=>console.log(err));
	}); //dislike click이벤트 닫기
	
}); //windows 로딩완료 이벤트 닫기
 
