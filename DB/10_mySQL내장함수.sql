/*
- if(속성, 참, 거짓)

- ifnull(속성, 값) : 속성값이 null이 아니면 속성값을 이용, null이면 값을 이용

- case when 조건1 then 값1 when 조건2 then 값2 else 값3 end
  : 조건1이 참이면 값1을, 조건2가 참이면 값2를, 아니면 값3을 이용
  
- instr(기준문자열, 찾을문자열)
  : 기준문자열에서 찾을 문자열이 몇번째에 있는지 알려줌(1부터 시작). 없으면 0
  
- format(숫자, 소수점자리수)
  : 숫자(실수 포함)를 소수점 자리까지 표현, 정수 부분은 3개 단위로 ,추가 (ex.금액)
  
- right/left(문자열, 숫자)
  : 문자열 중 오른쪽/왼쪽에서 숫자 개수만큼 문자열 추출. 오른쪽/왼쪽 기준 고정길이의 문자열 추출시 유용

- lpad/rpad(문자열, 숫자, 채울문자열)
  : 문자열에 채울 문자열을 왼쪽 또는 오른쪽에 채워서 숫자 개수만큼 길이가 되도록 함
  
- replace(문자열, 원래문자열, 바꿀문자열)
  : 문자열에서 원래문자열을 찾고, 있다면 바꿀문자열로 수정

- substring(문자열, 시작위치, 길이)
  : 문자열에서 시작위치부터 길이만큼 찾아서 반환. 길이 생략시 시작위치부터 끝까지 반환
  
- now(), current_timestamp();, sysdate();
  : 현재시간을 년-월-일 시:분:초 로 알려줌
  
- adddate(날짜, 차이) / subdate(날짜, 차이)
  : 날짜로부터 차이만큼 더한/뺀 날짜
  => 이때, 차이는 interval 숫자단위(day,month,year,hour, minute, second)
  
- addtime(날짜, 차이) / subtime(날짜, 차이)
  => 여기서 차이는 yyyy-MM-dd hh:mm:ss 임
  
- datediff(날짜1, 날짜2)
  : 날짜1과 날짜2의 차이를 일 기준으로 반환 (날짜1 - 날짜2)
- timediff(날짜1, 날짜2)
  : 날짜1과 날짜2의 차이를 시,분,초로 반환 (날짜1 - 날짜2)
*/

-- 컴퓨터공학과이면 컴공으로, 아니면 컴공아님으로 이름을 바꾸는 쿼리 (if)
select num as 학번, if(major = '컴퓨터공학과','컴공','컴공아님') as 전공 from student;
-- null을 0으로 바꾸는 쿼리 (ifnull)
select title as 과목명, ifnull(time, 0) as 시수 from subject;
-- 과 이름을 '방송'과 '컴공'으로, 그 외는 기타로 바꾸는 쿼리 (case..)
select num as 학번, case
	when major = '방송학과' then '방송'
    when major = '컴퓨터공학과' then '컴공'
    else '기타'
	end as 학과
from student;
-- '개론'이 들어간 수업 이름이 몇번째에 있는지 조회하는 쿼리 
select instr(title, '개론') as 대학위치, title from subject;

select format(1000000,0);
-- 23학번 학생 조회
select * from student where left(num, 4) = 2023;

select lpad(1, 3, '0');
-- hello 중 h를 H로 바꾸는 쿼리
select replace('hello', 'h', 'H');
-- 영문장에서 1번째 시작해 6번째 글자까지만 출력하는 쿼리
select substring('Hello. My name is xxx.', 1, 6);
select adddate(now(), interval 1 day);
select adddate(now(), interval 1 month);
select adddate(now(), interval 1 year);
select subdate(now(), interval 1 day); -- 하루 전
select addtime(now(), '1 0:0:0'); -- 현재시간 기준 하루 다음 날짜

select datediff('2023-08-05 14:00:00', '2023-08-02 13:00:00'); -- 3일 차이
select timediff('2023-08-05 14:00:00', '2023-08-02 13:00:00'); -- 73시간 차이