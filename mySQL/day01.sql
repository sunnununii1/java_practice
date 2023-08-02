/*
물리적 설계
1. DB(스키마)를 생성
2. 테이블(릴레이션)을 생성
3. 데이터를 추가

SQL : Structred Query Language
DDL(데이터 정의어) : 테이블/DB를 추가,수정,삭제
*DML(데이터 조작어) : 데이터 추가,수정,조회
DCL(데이터 제어어) : 계정에 사용권한을 부여,회수
TCL(트랜잭션 제어어): 작업을 묶어서 DML의 결과를 작업단위별로 묶어 제어
*/
/*
DDL
- create : 테이블/DB를 생성
- alter : 테이블/DB를 수정
- drop  : 테이블/DB를 삭제
- truncate: 테이블을 초기화
*/
/*
DB 생성 : MYSQL에선 DB와 스키마가 같다고 인식됨.
create schema DB명;
create database DB명;
drop schema DB명;
drop database DB명;

if not exists DB명 : DB명이 존재하지 않을 때 작업
if exists DB명 : DB명이 존재할 때 작업
*/
create schema if not exists course;
-- drop schema if exists course;
/*
use DB명 : DB명을 선택. 워크벤치에선 해당 DB 더블클릭시 글자 두껍게.
*/
use course;
/*테이블 생성
- auto_incerement는 기본키에만 설정 가능
- 테이블당 최대 1개만 설정 가능
- default는 not null인 경우 기본값을 설정할 때 사용
- check는 데이터 추가 때, 조건이 안 맞으면 추가 못하게 할 때 사용
create table 테이블명(
	속성명1 타입 [default 값] [not null | null] [auto_incerement],
    속성명2 타입 [default 값] [not null | null].
    primary key(속성명), --기본키 설정
    foreign key(속성명) references 테이블명(속성명),
    check(조건)
);
*/
-- 대학생(학번, 이름, 학과)
create table if not exists student(
	num char(10) not null,
    name varchar(20) not null,
    major varchar(20) not null,
    primary key(num)
);
-- 과목(과목코드, 과목명, 학점, 시수)
-- 과목코드 앞 3자리는 종류, 뒤 3자리는 숫자(ex.MSC001)를 나타냄
create table if not exists subject(
	code char(6) not null,
    title varchar(20) not null,
    point int not null default 0,
    time int not null default 0,
    primary key(code)
);
-- 수강(수강번호,과목번호(FK),학번(FK),강의실,교수,시간표,연도,학기)
create table if not exists `course`.`course`(
	num int not null auto_increment,
    subject_code char(6) not null,
    student_num char(10) not null,
    room varchar(20) not null default '',
    professor_name varchar(20) not null default '',
    schedule varchar(20) not null default '',
    year int not null,
    seme varchar(10) not null default '1',
    primary key(num),
    foreign key(subject_code) references subject(code),
    foreign key(student_num) references student(num)
);
