-- 도서 상태 샘플 데이터 추가
insert into book_state(bs_desc)
	values('예약가능'),('예약중'),('도서 상태에 의한 예약 불가능'),
    ('대출 가능'),('대출 중'),('도서 상태에 의한 대출 불가능');
    
-- 도서 샘플 데이터를 추가
-- 101.1ABC12 자바의 정석 / 남궁성 / 도우출판, 일반도서(대출/예약가능)
-- 103.987DD Do it! 점프 투 파이썬 / 이지스퍼블리싱 / 박응용, 예약불가도서
-- 500.ABC123 해리포터와 마법사의 돌 / 문학수첩 / J.K 롤링 저자/강동혁 엮은이, 일반도서
insert into book(bo_num, bo_type, bo_title, bo_publisher, bo_author,
bo_possible_loan, bo_possible_reservation)
	values('101.1ABC12', '코딩', '자바의 정석', '도우출판', '저자 : 남궁성', 4, 1),
    ('103.987DD', '코딩', 'Do it! 점프 투 파이썬', '이지스퍼블리싱', '저자 : 박응용', 4, 3),
    ('500.ABC123', '외국 소설', '해리포터와 마법사의 돌', '문학수첩', '저자 : J.K 롤링, 엮은이 : 강동혁', 4, 1);

-- 회원 샘플 데이터 추가
insert into member(me_id, me_pw, me_phone, me_birthday, me_authority)
	values('admin','admin','011-1234-5678','2000-01-01','admin'),
    ('qwe123','qwe123','010-1111-2222','2002-02-02','user');

-- qwe123 회원이 자바의 정석을 예약했을 때 적용하는 쿼리
insert into reservation(re_reservation_date, re_me_id, re_bo_num)
	select date_format(now(),'%Y-%m-%d'),'qwe123', bo_num from book where bo_title = '자바의 정석';

update book
	set bo_possible_reservation = (select
			bs_num
		from
			book_state
		where
			bs_desc = '예약 중')
	where
		bo_num = '101.1ABC12'; -- update하는 테이블(book)에서 조회 값을 가져올 수 없어서 num으로
    
    
-- qwe123회원이 예약한 자바의 정석을 대출했을 때 적용하는 쿼리
 -- 1. loan 테이블에 추가
insert into loan(lo_date, lo_me_id, lo_bo_num, lo_expected_date)
	select date_format(now(),'%Y-%m-%d'), 'qwe123', bo_num,
		   date_format(date_add(now(), interval 14 day),'%Y-%m-%d')
	from book where bo_title = '자바의 정석';
    
 -- 2. 예약 삭제
delete from reservation where re_me_id = 'qwe123'
and re_bo_num =(select bo_num from book where bo_title = '자바의 정석');

 -- 3. book 테이블에 대출상태,예약상태 바꾸기
update book
set
	bo_possible_loan = 
		(select bs_num from book_state where bs_desc = '대출 중'),
	bo_possible_reservation =
		(select bs_num from book_state where bs_desc = '예약 가능')
where
	bo_num = '101.1ABC12';

 -- 4. member 테이블에 대출권수 바꾸기
 update member
 set
	me_book_count = me_book_count + 1
where
	me_id = 'qwe123';


-- qwe123회원이 자바의 정석을 반납했을 때 필요한 쿼리
 -- 1.대출 테이블에 반납일 기입
update loan
set lo_return_date = date_format(now(),'%Y-%m-%d')
where lo_me_id = 'qwe123'
	and lo_bo_num = (select bo_num from book where bo_title = '자바의 정석');

 -- 2.도서 테이블에 도서상태 수정
 update book
set
	bo_possible_loan = 
		(select bs_num from book_state where bs_desc = '대출 가능')
where
	bo_num = '101.1ABC12';

 -- 3.회원이 대출한 도서 수 감소
update member set me_book_count = me_book_count - 1
where me_id = 'qwe123';

 -- 4.연체일 계산해서, 멤버테이블 수정
 update member set me_total_overdue = me_total_overdue + (select
    case
		when datediff(lo_return_date, lo_expected_date) < 1 then 0
		else datediff(lo_return_date, lo_expected_date)
	end as 연체일
	from loan
	where lo_me_id = 'qwe123' and lo_bo_num = '101.1ABC12')
 where me_id = 'qwe123';
	
-- 회원이 대출한 모든 도서가 반납됐을 때 연체일 존재시, 다음날부터 연체적용되게 수정
UPDATE member 
SET 
    me_apply_overdue = (SELECT 
            CASE
                    WHEN
                        me_book_count = 0
                            AND me_total_overdue != 0
                    THEN
                        DATE_FORMAT(DATE_ADD(NOW(),
                                    INTERVAL me_total_overdue DAY),
									'%Y-%m-%d')
                    ELSE NULL
                END AS T
        FROM
            (select * from member) as TMP
        WHERE
            me_id = 'qwe123')
WHERE
    me_id = 'qwe123';
