/*
< SELECT >
select문 기본
select 속성명1, ..., 속성명n from 테이블명;
=> 테이블에서 속성명1, ..., 속성명n의 값들을 조회할 거란 코드임
=> 전체 조회 위해선 *을 이용한다.

as : 속성 또는 테이블명을 일시적으로 변경해 사용하게 해주는 키워드
속성명1 as 속성명2 => 속성명1을 일시적으로 속성명2로 바꾸어 사용
*/
use course;
-- 등록된 모든 학생의 모든 정보를 조회하는 쿼리
select * from student;
-- 등록된 모든 학생의 학번만 조회하는 쿼리 (두개 다 가능)
-- select num from student;
select num as '학번' from student;

/*
select 속성명1, ..., 속성명n from 테이블명 where 조건식;
=> 조건식을 만족하는 행(투플)들만 검색 후 해당 행에 속성1, ..., 속성n의 정보를 조회
where절
속성명1 = 값1 or 속성명2 = 값2 and 속성명3 = 값3

- WHERE절 사용연산자
 = : 같다. null과 비교불가
 != : 같지않다. null과 비교불가
 <> : 같지않다. null과 비교불가
 and : ~하고. 자바에서 &&와 같음
 or : ~하거나. 자바에서 ||
 is null : null인지 확인함
 is not null : null이 아닌지 확인함
 like : 와일드카드와 함께 사용, 값이 있는 와이드가 포함된 문자열과 같은지 비교 위함
	ㄴ 와일드 카드
	 _ : 한글자 의미
     % : 0글자 이상을 의미
 속성명 between A and B : 속성값이 A이상 B이하인 조건 만족시
 => 속성명 >= A and 속성명 <= B
 속성명 in(값1, 값2, ..., 값n) : 속성값이 값1이거나 값2거나.. 값n인 조건 만족시
 => 속성명 = 값1 or 속성명 = 값2 or... or 속성명 = 값n
*/
/*
distinct : 중복된 결과 제거 후 조회
select distinct 속성명 from 테이블명;
*/
/*
- ANY
where 속성명 비교연산자(=,>=,<=,!=,<,>) any(서브쿼리);
=> 속성이 서브쿼리 결과와 비교연산시 서브쿼리 결과 중 하나라도 만족하면 조회
where 속성명 = any(서브쿼리)
=> where 속성명 in(서브쿼리)  -- 로 변경 가능!

- SOME은 ANY와 같다.

- ALL
where 속성명 비교연산자(>=,<=,!=,<,>) all(서브쿼리);
=> 속성이 비교연산시 모든 서브쿼리 결과가 만족하면 조회
*/
/*
- ORDER BY : 정렬해준다
- order by는 where절과 group by절 뒤에! 위치해야 함.
=> order by 속성명1 [정렬방법] [,속성명2 정렬방법, ...]
=> 속성명1을 정렬방법 기준으로 정렬, 속성명1 값이 같으면 속성명2를 정렬방법 기준으로 정렬함
- 정렬방법
	- ASC : 오름차순(기본값). 작은값>큰값 순
    - DESC : 내림차순. 큰값>작은값 순
*/
/*
- LIMIT : 행(투플)을 원하는 위치부터 원하는 개수를 가져오기 위한 방법
- 전체 검색결과가 아닌, 일부만 가져올 때 사용
- 위치가 order by절 뒤, 제일 마지막에 위치함
limit A; => 0번지부터 A개를 가져옴
limit A, B; => A번지부터 B개를 가져옴
*/
/*
- GROUP BY절 : 같은 값을 가지는 행들을 묶어 평균 구함 또는 개수 세어 작업할 때 사용
-  HABING절 : 집계함수에 조건을 덜 때 사용
둘 다 위치는 where 뒤, order by 앞.
자주 사용하는 집게함수
	ㄴ avg(속성 또는 식) :  평균
    ㄴ min(속성 또는 식) : 최소값
    ㄴ max(속성 또는 식) : 최대값
    ㄴ count(속성) : 행(투플)의 개수
    ㄴ count(distinct 속성) : 중복 배체한 행의 개수
    ㄴ sum(속성 또는 식) : 합
    
*/

-- 컴퓨터공학과 학생들 전체를 조회하는 쿼리
-- (ctrl + B) : 가독성 위해 자동 줄 띄움됨
SELECT 
    *
