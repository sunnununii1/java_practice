/*
대표적으로 많이 사용되는 타입
- tinyint : 1바이트, 정수, -128~127까지, 논리형 값 저장시 사용(0:false, 그외:true)
- int : 4바이트, 정수, 약 -21억~21억까지
- bigint : 8바이트, 정수, 약 -900경~900경
- float/double : 4/8바이트, 실수 

문자
- char(n) : 고정된 n자리 문자열
- varchar(n) : 최대 n자리 문자열
- longtext : 최대 4GB 크기 문자열
- longblob : 최대 4GB 크기의 2진 데이터

날짜 (문자열처럼 사용,비교 가능)
- date : 년-월-일 (current_timestamp 사용불가)
- datetime : 년-월-일 시:분:초 , now()를 통한 초기값 설정 가능
	- now() : 현재시간 알려주는 함수 (current_timestamp와 같다)
*/