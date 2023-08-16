DROP DATABASE IF EXISTS BOOK;

CREATE DATABASE BOOK;

USE BOOK;

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	varchar(15)	NOT NULL PRIMARY KEY,
	`me_pw`	varchar(255)	NOT NULL,
	`me_phone`	char(13)	NOT NULL,
	`me_birthday`	date	NOT NULL,
	`me_authority`	varchar(5)	NOT NULL DEFAULT 'USER',
	`me_book_count`	int	NOT NULL DEFAULT 0,
	`me_total_overdue`	int	NOT NULL DEFAULT 0,
    `me_apply_overdue` date		NULL
);

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
	`bo_num`	varchar(20)	NOT NULL PRIMARY KEY,
	`bo_title`	varchar(255)	NOT NULL,
	`bo_type`	varchar(10)	NOT NULL,
	`bo_publisher`	varchar(30)	NOT NULL,
	`bo_author`	varchar(255)	NOT NULL,
	`bo_possible_loan`	int	NOT NULL,
	`bo_possible_reservation`	int	NOT NULL
);

DROP TABLE IF EXISTS `loan`;

CREATE TABLE `loan` (
	`lo_num`	int	NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`lo_date`	datetime	NOT NULL,
    `lo_me_id`	varchar(15)	NOT NULL,
	`lo_bo_num`	varchar(20)	NOT NULL,
	`lo_expected_date`	date	NOT NULL,
	`lo_return_date`	date	NULL
);

DROP TABLE IF EXISTS `reservation`;

CREATE TABLE `reservation` (
	`re_num`	int	NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`re_reservation_date`	date	NOT NULL,
	`re_me_id`	varchar(15)	NOT NULL,
	`re_bo_num`	varchar(20)	NOT NULL
);

DROP TABLE IF EXISTS `book_state`;

CREATE TABLE `book_state` (
	`bs_num`	int	NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`bs_desc`	varchar(20)	NOT NULL
);

ALTER TABLE `book` ADD CONSTRAINT `FK_book_state_TO_book_1` FOREIGN KEY (
	`bo_possible_loan`
)
REFERENCES `book_state` (
	`bs_num`
);

ALTER TABLE `book` ADD CONSTRAINT `FK_book_state_TO_book_2` FOREIGN KEY (
	`bo_possible_reservation`
)
REFERENCES `book_state` (
	`bs_num`
);

ALTER TABLE `loan` ADD CONSTRAINT `FK_member_TO_loan_1` FOREIGN KEY (
	`lo_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `loan` ADD CONSTRAINT `FK_book_TO_loan_1` FOREIGN KEY (
	`lo_bo_num`
)
REFERENCES `book` (
	`bo_num`
);

ALTER TABLE `reservation` ADD CONSTRAINT `FK_member_TO_reservation_1` FOREIGN KEY (
	`re_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `reservation` ADD CONSTRAINT `FK_book_TO_reservation_1` FOREIGN KEY (
	`re_bo_num`
)
REFERENCES `book` (
	`bo_num`
);