
USE BOOK;
DROP TRIGGER IF EXISTS INSERT_LOAN;

-- 대출 테이블에 데이터 추가가 됐을 때 실행 되어야 하는 쿼리를 트리거를 이용하여 작성한 후 적용

DELIMITER //
CREATE TRIGGER INSERT_LOAN AFTER INSERT ON LOAN
FOR EACH ROW
BEGIN
-- 해당 도서를 대출할 때 예약 내역이 있으면
   
    -- NEW.LO_ME_ID 회원이 도서 NEW.LO_BO_NUM을 예약했다면
   IF (
      SELECT COUNT(*) 
        FROM RESERVATION 
        WHERE 
        RE_ME_ID = NEW.LO_ME_ID AND 
        RE_BO_NUM = NEW.LO_BO_NUM
        ) > 0 
   THEN
      -- 예약 테이블에 데이터를 삭제 
        DELETE FROM RESERVATION 
      WHERE
         RE_ME_ID = NEW.LO_ME_ID
            AND RE_BO_NUM = NEW.LO_BO_NUM;
        -- 도서의 예약상태를 예약 가능으로 수정
      UPDATE BOOK
      SET
         BO_POSSIBLE_RESERVATION = (SELECT BS_NUM FROM BOOK_STATE WHERE BS_DESC = '예약 가능')
      WHERE
         BO_NUM = NEW.LO_BO_NUM;
    END IF;
-- 도서 상태를 대출 중으로 수정
   UPDATE BOOK
   SET
      BO_POSSIBLE_LOAN = (SELECT BS_NUM FROM BOOK_STATE WHERE BS_DESC = '대출 중')
   WHERE
      BO_NUM = NEW.LO_BO_NUM;
-- 회원이 대출한 도서 수를 증가
   UPDATE MEMBER
   SET ME_BOOK_COUNT = ME_BOOK_COUNT + 1
   WHERE ME_ID = NEW.LO_ME_ID;
END //
DELIMITER ;


insert into loan(lo_date, lo_me_id, lo_bo_num, lo_expected_date)
		values(date_format(now(),'%Y-%m-%d'), 'qwe123', '500.ABC123',
		  date_format(date_add(now(), interval 14 day),'%Y-%m-%d'));
          
 insert into loan(lo_date, lo_me_id, lo_bo_num, lo_expected_date)
		values(date_format(now(),'%Y-%m-%d'), 'admin', '103.987DD',
		  date_format(date_add(now(), interval 14 day),'%Y-%m-%d'));         