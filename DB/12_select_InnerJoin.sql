/*
- JOIN 문법
: 2개 이상 테이블 묶어 하나의 테이블 만드는 것 (**데이터 무결성 위해 나눠 저장함)

-- 테이블1의 외래키가 테이블2의 기본키를 참조하는 경우
-- JOIN은 일반적으로 외래키-기본키 연결하나, 가끔 외래키가 아닌 속성을 기본키와 연결하기도 함   
SELECT
	테이블1.속성명1, 테이블1.속성명2, ..., 테이블2.속성명1, 테이블2.속성명2, ...
FROM
	테이블1
INNER JOIN | LEFT JOIN | RIGHT JOIN -- INNER조인, OUTER조인 둘 다 가능
	테이블2
ON
	테이블1.외래키 = 테이블2.기본키
[WHERE 절]
[GROUP BY절]
[HAVING절]
[ORDER BY절]
[LIMIT절]
*/
SELECT 
    COURSE.*, TITLE
FROM
    COURSE
JOIN
	SUBJECT
ON
	SUBJECT_CODE = CODE;

-- 대학물리를 수강하는 학생들 수를 조회하는 쿼리 
SELECT 
    SUBJECT_CODE AS 과목코드, COUNT(*) AS 수강생수
FROM
    COURSE
WHERE
    SUBJECT_CODE IN (SELECT 
            CODE
        FROM
            SUBJECT
        WHERE
            TITLE = '대학물리')
GROUP BY SUBJECT_CODE;
SELECT 
	SUBJECT_CODE AS 과목코드, COUNT(*) AS 수강생 
FROM 
	COURSE
JOIN
	SUBJECT
ON 
	SUBJECT_CODE = CODE
WHERE
	TITLE = '대학물리'
GROUP BY SUBJECT_CODE;

-- 유재석 학생이 수강하는 과목의 수를 조회하는 쿼리 
SELECT 
	STUDENT_NUM AS 유재석학번, COUNT(*) AS 수강과목수
FROM 
	COURSE 
WHERE 
	STUDENT_NUM = (SELECT NUM FROM STUDENT WHERE NAME='유재석')
GROUP BY STUDENT_NUM;
SELECT 
	STUDENT_NUM AS 유재석학번, COUNT(*) AS 수강과목수 
FROM
	COURSE 
JOIN
	STUDENT
ON
	STUDENT_NUM = STUDENT.NUM 
WHERE
	NAME = '유재석'
GROUP BY STUDENT_NUM;

-- 유재석 학생이 수강하는 과목명을 조회하는 쿼리 
SELECT 
    NAME AS 이름, TITLE AS 수강과목
FROM
    COURSE
        JOIN
    STUDENT ON STUDENT_NUM = STUDENT.NUM
        JOIN
    SUBJECT ON SUBJECT_CODE = CODE
WHERE NAME ='유재석';

-- 이순신 교수님이 강의하는 과목명을 조회하는 쿼리 
SELECT DISTINCT
    TITLE AS 강의명
FROM
    COURSE
        JOIN
    SUBJECT ON SUBJECT_CODE = CODE
WHERE
    PROFESSOR_NAME = '이순신';