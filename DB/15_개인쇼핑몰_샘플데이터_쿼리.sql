use shoppingmall;

/* 이름이 홍길동, 회원 아이디가 abc123, 비번이 1234, 번호가 011-1234-5678,
 주소는 서울시 강남구 KH빌딩, 상세주소는 6층 361반, 우편번호가 01234인 회원이 가입했을 때의 쿼리
 권한은 admin, user 중 하나
*/
INSERT INTO MEMBER(ME_ID, ME_PW, ME_PHONE, ME_ADDR, ME_ADDR_DETAIL, ME_POST, ME_AUTHORITY, ME_NAME)
	VALUES('abc123','1234','011-1234-5678','서울시 강남구 KH빌딩', '6층 361반', '01234', 'USER', '홍길동');

INSERT INTO MEMBER(ME_ID, ME_PW, ME_PHONE, ME_ADDR, ME_ADDR_DETAIL, ME_POST, ME_AUTHORITY, ME_NAME)
	VALUES('admin','admin','011-1111-1111','서울시 강북구 KH빌딩', '3층 101호', '01231', 'ADMIN', '임꺽정');
INSERT INTO MEMBER(ME_ID, ME_PW, ME_PHONE, ME_ADDR, ME_ADDR_DETAIL, ME_POST, ME_AUTHORITY, ME_NAME)
	VALUES('qwe123','qwe1234','011-9999-5678','서울시 강남구 KH빌딩', '1층 161반', '01234', 'USER', '고길동');
    

/*제품코드가 ABC001, 제품명이 KH무선마우스, 제품상세가 KH무선마우스이다. 가격은 15000원
 종류는 무선/유선인 제품 등록하는 쿼리
 => product 테이블과 option 테이블에 추가하는 예제
*/
insert into product values('ABC001','KH무선마우스','KH무선마우스입니다.','15000');
insert into `option`(op_name, op_pr_code) values('무선','ABC001'),('유선','ABC001');

/*
제품코드가 ABC001인 제품의 제품 정보와 옵션을 조회하는 쿼리
*/
select * from product 
	join `option` on pr_code = op_pr_code
	where pr_code = 'ABC001';
    
select * from member;
