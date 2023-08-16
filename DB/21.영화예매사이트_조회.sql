-- 영화 오펜하이머에 출연한 감독과 배우들을 조회하는 쿼리
/*
select
	mo_title as '영화제목',
    fp_name as '영화인',
    ro_role as '역할'
*/
select * from film_person
	join role on fp_num = ro_fp_num
    join movie on mo_num = ro_mo_num
    where mo_title = '오펜하이머';

-- 영화 오펜하이머의 기본정보를 조회하는 쿼리(제목,영어제목,개봉일,러닝타임,줄거리,연령,예매율)
SELECT 
    mo_title as 제목,
    mo_title_eng as 영문제목,
    mo_opening_date as 개봉일,
    mo_running_time as 러닝타임,
    mo_plot as 줄거리,
    mo_ag_name as 연령제한,
    concat(mo_reservation_rate,'%') as 예매율
FROM
    movie
WHERE
    mo_title = '오펜하이머';
    
-- 영화 오펜하이머의 트레일러와 스틸컷 파일 개수를 조회하는 쿼리
SELECT 
	mo_title as '영화제목',
	fi_state as '타입',
    COUNT(*) as '개수'
FROM
    `file`
        JOIN
    movie_file ON fi_num = mf_fi_num
        JOIN
    movie ON mf_mo_num = mo_num
WHERE
    mo_title = '오펜하이머'
    group by fi_state;
    

-- abc회원의 예매 내역을 조회하는 쿼리(영화명, 시간, 좌석명) 
SELECT 
    MO_TITLE AS 영화제목, MS_START_TIME AS 상영시간, SE_NAME AS 좌석
FROM
    RESERVATION
        JOIN
    RESERVATION_LIST ON RL_RV_NUM = RV_NUM
		JOIN
	SEAT ON RL_SE_NUM = SE_NUM
		JOIN
	MOVIE_SCHEDULE ON MS_NUM = RV_MS_NUM
		JOIN
	MOVIE ON MO_NUM = MS_MO_NUM
WHERE RV_ME_ID = 'abc123';

-- abc회원의 예매 내역을 조회하는 쿼리(영화명, 시간, 성인 X명, 청소년 X명) 
SELECT 
    MO_TITLE AS 영화제목, MS_START_TIME AS 상영시간, 
    SUM(RV_ADULT) AS 성인수, SUM(RV_TEENAGER) AS 청소년수
FROM
    RESERVATION
		JOIN
	MOVIE_SCHEDULE ON MS_NUM = RV_MS_NUM
		JOIN
	MOVIE ON MO_NUM = MS_MO_NUM
WHERE RV_ME_ID = 'abc123'
GROUP BY RV_NUM;

-- CGV강남 영화관에서 콘크리트 유토피아 20:50에 예매 가능한 좌석을 조회하는 쿼리
SELECT 
    SE_NAME
FROM
    SEAT
        JOIN
    SCREEN ON SE_SC_NUM = SC_NUM
		JOIN
	MOVIE_SCHEDULE ON MS_SC_NUM = SC_NUM
WHERE
	MS_NUM = 8 AND SE_NUM NOT IN(
	SELECT RL_SE_NUM FROM RESERVATION
		JOIN RESERVATION_LIST ON RL_RV_NUM = RV_NUM
		WHERE RV_MS_NUM = 8
    );

-- CGV강남 영화관에서 콘크리트 유토피아 20:50에 예매 가능한 좌석을 조회하는 쿼리(OUTER JOIN 이용)
SELECT 
    SE_NAME
FROM
    SEAT
        JOIN
    SCREEN ON SE_SC_NUM = SC_NUM
		JOIN
	MOVIE_SCHEDULE ON MS_SC_NUM = SC_NUM
		JOIN
	RESERVATION ON RV_MS_NUM = MS_NUM
		LEFT JOIN -- 예약과 예약 리스트를 JOIN하는게 아니라 예약 리스트와 좌석을 JOIN
	RESERVATION_LIST ON SE_NUM = RL_SE_NUM
WHERE
	MS_NUM = 8 AND RL_SE_NUM IS NOT NULL;

-- 위의 예시 이용하여 예약가능 여부 탭을 같이 보여주는 쿼리
SELECT 
    SE_NAME as '좌석 번호',
    case when rl_se_num is null then 'O'
    else 'X' end as '예약가능여부'
FROM
    SEAT
        JOIN
    SCREEN ON SE_SC_NUM = SC_NUM
		JOIN
	MOVIE_SCHEDULE ON MS_SC_NUM = SC_NUM
		JOIN
	RESERVATION ON RV_MS_NUM = MS_NUM
		LEFT JOIN -- 예약과 예약 리스트를 JOIN하는게 아니라 예약 리스트와 좌석을 JOIN
	RESERVATION_LIST ON SE_NUM = RL_SE_NUM
WHERE
	MS_NUM = 8;

-- abc123 회원이 관람했던 영화 목록을 조회하는 쿼리
SELECT 
   mo_title as '관람 영화'
FROM
    reservation
        JOIN movie_schedule ON ms_num = rv_ms_num
		join movie on ms_mo_num = mo_num