FROM
    student
WHERE
    major = '컴퓨터공학과';
-- 컴퓨터공학과가 아닌 학생들을 조회하는 쿼리 (!=, <> 같음)
select * from student where major != '컴퓨터공학과';
select * from student where major <> '컴퓨터공학과';
-- 학번이 2023135001인 학생이 듣는 수강정보를 조회하는 쿼리
select * from course where student_num = '2023135001';
-- 학점이 3학점인 과목의 과목명을 조회하는 쿼리
select title from subject where point = '3';

-- 이름이 3자인 학생 정보를 조회하는 쿼리 (like)
select * from student where name like '___';
-- 성이 '유'씨인 학생 정보를 조회하는 쿼리
select * from student where name like '유__'; -- 성이 유씨이며, 3글자
select * from student where name like '유%'; -- 성이 유씨. 글자수 무관 => 더 정확함!
-- 학생의 학번은 입학년도 4자 + 학과코드 3자 + 번호 3자임
-- 23학번의 학생을 조회하는 쿼리
select * from student where num like '2023%';
-- 방송학과 코드는 135이다. 이를 이용해 방송학과 학생만 조회하는 쿼리
select * from student where num like '____135%';

-- 학점이 2학점 이상 3학점 이하인 과목을 조회하는 쿼리 (between..and)
select * from subject where point between 2 and 3;
select * from subject where point >=2 and point <=3;

-- 이순신 교수님과 한석봉 교수님이 강의하는 수강정보를 조회하는 쿼리 (in)
select * from course where professor_name in('이순신','한석봉');

-- 2023년에 수강하는 과목들의 과목 코드를 조회하는 쿼리 (distinct)
select distinct subject_code from course where year = 2023;
-- 과목명이 글쓰기인 과목의 수강 정보를 조회하는 쿼리 (서브쿼리)
select * from course where subject_code
	= (select code from subject where title = '글쓰기');

-- 학점이 2학점 또는 3학점 이상인 과목의 수강 정보를 조회하는 쿼리 (서브쿼리 any)
select * from course where subject_code
	= any(select code from subject where point in(2,3));
    
-- 글쓰기와 영어가 아닌 모든 과목의 수강 정보를 조회하는 쿼리(서브쿼리 all, in)
select * from course where subject_code 
	!= all(select code from subject where title in('글쓰기','영어'));
select * from course where subject_code 
	in(select code from subject where title !='글쓰기' and title !='영어');

-- 학생 정보를 이름순으로 오름차순으로 정렬하여 조회하는 쿼리 (asc는 기본값이라 선택)
select * from student order by name;
-- 학생 정보를 이름순으로 내림차순으로 정렬하여 조회하는 쿼리 (위치 중요)
select * from student order by name desc;
-- 학생 정보를 전공, 이름 순으로 오름차순 정렬해 조회하는 쿼리
select * from student order by major, name;

-- 학생들이 소속된 과를 중복없이 조회하는 쿼리
select distinct major from student;

-- 학생 정보를 학번순으로 오름차순 정렬 후, 위에서 2명의 학생 정보를 조회하는 쿼리 (limit)
select * from student order by num asc limit 2;
-- 학생 정보를 학번순으로 오름차순 정렬 후, 3번째와 4번째의 학생 정보를 조회하는 쿼리 (limit)
select * from student limit 2, 2;
-- 학생 정보를 학번순으로 오름차순 정렬 후, 2명씩 보이는 3번째 페이지의 학생 정보 조회 쿼리
select * from student limit 4, 2;

-- 각 과별 학생 수 조회하는 쿼리(group by)
set global sql_mode = (select replace(@@sql_mode,'only_full_group_by','')); -- 기능줄
select major as 학과, count(num) as 학생수 from student group by major;
-- 과목별 수강 학생 수를 과목코드, 수강생 수로 조회하는 쿼리(group by)
select subject_code, count(*) as '수강생 수' from course group by subject_code;
-- 과목별 수강생 수가 4명 이상인 과목의 과목 코드를 조회하는 쿼리(having)
SELECT 
    subject_code, COUNT(*) AS '수강생 수'
FROM
    course
GROUP BY
	subject_code
having
	count(*) >= 4;
