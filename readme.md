![image](https://github.com/appcoding-ux/Project/assets/112378228/2792c3fb-2148-4e7f-9afe-407172b3aa2c)<h1 align='center'> <img src='https://cdn-icons-png.flaticon.com/512/5208/5208370.png' style='width: 300px; height: 200px;'>&nbsp;</h1>
<h1  align='center'>👕스프링 의류 쇼핑몰 프로젝트</h1>
<div align='center'>
  <h3>
    🔗 <a href="">AWS 나중에 추가할 예정</a> 사이트 바로가기
  </h3>
</div>
<br/><br/>


## 목차
- [개요](https://github.com/appcoding-ux/Project#-개요)
- [기술 스택](https://github.com/appcoding-ux/Project#-기술-스택)
- [프로젝트 설계](https://github.com/appcoding-ux/Project#-프로젝트-설계)
- [핵심 기능](https://github.com/appcoding-ux/Project#-핵심-기능)
- [주요기능 실행화면](https://github.com/appcoding-ux/Project#-주요기능-실행화면)
- [개선사항](https://github.com/appcoding-ux/Project#-개선사항)
  


## 🚩 개요
- 프로젝트 목표 : 다양한 `API`를 활용한 `스프링` , `마이바티스` 의류 쇼핑몰 프로젝트
- 개발기간 : 23/11/27 ~ 23/12/15



## 🔧 기술 스택
- API : `카카오 API` `PORTONE API` `VWORLD API` `Tmap API`
- Language : `Java(11)` `JavaScript(1.5)`
- Library & Framework : `Spring(5.3.23)` `Junit(4.12)` `Servlet(4.0.1)` `Spring Security`
- Database : `MySQL(8.0.35)`
- Target : `Web Browser`
- Tool : `SpringSource Tool Suite (STS) 3.9.18.RELEASE`
- Infra : `Linux(Ubuntu)` `EC2`
- Etc : `Git`

  

## 👾 프로젝트 설계, 구현 📂 PPT 📂 (ERD, USECASE)



<details><summary>프로젝트 설계, 구현, PPT</summary>   
<div align="center">          

| **![1](https://github.com/appcoding-ux/Project/assets/112378228/d948b8b2-e66d-4d80-9fe9-d8c5caeb81f9)** | **![2](https://github.com/appcoding-ux/Project/assets/112378228/6b84f01b-fce4-4c83-8076-240acc1395fd)** |
| :------: |  :------: |
|  ![3](https://github.com/appcoding-ux/Project/assets/112378228/3369b489-ebd5-4099-9ea0-bb80565879cb) | ![4](https://github.com/appcoding-ux/Project/assets/112378228/753437c7-ecdf-4c53-970f-af074d23fa6d) |
| ![5](https://github.com/appcoding-ux/Project/assets/112378228/29b626a4-b1a5-4d77-9fb9-3f57c58d2f9c) | ![6](https://github.com/appcoding-ux/Project/assets/112378228/86b63cf7-fbfe-438f-9897-f84743b0d42c)  |
| ![7](https://github.com/appcoding-ux/Project/assets/112378228/03414621-6244-48b7-8d3b-fce58dfbb883) | ![8](https://github.com/appcoding-ux/Project/assets/112378228/05a507fa-e531-450d-9b63-88593143d57a) |
| ![9](https://github.com/appcoding-ux/Project/assets/112378228/24383aae-7164-4d66-9065-d391a24d2645) | ![10](https://github.com/appcoding-ux/Project/assets/112378228/edb876a4-7af8-4dfd-9c58-33884b03735d) |
| ![11](https://github.com/appcoding-ux/Project/assets/112378228/8d6a0ea5-7956-4184-961f-acda5cf87141) | ![12](https://github.com/appcoding-ux/Project/assets/112378228/5b1d5faf-1b02-422c-9fa2-0b780eb39dcb) |
| ![13](https://github.com/appcoding-ux/Project/assets/112378228/216f3a68-0c93-4dc7-bb5e-efe260e5ab4b) | ![14](https://github.com/appcoding-ux/Project/assets/112378228/f23968e6-3410-4f68-8340-8ac7013055b9) |
| ![15](https://github.com/appcoding-ux/Project/assets/112378228/632073fb-2d18-497e-bb6e-68869b91be32) | ![16](https://github.com/appcoding-ux/Project/assets/112378228/02431aff-7034-4259-bb08-b68e7d2a6760) |
| ![17](https://github.com/appcoding-ux/Project/assets/112378228/a0551a0b-a861-4fc1-a57c-978a22e54f2d) | ![18](https://github.com/appcoding-ux/Project/assets/112378228/381dbdd2-af70-431c-921d-6eace9e27fb6) |
| ![19](https://github.com/appcoding-ux/Project/assets/112378228/e746a705-a5fe-4950-99f6-bf0af7df28ba) | ![20](https://github.com/appcoding-ux/Project/assets/112378228/bd45ee6e-c378-4680-b6f0-05c6db531b1f) |
| ![21](https://github.com/appcoding-ux/Project/assets/112378228/743eec56-7e7d-44e9-a033-f6d75eaf435d) | ![22](https://github.com/appcoding-ux/Project/assets/112378228/25f59ab5-e221-4a70-be9c-7622279fb315) |
| ![23](https://github.com/appcoding-ux/Project/assets/112378228/8edb9187-5702-42d4-8b81-739ce664faa0) | ![24](https://github.com/appcoding-ux/Project/assets/112378228/e5bfc561-4b24-44a3-bc5b-e8d9c066b47f) |


</div>            
</details>         

## 💻 핵심 기능


#### 상품
- 의류 쇼핑몰 사이트를 이용해 상품정보 DB 저장
- 상품 정렬(낮은 가격, 높은 가격, 등록순)
- 상품 검색(상품이름, 카테고리, 색상, 색상+상품이름)
- 관심상품
- 상품 정보 제공

#### 유저
- 소셜 로그인 및 간편 회원가입
- 이메일 중복 처리
- 비밀번호 암호화 처리
- 다음 우편주소 API
- 마이페이지(장바구니, 관심상품, 사용 가능한 쿠폰, 주문내역, 배송지 관리, 내 게시글) 
- 유저 정보 수정
- 비밀번호 찾기

#### 장바구니
- 상품 장바구니에 담기 및 제거
- 실시간 수량 수정후 결제
- 같은 상품, 같은 사이즈 장바구니 담을 시 수량 증가

#### 주문
- 장바구니 상품 주문
- 주문 정보 확인
- IamportAPI 이용한 결제

#### 리뷰(상품리뷰)
- 리뷰작성

#### 관리자
- 상품 등록
- 상품 재고 및 이미지 수정
- 유저관리 및 통계, 공지사항 CRUD
- 배송관련
- 고객의 문의 답변

#### Q&A
- 비밀글 (작성자, 관리자만 조회 가능)
- 1:1 문의 작성 및 문의 조회
- 관리자의 계층형 답글

 
## 🎇 주요기능 실행화면

<details>
<summary>주요기능 실행화면</summary>

* **메인 화면**
  * `카테고리` 메뉴를 사용해 카테고리 별로 상품을 확인할 수 있습니다.
  
* **회원가입 및 로그인**
  * 회원가입시 프론트+서버 검증으로 `잘못 입력된 부분과 그 값`을 다시 보여줍니다. 
    
  
  * `다음 우편주소API`를 이용해 배송을 위한 정확한 주소를 가져올 수 있습니다.
   

* **상품 상세 조회 및 좋아요**
  * 상품 목록에서 상품의 사진을 클릭하면 `상품 상세 정보` 를 확인할 수 있습니다.
  * `상품 상세` 페이지에서 좋아요(추천)을 할 수 있습니다.
  
* **리뷰(한줄평) 작성**
  * `상품 상세` 페이지에서 리뷰를 등록할 수 있습니다.
  * `구매고객` 상품을 구매한 고객만 리뷰를 등록할 수 있습니다.
  
* **장바구니**
  * `상품 상세보기`에서 `장바구니 상품 추가`가 가능합니다.
  * `장바구니` 메뉴에서 추가한 상품의 확인 및 수량변경이 가능합니다. 장바구니의 `결제하기` 를 누르면 결제페이지로 이동합니다.
  
  
* **주문하기**
  * `결제하기` 를 누르면 IamportAPI와 연동된 kg이니시스 결제페이지로 이동합니다.
  * 결제가 완료되면 `결제 내역` 메뉴에서 결제 정보를 확인할 수 있습니다.
    
* **관리자 페이지**

  * `제품관리` 메뉴에서 상품을 등록하거나 재고 및 이미지등을, 수정, 삭제 할 수 있습니다.
  

  * `고객관리` 메뉴에서 비정상적인 고객을 비활성화 처리할 수 있습니다.
  

  * `공지사항` 메뉴에서 공지사항 등록, 수정, 삭제 할 수 있습니다.

 
  * `통계` 메뉴에서 나이대에 맞게 통계를 확인할 수 있습니다.
 
  * `문의답변` 메뉴에서 현재 답변하지 않은 문의들을 답변할 수 있습니다.

* **Q&A**
  * 고객센터에서 유저가 1:1문의를 작성하면 관리자가 답변을 해줄 수 있습니다.
  
</details>


## 🌄 개선사항
- 배송전 주문취소 기능
- 할인율 높은 쿠폰 자동적용
- 고객의 환불 요청
- 리뷰 수정, 삭제, 리뷰의 대댓글
- 비밀번호 찾기를 했을 때 탈퇴 회원 복구
