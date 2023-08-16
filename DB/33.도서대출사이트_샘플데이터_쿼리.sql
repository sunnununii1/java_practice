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