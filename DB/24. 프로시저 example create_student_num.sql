-- 입학년도, 학과코드, 순서가 주어졌을 때 학번을 생성해서 select로 출력하는 프로시저를 작성

drop procedure if exists create_student_num;

delimiter //
create procedure create_student_num(
in _year int,
in _dep_code char(3),
in _order_num int
)
begin
	declare _order_char char(3); -- 순서에 0 채운 문자열
    declare _student_num char(10); -- 최종학번
    
    set _order_char = (select lpad(_order_num, 3, '0'));
    -- concat : 문자열 이어붙이기
    set _student_num = concat(_year, _dep_code, _order_num);
    select _student_num;
end //
delimiter ;

call create_student_num(2023,"135",4);