CREATE TABLE GUESTBOOK (
  NO NUMBER(20) NOT NULL,
  NAME VARCHAR2(20) NOT NULL, 
  PASSWORD VARCHAR2(50) NOT NULL,
  MESSAGE VARCHAR2(2000) NOT NULL,
  REG_DATE DATE,
  PRIMARY KEY (NO) 
);

CREATE SEQUENCE GUESTBOOK_SEQ
INCREMENT BY 1
START WITH 1
MAXVALUE 9999999
NOCACHE
NOCYCLE;

select guestbook_seq.nextval from dual;

insert into guestbook values (guestbook_seq.nextval, 
								'����',
 								'1234',
 								'��������',
								sysdate);
								
select * from guestbook;
   
delete from guestbook;   