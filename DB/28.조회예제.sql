-- 등록된 영화를 조회하는 쿼리
select * from movie;

-- 장르가 드라마인 영화를 조회하는 쿼리
 SELECT 
    *
FROM movie
	JOIN  movie_genre ON mo_num = mg_mo_num
WHERE mg_ge_name = '드라마';

-- 개봉전인 영화를 조회하는 쿼리
select *
from movie
	join movie_schedule on mo_num = ms_mo_num
where now() < mo_opening_date;

-- 상영 종료된 영화를 조회하는 쿼리 (현재 개봉중인 영화는 오늘 기준 2주 후 상영 종료됨)
-- movie 기준으로해서 left join => 상영종료된 영화는 정보없어서 이너조인시 상영종료된 영화 조회X
select mo_title as 상영종료영화
from movie
	left join movie_schedule on mo_num = ms_mo_num
where mo_opening_date <= now()
having count(ms_num) = 0; -- 집계함수 있는 조건은 where X having O

-- 15세 관람가 영화 조회 쿼리
select * from movie where mo_ag_name = '15세이상관람가';

-- 이병헌 출연한 영화 조회 쿼리
SELECT 
    *
FROM movie
	JOIN role ON ro_mo_num = mo_num
    join film_person on ro_fp_num = fp_num
where fp_name = '이병헌';

-- 2023년에 개봉한 영화 조회하는 쿼리
select *
from movie
	join movie_schedule on mo_num = ms_mo_num
where mo_opening_date like '2023%';

-- 2023년에 개봉한 한국 영화를 조회하는 쿼리
select cp_ct_name as 제작국가, mo_title as 영화
from movie
	join movie_schedule on mo_num = ms_mo_num
    join country_production on mo_num = cp_mo_num
where mo_opening_date like '2023%' and cp_ct_name = '한국';

-- 각 영화의 리뷰수를 조회하는 쿼리 (리뷰 없는 영화도 출력되게)
select mo_title as 영화, count(re_num) as 리뷰수
from movie 
	left join review on re_mo_num = mo_num
group by mo_num;

-- CGV강남에서 상영하는 모든 영화 스케쥴 조회하는 쿼리
select
	mo_title as 영화제목,
	th_name as 영화관명,
    mo_opening_date as 개봉날짜,
    ms_date as 상영날짜,
    sc_name as 상영관위치,
    ms_start_time as 시작시간,
    ms_end_time as 종료시간
from movie_schedule
	join movie on mo_num = ms_mo_num
    join screen on ms_sc_num = sc_num
    join theater on sc_th_num = th_num
where th_name like '%강남';

-- 영화 예매율 순으로 가장 예매율이 높은 영화 1개를 조회하는 쿼리
-- 예매율 같을시 개봉일이 늦은 영화를 조회
select mo_title as '영화예매율 1위'
from movie
order by mo_reservation_rate desc, mo_opening_date asc
limit 1;
	