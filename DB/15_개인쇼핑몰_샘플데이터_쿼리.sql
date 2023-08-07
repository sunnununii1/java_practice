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

-- 제품 코드가 ABC001인 제품 중, 유선 제품은 10개 입고, 무선 제품은 5개 입고됐을 때 사용하는 쿼리
UPDATE `option` 
SET 
    OP_AMOUNT = 10
WHERE
    op_pr_code = 'ABC001' AND op_name = '유선';
UPDATE `option` 
SET 
    OP_AMOUNT = 5
WHERE
    op_pr_code = 'ABC001' AND op_name = '무선';

/* abc123 회원이 배송지 등록을 다음처럼 등록하는 쿼리
(배송지명:집, 주소:서울시 강남구 123번지, 상세:KH아파트 101동 101호, 우편번호:12345)
*/
insert into address(ad_name, ad_addr, ad_addr_detail, ad_post, ad_me_id)
		values('집','서울시 강남구 123번지','KH아파트 101동 101호','12345','abc123');

-- abc123회원이 ABC001 제품 중 유선을 3개 장바구니에 담았을 때의 쿼리
insert into basket(ba_amount, ba_me_id, ba_op_num)
	value(3,'abc123',2);
    -- select 3, 'abc123', op_num from `option` where op_pr_code = 'ABC001' and op_name = '유선';
    
-- abc123회원이 ABC001 제품 중 유선을 1개 장바구니에 담았을 때의 쿼리(이미 전에 3개 담겨져있음)
UPDATE basket
SET 
    ba_amount = 1
-- WHERE
--  ba_num = 1 -- 도 가능!
WHERE
    ba_me_id = 'abc123'
        AND ba_op_num = (SELECT 
            op_num
        FROM
            `option`
        WHERE
            op_pr_code = 'ABC001' AND op_name = '유선');
            
-- abc123회원이 ABC001 제품 중 무선을 2개 구매 후, 배송지로 집을 선택시 실행하는 모든 쿼리 작성
-- 1. 주문 내역(영수증)을 추가 (주문 리스트에서 주문내역번호 필요해서 선작업)
insert into `order`(or_total, or_price, or_use_point, or_save_point, or_me_id, or_ad_num)
	values(15000*2,15000*2,0,3000,'abc123',1);
select * from product;
-- 2. 주문 리스트에 구매목록 추가
insert into order_list(ol_amount, ol_price, ol_or_num, ol_op_num)
	values(2,15000*2,1,1);
-- 3. 제품 수량을 수정
update `option` set op_amount = op_amount - 2 where op_num = 1;
-- 4. 마일리지 포인트 적립
 -- 4-1. 마일리지 내역 작성
insert into point(po_content, po_amount, po_me_id)
	values('제품 구매에 의한 적립', '3000', 'abc123');
 -- 4-2. 회원정보에서 포인트 수정
update member set me_point = me_point + 3000 where me_id = 'abc123';

/* 제품코드가 ABC002, 제품명이 KH키보드, 제품상세가 혁신적인 KH키보드, 제품가격이 30000원
  제품 종류가 '기계식', '일반' 인 제품을 등록
*/
-- 1. 제품 추가
insert into `product` values('ABC002','KH키보드','혁신적인 KH키보드',30000);
-- 2. 옵션 추가
insert into `option`(op_name, op_amount, op_pr_code)
	values('기계식',0,'ABC002'),('일반',0,'ABC002');

-- 제품코드가 ABC002, 종류가 기계식인 제품이 100개,
UPDATE `option` 
SET 
    op_amount = op_amount + 100
WHERE
    op_pr_code = 'ABC002'
        AND op_name = '기계식';
-- 제품코드가 ABC002, 종류가 일반인 제품이 50개 입고됐을 때 쿼리
UPDATE `option` 
SET 
    op_amount = op_amount + 50
WHERE
    op_pr_code = 'ABC002'
		AND op_name = '일반';
        
-- qwe123회원이 ABC001 중 무선을 장바구니에 2개 넣고, 
INSERT INTO basket(ba_amount, ba_me_id, ba_op_num) select 2, 'qwe123', op_num from `option` where op_pr_code = 'ABC001' and op_name = '무선';
	-- values(2,'qwe123',1);
    
-- ABC002 중 기계식을 장바구니에 3개 담았을 때 쿼리 작성
INSERT INTO basket(ba_amount, ba_me_id, ba_op_num) select 3, 'qwe123', op_num from `option` where op_pr_code = 'ABC002' and op_name = '기계식';
	-- values(3,'qwe123',3);
    
-- qwe123회원이 장바구니에 담긴 모든 제품을 구매했을 때 쿼리(포인트 사용 안함)
-- 0. 배송지에 집 추가 (주소:경기도 안산시 안산구 123번지, 상세주소:없음, 우편번호:12312)
insert into address(ad_name, ad_addr, ad_addr_detail, ad_post, ad_me_id)
	values('집','경기도 안산시 안산구 123번지','없음','12312','qwe123');
    
-- 1. 주문 테이블에 추가
insert into `order`(or_total, or_price, or_use_point, or_save_point, or_me_id, or_ad_num)
 select 15000*2+30000*3, 15000*2+30000*3, 0, (15000*2+30000*3)/10, 'qwe123', ad_num
	from address
    where ad_me_id = 'qwe123' and ad_name = '집';
    
-- 2. 주문 리스트 테이블에 추가
insert into order_list(ol_amount, ol_price, ol_or_num, ol_op_num)
	select 2, pr_price*2, 2, op_num
		from `option`
        join product
        on op_pr_code = pr_code
        where op_pr_code = 'ABC001'
        and op_name = '무선';
        
insert into order_list(ol_amount, ol_price, ol_or_num, ol_op_num)
	select 3, pr_price*3, 2, op_num
		from `option`
        join product
        on op_pr_code = pr_code
        where op_pr_code = 'ABC002'
        and op_name = '기계식';
        
-- 3. 옵션 테이블에 수량 수정
UPDATE `option` 
SET 
    op_amount = op_amount - 2
WHERE
    op_pr_code = 'ABC001' AND op_name = '무선';
UPDATE `option` 
SET 
    op_amount = op_amount - 3
WHERE
    op_pr_code = 'ABC002'
        AND op_name = '기계식';

-- abc123회언이 제품을 받고 구매 확정을 눌렀을 때의 쿼리
-- 주문에 구매확정으로 수정
update `order` set or_state = '구매 확정' where or_num = 1;

-- 포인트 내역에 적립내용 추가
insert into point(po_content, po_amount, po_me_id)
	values('구매 확정으로 인한 적립', '3000','abc123');
    
-- 회원 정보에 포인트 누적
update member set me_point = me_point + 3000 where me_id = 'abc123'; 

-- abc123회원이 구매 확정한 ABC001제품 중 무선에 '좋은 마우스입니다.'라고 리뷰 등록한 쿼리
insert into review(re_content, re_thumb, re_op_num, re_me_id)
	values('좋은 마우스입니다.','NULL','1','abc123');