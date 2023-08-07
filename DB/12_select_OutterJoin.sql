/*
- INNER JOIN : 두 테이블이 외래키로 연결시, 양쪽 모두 데이터가 있는 경우
- OUTER JOIN : 두 테이블이 외래키로 연결시, 한쪽 기준 연결할 때 사용
	ㄴ LEFT JOIN : 기준 테이블 기준 연결
    ㄴ RIGHT JOIN: 참조 테이블 기준 연결

A left join B == B right join A

ex. 상품별 리뷰 수 조회하기 (리뷰 등록 없는 상품들은 INNER JOIN의 경우 리뷰수 알 수 없음)
- outer join 문법을 쓸 경우, 기준테이블이 매우 중요. 
	inner join은 A join B, B join A가 같다.
    outer join은 A outer join B와 B outer join A의 결과가 다르다.
    
select * from 기준테이블
	join 참조테이블
    on 기준테이블.외래키 = 참조테이블.기본키
[where절]
[group by절]
[having절]
[order by절]
[limit절]
*/
select
	op_pr_code as 제품코드,
	count(re_num) as 리뷰수
from review
	right join `option` on op_num = re_op_num
	group by op_pr_code;