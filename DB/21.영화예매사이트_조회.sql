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