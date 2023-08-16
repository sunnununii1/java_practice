/*
drop trigger if not exists 트리거명;
deilmiter //
create trigger 트리거명 트리거시간 이벤트명 on 테이블명
for each row
begin
//구현
end //
delimiter ;

트리거시간 : before | after
이벤트명 : insert | update | delete
*/

use test;

-- 회원이 등록되면 대쉬보드 테이블에 등록된 회원수를 증가시키는 트리거
drop trigger if exists insert_member;
delimiter //

create trigger insert_member after insert on member
for each row
begin
	update dash_board
		set
			db_member = db_member + 1;
end //
delimiter ;

insert into member(me_id, me_pw) values('abc123','abc123'),('admin','admin');


-- 회원이 게시글을 작성하면 회원의 작성된 게시글 수가 증가하는 트리거
drop trigger if exists insert_board;
delimiter //

create trigger insert_board after insert on board
for each row
begin
	update member
		set
			me_board_count = me_board_count + 1
        where
			me_id = new.bo_me_id;
end //
delimiter ;

insert into board(bo_title, bo_me_id) values('게시글','abc123');


-- 게시글이 삭제됐을 때 해당 게시글을 작성한 회원의 게시글 수를 1 줄이는 트리거
drop trigger if exists delete_board;
delimiter //

create trigger delete_board after delete on board
for each row
begin
	update member
		set
			me_board_count = me_board_count - 1
        where
			me_id = old.bo_me_id;
end //
delimiter ;

delete from board where bo_num = 1;


use shoppingmall;

-- 회원이 제품을 주문했을 때 필요한 트리거 작성
-- 주문 테이블에 데이터 추가 => 주문 리스트에 데이터 추가됨 => 각 주문 리스트에 맞는 옵션수량 변경됨
-- 주문 리스트에 데이터 추가시 각 주문 리스트에 맞는 옵션수량 변경 트리거 작성
drop trigger if exists insert_order_list;
delimiter //

create trigger insert_order_list after insert on order_list
for each row
begin
	update `option`
		set
			op_amount = op_amount - new.ol_amount
        where
			op_num = new.ol_op_num;
end //
delimiter ;

-- or_num가 3번이 없는 경우 동작가능.
insert into `order`(or_num, or_total, or_price, or_use_point, or_save_point,
 or_me_id, or_ad_num)
	values(3, 45000, 45000, 0, 4500, 'qwe123', 2);
-- 아래 쿼리가 실행될 때 트리거가 동작되야 함
insert into order_list(ol_amount, ol_price, ol_or_num, ol_op_num)
	values(1, 15000, 3, 1),(1, 30000, 3, 3);

-- 회원이 주문한 내역을 구매확정으로 바꾸면 포인트가 적립되는 트리거 작성
drop trigger if exists update_order;
delimiter //

create trigger update_order after insert on `order`
for each row
begin
	-- or_state가 구매확정이면 포인트 적립
	if new.or_state = '구매확정' then
		update member
			set
				me_point = me_point + new.or_save_point
            where
				me_id = new.or_me_id;
    end if;
end //
delimiter ;

update `order` set or_state = '구매확정' where or_num = 3;