where rv_me_id = 'abc123' and now() >= concat(ms_date, '', ms_start_time) -- 현재 시간이 영화 상영시간 이후
group by mo_num; -- group by 해야만 같은 영화 여러번 봐도 한번만 출력됨

-- 예약 가능한 모든 상영 영화정보를 조회하는 쿼리
SELECT 
    mo_title as 영화제목, ms_date as 상영일,
    ms_start_time as 시작시간, mo_ag_name as 연령제한
FROM
    movie_schedule
        JOIN movie ON ms_mo_num = mo_num
WHERE now() < concat(ms_date, ' ', ms_start_time)
AND ms_possible_seat > 0;
        
-- CGV 이벤트로 한 영화를 가장 많이 본 회원 3명을 뽑는다.
-- 회원마다 영화를 몇번 관람했는지 조회하는 쿼리
SELECT 
   mo_title as 영화, rv_me_id as 아이디, count(rv_num) as 관람횟수
FROM
    reservation
		JOIN movie_schedule ON rv_ms_num = ms_num
        JOIN movie ON ms_mo_num = mo_num
WHERE now() >= concat(ms_date, ' ', ms_start_time)
GROUP BY rv_me_id, ms_mo_num;
        
-- 회원들 중 금액 사용이 가장 많은 3명의 회원 조회하는 쿼리
-- 사용 금액이 같은 회원이 여러명일 때, 누구는 순위 포함 누구는 포함안될 수 있음
SET GLOBAL sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));
SELECT 
	me_id as 회원,
    sum(case
		when now() >= concat(ms_date, ' ', ms_start_time)
		THEN rv_price ELSE 0
		END) as 누적금액
FROM
    reservation
		JOIN movie_schedule ON rv_ms_num = ms_num
        RIGHT JOIN member ON rv_me_id = me_id
GROUP BY rv_me_id -- group by 안해주면 총금액이 아닌 각각 단일 예약값만 출력됨
ORDER BY 누적금액 DESC
LIMIT 3;

-- 또는
/* 순위를 매기는 쿼리
 - row_number() over(order by 속성 속성방법) : 예로, 4명 중 1등 점수가 3명으로 중복되어도 1,2,3,4위로 나열
 - rank() over(over(order by 속성 속성방법) : 예로, 4명 중 1등 점수가 3명으로 중복시, 1위가 3명 4위 1명
 - dense_rank() over(over(order by 속성 속성방법) : 예로, 4명 중 1등 점수가 3명으로 중복시, 1위가 3명 2위 1명
*/
-- 사용 금액 같은 회원이 여러명일 때, 아래 쿼리는 여러명 모두 등수에 포함시 모두 받는다.
SELECT *
FROM (SELECT 
		ME_ID AS 아이디,
		누적금액,
		RANK() OVER(ORDER BY 누적금액 DESC) AS 순위
		FROM(SELECT *,
			 SUM(CASE
             WHEN NOW() >= CONCAT(MS_DATE, ' ', MS_START_TIME)
             THEN RV_PRICE
             ELSE 0
			 END) AS 누적금액
	FROM
		RESERVATION
			JOIN MOVIE_SCHEDULE ON RV_MS_NUM = MS_NUM
			RIGHT JOIN MEMBER ON RV_ME_ID = ME_ID
			GROUP BY RV_ME_ID
		) AS A
	) AS B
WHERE 순위 <= 3;

-- 영화인별로 배우로 참여한 영화 개수를 정리하는 쿼리
SELECT
	fp_name as 영화인, ifnull(count(ro_num),0) as '참여영화수(배우)'
FROM  film_person
	LEFT JOIN 
		(SELECT * FROM role where ro_role = '배우')
		AS role2 ON ro_fp_num = fp_num
GROUP BY fp_num;


-- 각 스케쥴별로 예약한 좌석 조회하는 쿼리
SELECT 
	mo_title as 영화,
	ms_date as 상영일,
	ms_start_time as 상영시간,
    sc_total_seat - ms_possible_seat as 예약좌석수
FROM movie_schedule
	JOIN screen ON ms_sc_num = sc_num
	JOIN movie ON ms_mo_num = mo_num;
    
-- 영화관별 상영 영화목록 보여주는 쿼리
SELECT
	mo_title as 영화,
    th_name as 영화관,
    ms_date as 상영일,
	ms_start_time as 상영시간
FROM theater
	JOIN screen ON sc_th_num = th_num
	JOIN movie_schedule ON ms_sc_num = sc_num
    JOIN movie ON ms_mo_num = mo_num
WHERE now() < concat(MS_DATE, ' ', MS_START_TIME)
GROUP BY th_num, ms_mo_num;


-- 오펜하이머를 상영하는 영화관 보여주는 쿼리
SELECT
    th_name as 영화관
FROM theater
	JOIN screen ON sc_th_num = th_num
	JOIN movie_schedule ON ms_sc_num = sc_num
    JOIN movie ON ms_mo_num = mo_num
WHERE now() < concat(MS_DATE, ' ', MS_START_TIME) AND mo_title = '오펜하이머'
GROUP BY th_num, ms_mo_num;


