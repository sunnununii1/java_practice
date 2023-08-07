-- qwe123회원이 구매한 (환불, 반품 제외) 제품명과 옵션명 목록을 확인하는 쿼리
select
	or_me_id as 주문아이디,
    pr_name as 제품명,
    op_name as 옵션명,
    pr_price as 제품가격,
	ol_amount as 구매수량
from `order`
	join order_list on ol_or_num = or_num
    join `option` on ol_op_num = op_num
    join product on op_pr_code = pr_code
	where or_state not in('환불','반품') and or_me_id = 'qwe123';
    
-- abc123회원이 장바구니에 담은 제품명과 옵션명, 수량을 확인하는 쿼리
select ba_me_id as 회원아이디,
	   pr_name as 제품명,
       op_name as 옵션명,
       ba_amount as 수량
from basket
	join `option` on ba_op_num = op_num
    join product on op_pr_code = pr_code
	where ba_me_id = 'abc123';
    
-- abc123회원이 등록한 배송지 정보를 조회하는 쿼리
select * from address where ad_me_id = 'abc123';

-- 등록된 모든 제품을 검색하는 쿼리
select * from product;

-- KH가 제품명에 포함된 제품들을 검색하는 쿼리
select * from product where pr_name like '%KH%'; -- 또는 concat('%','KH','%');

-- KH가 제품명에 포함된 제품들 중 1페이지에 해당하는 제품들을 검색하는 쿼리 (한 페이지당 제품 최대 5개)
SELECT 
    *
FROM
    product
WHERE
    pr_name LIKE '%KH%'
limit 0, 5;

-- KH가 제품명에 포함된 제품들 중 2페이지에 해당하는 제품들을 검색하는 쿼리 (한 페이지당 제품 최대 5개)
SELECT 
    *
FROM
    product
WHERE
    pr_name LIKE '%KH%'
limit 5, 5;

-- abc123회원이 작성한 모든 리뷰를 조회하는 쿼리
select * from review where re_me_id = 'abc123';

-- abc123회원이 작성한 리뷰가 있는 제품명을 조회하는 쿼리
select * from review
	join `option` on re_op_num = op_num
    join product on pr_code = op_pr_code
	where re_me_id = 'abc123';
    
-- 제품 코드가 ABC001, 옵션명이 무선인 제품에 달린 리뷰 조회하는 쿼리
select * from review
	join `option` on re_op_num = op_num
	where op_pr_code = 'ABC001' and op_name = '무선';
    
-- 제품명이 KH무선마우스인 제품의 리뷰개수 조회하는 쿼리
select count(*) as 리뷰수 from review
	join `option` on re_op_num = op_num
-- 	join product on op_pr_code = pr_code
--     where pr_name = 'KH무선마우스';
where op_pr_code = (select pr_code from product where pr_name = 'KH무선마우스');

-- 제품별 리뷰 개수를 조회하는 쿼리 (리뷰가 등록된 제품만 조회됨. ABC002 누락)
select
	op_pr_code as 제품코드,
	count(*) as 리뷰수
from review
	join `option` on re_op_num = op_num
	group by op_pr_code;
    
-- 제품별 옵션의 개수를 조회하는 쿼리 (제품명, 옵션 수 두개가 조회되도록)
select
	pr_name as 제품명,
    count(op_pr_code) as 옵션수
from product
	join `option` on pr_code = op_pr_code
    group by op_pr_code;
    
-- 제품별 판매량(반품,환불 제외)을 조회하는 쿼리 (제품명, 판매량)
select
		pr_name as 제품명,
		ifnull(sum(ol_amount),0) as 판매량
from product
	join `option` on op_pr_code = pr_code
    left join order_list on ol_op_num = op_num
    left join `order` on or_num = ol_or_num
    where or_state is NULL or or_state not in('반품','환불')
    group by pr_code;
    
-- 제품 옵션별 판매량(반품,환불 제외)을 조회하는 쿼리 (제품명, 옵션명, 판매량)
select
	pr_name as 제품명,
    op_name as 옵션명,
    ifnull(sum(ol_amount),0) as 판매량
from product
	join `option` on op_pr_code = pr_code
    left join order_list on ol_op_num = op_num
    left join `order` on or_num = ol_or_num
    where or_state is NULL or or_state not in('반품','환불')
    group by op_num;

-- 제품 옵션별 판매량(반품,환불 제외)을 조회하는 쿼리 (제품명, 옵션명, 판매량, 총판매금액)
select
	pr_name as 제품명,
    op_name as 옵션명,
    ifnull(sum(ol_amount),0) as 판매량,
    pr_price * ifnull(sum(ol_amount),0) as 총판매금액
from product
	join `option` on op_pr_code = pr_code
    left join order_list on ol_op_num = op_num
    left join `order` on or_num = ol_or_num -- null인 항목이 있어서 innerjoin(X)
    where or_state is NULL or or_state not in('반품','환불')
    group by op_num;
    
-- 옵션별 리뷰수를 조회하는 쿼리 (제품명, 옵션명, 리뷰수)
select 
	pr_name as 제품명,
    op_name as 옵션명,
    count(re_num) as 리뷰수
from review
	right join `option` on re_op_num = op_num -- 리뷰가 등록안된 제품 모두확인 : right join
    join product on op_pr_code = pr_code -- code에는 null이 없어서 다음 innerjoin 가능
    group by op_num;
