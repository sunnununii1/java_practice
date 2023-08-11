-- 입학년도, 학과코드가 주어졌을 때 학번을 생성해서 select로 출력하는 프로시저를 작성
-- 순서는 해당 입학년도와 학과코드를 가진 학생들의 수를 세서 적용한다.

 drop procedure if exists create_student_num2;

delimiter //
create procedure create_student_num2(
in _year int,
in _dep_code char(3),
out _student_num char(10) -- 최종학번
)
begin
	declare _order_char char(3);
    
    set _order_char = (
		select lpad(count(*) + 1, 3, '0')
        from
			student
		where
			num like concat(_year, _dep_code,'%')
	);
    -- concat : 문자열 이어붙이기
    set _student_num = concat(_year, _dep_code, _order_char);
    -- select _student_num;
end //
delimiter ;

set @student_num := 0;
-- 2023135004
call create_student_num2(2023,"135", @student_num);

select @student_num;

