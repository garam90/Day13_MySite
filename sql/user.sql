drop table member;
drop sequence member_no_seq;

CREATE TABLE member
( 
no        NUMBER(8),
name      VARCHAR2(30),
email     VARCHAR2(80),
password  VARCHAR2(30),
gender    VARCHAR2(10)
) ;

ALTER TABLE member
ADD ( CONSTRAINT member_no_pk PRIMARY KEY ( no ) );


CREATE SEQUENCE member_no_seq
 START WITH     1
 INCREMENT BY   1
 MAXVALUE       99999999
 NOCACHE
 NOCYCLE;

select * from member;

CREATE TABLE board
(
	no NUMBER(8),
	title VARCHAR2(100),
	content VARCHAR2(1000),
	userId VARCHAR2(80),
	reg_date DATE,
	viewC NUMBER(8)
);

ALTER TABLE board
ADD ( CONSTRAINT board_no_pk PRIMARY KEY ( no ) );

CREATE SEQUENCE board_no_seq
 START WITH     1
 INCREMENT BY   1
 MAXVALUE       99999999
 NOCACHE
 NOCYCLE;
 
 drop table board;
 