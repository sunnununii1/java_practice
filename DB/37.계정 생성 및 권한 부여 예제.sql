/*
계정 생성 : 권한이 있는 계정만 다른 계정을 생성할 수 있다.

create user '아이디'@'접근방법' identified by '비번';

- 접근방법 : localhost와 %
	ㄴ localhost : 내부 IP에서만 접근 가능하도록 설정
    ㄴ % : 외부 IP에서도 접근 가능하도록 설정
*/
create user 'test'@'localhost' identified by '1234';

/*
권한부여 : 계정에 DB및 테이블에 접근할 수 있는 권한을 설정
- 어떤 DB에 접근할 수 있게 할 건지
- 어떤 테이블에 접근할 수 있게 할 건지
- 어떤 작업(insert,update,delete,selcet)을 수행할 수 있게 할 건지

모든 작업을 수행할 수 있는 권한 부여하는 방법
grant all privileges on DB명.테이블명 to '아이디'@'접근방법';
*/
grant all privileges on test.* to 'test'@'localhost';
