/*
이벤트 스케쥴러 : 일정 주기마다 이벤트 발생시켜 등록된 이벤트 실행하기
create event 이벤트명
on schedule every 숫자단위 -- day/hour/minute 등
do
	작업코드; -- 한줄로 된 insert/update/delete나 프로시저 사용
*/
-- 이벤트 스케쥴러의 on/off를 조회하는 쿼리
show variables like 'event%';

use test;
-- 등록된 이벤트 스케쥴러 조회
-- show events;
drop event if exists test_event;

-- 1분 지날 때마다 대시보드 테이블의 멤버 수가 1씩 증가
create event test_event on schedule every 1 minute
do
	update dash_board set db_member = db_member + 1 ;
