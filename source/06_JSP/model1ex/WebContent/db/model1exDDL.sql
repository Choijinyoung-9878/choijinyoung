-- 테이블 & 시퀀스 DROP 및 CREATE
DROP TABLE CUSTOMER;
CREATE TABLE CUSTOMER(
    CID    VARCHAR2(50) PRIMARY KEY,
    CPW    VARCHAR2(50) NOT NULL,
    CNAME  VARCHAR2(50) NOT NULL,
    CTEL   VARCHAR2(50) NOT NULL,
    CEMAIL VARCHAR2(50),
    CADDRESS VARCHAR2(250),
    CGENDER  VARCHAR2(10) NOT NULL,
    CBIRTH   DATE NOT NULL,
    CRDATE   DATE DEFAULT SYSDATE);
    
DROP SEQUENCE BOOK_SEQ;
DROP TABLE BOOK;
CREATE SEQUENCE BOOK_SEQ MAXVALUE 99999 NOCACHE NOCYCLE;
CREATE TABLE BOOK(
    bID NUMBER(5) PRIMARY KEY,    -- 책번호
    bTITLE VARCHAR2(100) NOT NULL, -- 책제목
    bPRICE NUMBER(7)     NOT NULL, -- 책가격
    bIMAGE1 VARCHAR2(30) NOT NULL, -- 책 대표 이미지(첨부안 할 경우 : noImg.png)
    bIMAGE2 VARCHAR2(30) NOT NULL, -- 책 부가 이미지(첨부안 할 경우 : NOTHING.JPG)
    bCONTENT VARCHAR2(4000),       -- 책 설명(한글 1,333글자 이내)
    bDISCOUNT NUMBER(3) NOT NULL,  -- 할인율(0~100% 이내)
    bRDATE DATE DEFAULT SYSDATE    -- 책 등록일    
);
DROP SEQUENCE FILEBOARD_SEQ;
DROP TABLE FILEBOARD;
CREATE SEQUENCE FILEBOARD_SEQ MAXVALUE 9999999 NOCACHE NOCYCLE;
CREATE TABLE FILEBOARD(
    FNUM     NUMBER(7) PRIMARY KEY,   -- 글번호
    CID      VARCHAR2(50) REFERENCES CUSTOMER(CID), -- 작성자 CID
    FSUBJECT VARCHAR2(250) NOT NULL, -- 글 제목
    FCONTENT VARCHAR2(4000),         -- 본문
    FFILENAME VARCHAR2(50),          -- 첨부파일명
    FPW       VARCHAR2(50) NOT NULL, -- 비번
    FHIT      NUMBER(7) DEFAULT 0 NOT NULL,    -- 조회수
    FREF      NUMBER(7) NOT NULL,    -- 글 그룹
    FRE_STEP  NUMBER(7) NOT NULL,    -- 그룹내 출력순서
    FRE_LEVEL NUMBER(7) NOT NULL,    -- 들여쓰기 정도
    FIP       VARCHAR2(50) NOT NULL, -- 글쓴 컴퓨터 IP
    FRDATE    DATE DEFAULT SYSDATE NOT NULL);  -- 글 등록 시점

