$(function () {
	$('#adminLogin').on('change', function () {
		if ($(this).is(":checked")) {
			console.log("눌렀을 때 함수 실행");
			$("#loginForm").attr("action", "/shard/adminLogin");
		} else {
			$("#loginForm").attr("action", "/shard/login");
		}
	});

	$('.buttonLogin').click(function (e) {
		e.preventDefault();
		loginCheck();
		$("#loginForm").submit();
	});
});

function loginCheck() {
	if (document.loginForm.userId.value.length == 0) {
		alert("아아디를 입력해주세요");
		loginForm.userId.focus();
		return false;
	}
	if (document.loginForm.userPwd.value == "") {
		alert("비밀번호는 반드시 입력해야 합니다.");
		loginForm.userPwd.focus();
		return false;
	}
}

