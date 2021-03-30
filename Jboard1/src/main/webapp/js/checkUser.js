/**
 * 아이디, 별명,
 */

var isUidOk = false; // 상태 변수
var isUidEngOk = false;
var isPasswordOk = false;
var isNameOk = false;

$(function(){
	// 아이디 중복체크 && 아이디 영문소문자 여부 확인
	/*var inputUid = $('input[name=uid]');*/
	var regUid =  /^[a-z]+[a-z0-9]{3,10}$/
	
	$('input[name=uid]').focusout(function(){
		
		var uid = $(this).val();
		var jsonData = {'uid' : uid}; //자바스크립트에서 객체 표기?? json 형식?
		// 서버에서 클라이언트로 json 전달?
		// ajax 부분통신 기본 형식
		$.ajax({
			url: '/Jboard1/user/proc/checkUid.jsp', //어디로 
			type: 'get', //get?post?
			data: jsonData, //전송 할 데이터
			dataType: 'json', //서버에서 되돌려 받는 값(대부분 json)
			//서버가 도착하면 function 실행
			success: function(data){ //여기서 data는 0(id없음) or 1(id있음) 임
				//alert(data.result);
				
				if(data.result == 0){
					isUidOk = true; //중복 통과
					$('.resultId').css('color', 'green').text('사용 가능한 아이디 입니다.');
					
					if(regUid.test(uid) == true){
						isUidEngOk = true;
					}else{
						isUidEngOk = false;
						$('.resultId').css('color', 'red').text('아이디는 영문 소문자, 숫자 조합 4~10자까지 입니다.');
					}
					
				}else{
					isUidOk = false;
					$('.resultId').css('color', 'red').text('이미 사용중인 아이디 입니다.');
				}
			}
		}); 
		
	});
	
	// 비밀번호 일치여부 확인
	$('input[name=pass2]').focusout(function(){
		var pass1 = $('input[name=pass1]').val();
		var pass2 = $('input[name=pass2]').val();
		
		if(pass1 == pass2){
			isPasswordOk = true;
			$('.resultPass').css('color', 'green').text('비밀번호가 일치합니다.');
		}else{
			isPasswordOk = false;
			$('.resultPass').css('color', 'red').text('비밀번호가 일치하지 않습니다.');
		}
		
	});
	
	// 이름 한글 여부 확인
	var regName = /^[ㄱ-힣]{2,10}$/;
	
	$('input[name=name]').focusout(function(){
		
		var name = $(this).val();
		
		if(regName.test(name) == true){
			isNameOk = true;
			$('.resultName').text('');
		}else{
			isNameOk = false;
			$('.resultName').css('color', 'red').text('이름은 한글 2~10자까지 입력하십시오.');
		}
		
	});
	
	// 별명 중복체크
	// 이메일 중복체크
	// 휴대폰 중복체크
});