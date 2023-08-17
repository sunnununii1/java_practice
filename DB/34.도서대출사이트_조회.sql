-- 예약가능한 도서를 조회하는 쿼리
select * from book where bo_possible_reservation = 
	(select bs_num from book_state where bs_desc = '예약 가능');


-- 대출가능한 도서 조회하는 쿼리
select * from book where bo_possible_loan = (select bs_num
		from
			book_state
		where
			bs_desc = '대출 가능')
and bo_possible_reservation in (select bs_num
		from
			book_state
        where
			bs_desc != '예약 중');


-- qwe123회원이 대출 가능한 도서를 조회하는 쿼리
select book.* from book
	left join
		reservation on bo_num = re_bo_num
where
    bo_possible_loan = (select bs_num from book_state where bs_desc = '대출 가능')
and
	(re_num is null or re_me_id = 'qwe123');
    

-- qwe123회원이 현재 대출한 도서를 조회하는 쿼리
select * from book
	join loan on bo_num = lo_bo_num
    where lo_me_id = 'qwe123' and lo_return_date is null; -- 반납을 하기 전

-- 전체 회원의 대출 불가능 기간을 조회하는 쿼리.
-- 대출가능한 회원은 대출가능으로 표시, 불가능한 회원은 언제까지 불가능한지 표시하도록 함
select
	me_id as 아이디, case
		when me_apply_overdue is null
		then '대출 가능' else me_apply_overdue end as 대출불가일
from member;

-- 전체 도서의 대출 횟수를 조회하는 쿼리
select bo_title as 책이름, count(lo_num)
from book
	left join loan on bo_num = lo_bo_num
group by bo_title;
    

-- 전체 회원의 연체 회수를 조회하는 쿼리
select me_id as 아이디, count(lo_expected_date < lo_return_date) as 연체횟수
from member 
	left join loan on me_id = lo_me_id
group by me_id;

-- 도서를 가장 많이 대여한 회원 1명을 조회하는 쿼리
select me_id as 아이디, count(lo_num) as 대출도서수
from member
	left join loan on me_id = lo_me_id
group by me_id
order by 대출도서수 desc
limit 1; 