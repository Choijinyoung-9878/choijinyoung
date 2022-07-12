-- DROP & CREATE
DROP TABLE DBREED;

CREATE TABLE DBREED(    -- 강아지 종류 테이블 
    DBREEDNO NUMBER(3) PRIMARY KEY,   -- 강아지 종류 번호
    DBREEDNAME VARCHAR2(30) UNIQUE NOT NULL -- 강아지 종류 이름
);

DROP TABLE CBREED;

CREATE TABLE CBREED(   -- 고양이 종류 테이블 
    CBREEDNO NUMBER(3) PRIMARY KEY,  -- 고양이 종류 번호 
    CBREEDNAME VARCHAR2(30) UNIQUE NOT NULL  -- 고양이 종류 이름 
);

-- DOG 테이블 
DROP SEQUENCE DOG_SEQ;

CREATE SEQUENCE DOG_SEQ
    MAXVALUE 999999
    NOCACHE
    NOCYCLE;
    
DROP TABLE DOG;

CREATE TABLE DOG(
    DID NUMBER(6) PRIMARY KEY,
    DNAME VARCHAR2(30) NOT NULL,
    DGENDER VARCHAR2(2) NOT NULL,
    DBIRTH DATE NOT NULL,
    DPRICE NUMBER(8) NOT NULL,
    DBREEDNO REFERENCES DBREED(DBREEDNO) NOT NULL,
    MID REFERENCES MEMBER(MID) NOT NULL
);
    
