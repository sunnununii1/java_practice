/*
- 함수
하나의 작업을 하도록 구성 => 예매에 데이터를 추가만 함
매개변수 : 값을 사용(매개변수 값 변경 못함)
반환값 : 무조건 1개는 있어야 함
반드시 리턴값이 있기 때문에 select문에서 사용 가능 (sum,count 등)
*/
/*
- 프로시저
일련의 작업을 하도록 구성 => 예매에 데이터 추가, 예매 리스트에 데이터 추가, 스케쥴에 예매가능좌석 업뎃, 영화 예매율 업뎃
매개변수 : 값을 사용, 값을 반환 OUT, 사용과 반환 INOUT
반환값 : 없음. 대신 매개변수 이용하여 OUT/INOUT인 매개변수에 반환값 전달할 수 있음
select문에서 사용 불가능


delimiter // : 문장의 끝을 '//' 로 마무리하겠다는 뜻 (// 말고 다른 기호도 가능)

create procedure 프로시저명 (
[
in|out|inout 변수명 변수타입
]
)
begin
	-- 변수 선언방법. 상단에 변수 선언 모아야 함
	declare 변수명 변수타입;
    declare 변수명 변수타입 default 기본값;
    
    -- 변수값 변경
    set 변수값 = 값;
    
    -- if문
    if 조건식 then
		실행문;
	elseif 조건식2 then
		실행문2;
    else
		실행문3;
    end if;
end //
delimiter ;

-- 프로시저 호출
call 프로시저명(매개변수들);
*/

-- 숫자가 주어지면 숫자 앞에 0을 붙여 최대 5자리로 된 숫자 만드는 프로시저

drop procedure if exists zero_num;

delimiter //
create procedure zero_num(
in_num int
)
begin
	declare _res char(5);
    set _res = (select lpad(_num, 5, '0'));
    select _res;
end //
delimiter ;
call zero_num(123);
