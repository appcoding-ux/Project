<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문조회 로그인</title>
<link rel="stylesheet" href="css/common.css" />
<script src="js/kakaoLogin.js" type="text/javascript"></script>
<script src="js/loginCheck.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/login.css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&family=Noto+Sans:ital,wght@0,200;1,300&display=swap"
	rel="stylesheet">
<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.4.0/kakao.min.js"
	integrity="sha384-mXVrIX2T/Kszp6Z0aEWaA8Nm7J6/ZeWXbL8UpGRjKwWe56Srd/iyNmWMBhcItAjH"
	crossorigin="anonymous"></script>
<script>
	Kakao.init('a532ecf4ec0ea79cf0bf444a8eb18a44'); // 사용하려는 앱의 JavaScript 키 입력
</script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<!-- 회원가입을 성공적으로 마쳤을 때 login페이지로 이동하면서 환영한다는 경고창을 띄우고 로그인을 할 수 있게 한다. -->
	<script type="text/javascript">
    var joinMessage = <%= request.getAttribute("joinMessage") %>;
    if (joinMessage === 0) {
        alert("회원가입에 실패했습니다. 다시 시도해주십시오");
        // 페이지 로드를 막는 방법으로 location.href를 사용할 수 있습니다.
        location.href = "shardLogin.jsp"; // 로그인 페이지 URL로 이동
    } else if (joinMessage === 1) {
        alert("등록되었습니다. The Shard의 회원이 되어주셔서 감사합니다.");
    }
</script>

	<div class="loginWrap">
		<div class="login">
			<ul class="tab">
				<li>회원</li>
				<li>비회원</li>
			</ul>
			<p>로그인</p>
			<form action="shardLogin.do" method="post" id="loginForm" name="loginForm">
				<fieldset>
					<label for="userId" class="id"> <span>아이디</span> <input
						type="text" name="userId" id="userId" />
					</label> <label for="userPwd" class="pwd"> <span>비밀번호</span> <input
						type="password" name="userPwd" id="userPwd" />
					</label>
				</fieldset>
				<div class="findIDandPwd">
					<label for="adminLogin">관리자</label>
					<input type="checkbox" name="adminLogin" id="adminLogin" />
					<a href="">아이디/비밀번호 찾기</a>
				</div>
				<a href="javascript:loginCheck()" class="buttonLogin"><span>로그인</span></a>
				<a href="shardJoin.jsp" class="buttonJoin"><span>회원가입</span></a>

				<div class="sns_login">
					<p>SNS로그인</p>
					<ul>
						<li><a id="kakao-login-btn"
							href="javascript:loginWithKakao()">
							<img
								src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg"
								width="222" alt="카카오 로그인 버튼" />
						</a>
							<p id="token-result"></p></li>
					</ul>
				</div>
			</form>
		</div>
	</div>


	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>