/*
개인이 운영하는 쇼핑몰 사이트 구축을 위한 요구사항 정리

- 요구사항
	- 판매자는 1명 고정, 판매자=관리자
   
    - 제품은 대분류, 중분류 선택해 등록한다.
    - 제품 수량이 없으면 품절 출력하며, 해당 옵션은 구매 불가처리 한다.
	- 제품은 판매자가 제품명, 제품코드, 제품 상세설명, 옵션종류, 수량, 제품이미지(썸네일 포함)를 선택해 등록
	
    - 회원은 아이디, 비번, 이메일, 전화번호, 이름, 주소를 입력해 회원가입 한다.
    - 회원가입시 아이디는 중복 체크하고, 전화번호로 본인인증 한다.
    
    - 회원은 제품 옵션을 선택해 장바구니에 수량과 함께 담을 수 있다.
    - 제품 코드와 옵션이 동일한 제품을 장바구니에 담으면 최근 수량으로 변경된다. 
    - 회원은 장바구니에 담은 제품 목록을 선택 후 바로구매 가능하다.
    - 회원은 장바구니에 담은 제품을 삭제할 수 있다. 
    
    - 회원은 제품 구매시 반드시 1개 이상의 옵션 선택, 수량 입력 후 구매한다.
	- 제품 구매시 등록된 배송지를 선택한다.
    - 등록된 배송지가 없다면 반드시 배송지를 등록해 추가해야한다.
    - 배송지 등록시, 우편번호, 주소, 상세주소, 배송지명(등록 이름) 입력한다.
    - 구매 완료시, 주문번호, 구매한 제품 목록(제품명, 제품코드, 옵션, 수량), 배송지를 보여준다.
    - 제품 구매 확정되면 구매 금액의 10%가 마일리지 적립된다.
    - 제품 구매시, 마일리지를 사용 가능하다.
    
    - 회원은 구매한 제품 목록을 확인가능하다.
    - 회원은 제품이 배송 전이면 바로 주문취소 가능하다.
    - 회원은 제품에 하자가 있으면 반품/환불이 가능하다.
    - 회원은 반품/환불을 하려면 제품 사진과 반품 사유를 관리자에게 보내 승인을 받아야 반품/환불이 가능하다.
    - 회원은 제품 수령에 문제가 없으면 구매 확정처리로 완료한다.
    
    - 회원은 구매확정이 된 제품에 한해 리뷰작성이 가능하다.
    - 회원은 별점(1~5)과 리뷰, 이미지를 등록해 리뷰를 등록한다.
    
    - 회원은 제품 검색해 제품명, 가격, 별점을 조회가능하다.
    - 회원은 제품 조회시 제품명, 제품코드, 제품이미지(썸네일), 제품상세, 리뷰들을 조회가능하다.
    
    - 회원은 마일리지 이용 내역을 조회가능하다.
    - 회원은 마일리지 적립/사용내역을 조회가능하다.
*/
/*
- 개체를 논리적 설계시 개체명을 릴레이션으로, 개체 속성을 릴레이션 속성으로 바꿔 작성
- 관계를 논리적 설계시 경우에 따라 다음처럼 작성

-- 관계에 속성이 없는 경우
=> 두 개체의 관계가 1:1인 경우.
	(ex. A개체에 외래키로 B개체의 기본키를 설정. 누가 A,B일지는 상관X)
=> 두 개체의 관계가 1:n인 경우.
	(ex. n쪽인 개체에 다른 개체의 기본키를 외래키를 설정)
=> 두 개체의 관계가 n:m인 경우 (예. 대학생의 복수전공->전공과 대학생 사이를 잇는 소속!)
	(ex. 새 릴레이션 추가 후, 대리키를 기본키로 한 뒤 각 개체의 기본키들을 새 릴레이션의 외래키로 지정)
    
-- 관계에 속성이 있는 경우
=> 두 개체의 관계가 1:1, 1:n, n:m 인 경우. (셋 다 상관없음)
	(ex. 새 릴레이션 추가 후, 관계의 속성을 새 릴레이션 추가하고, 두 개체의 기본키들을 외래키로 지정
*/
/*
개인이 운영하는 쇼핑몰 사이트 구축을 위한 논리적 설계
- 회원(아이디(PK), 비번, 전화번호, 주소, 상세주소, 우편번호, 마일리지, 권한, 이름)
- 배송지(배송지번호(PK), 배송지명, 주소, 상세주소, 우편번호, 아이디(FK))
- 제품(제품코드(PK), 제품명, 상세설명, 가격)
- 옵션(옵션번호(PK), 옵션명, 수량, 제품코드(FK))
- 제품이미지(이미지번호(PK), 파일명, 제품코드(FK))
- 마일리지내역(마일리지 내역번호(PK), 내용, 마일리지, 아이디(FK))
- 주문(주문번호, 총금액, 결제금액, 사용마일리지, 적립마일리지, 상태, 아이디(FK), 배송지번호(FK), 주문목록번호(FK))
- 장바구니(장바구니번호(PK), 수량, 아이디(PK), 옵션번호(FK))
- 리뷰(리뷰번호(PK), 내용, 이미지, 아이디(FK), 옵션번호(FK))
- 주문목록(주문목록번호(PK), 수량, 총가격, 주문번호(FK), 옵션번호(FK))
*/
