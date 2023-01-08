# SQL 스터디
`혼자 공부하는 SQL`(한빛미디어) (2023.01.06~)

## 목차
- [SQL문](#sql-)
- [데이터 형식](#------)
- [market_db.sql](#market-dbsql)
- [USE 문](#use--)
- [SELECT 문](#select--)
    * [기본 형식](#-----)
    * [열 이름의 별칭(alias)](#---------alias-)
    * [IN()](#in--)
- [LIKE](#like)

## SQL문
- CREATE: 테이블이나 데이터베이스를 만들 때 사용합니다.
- UPDATE: 데이터를 수정할 때 사용합니다.
- DELETE: 데이터를 삭제할 때 사용합니다.
- SELECT: 데이터를 조회할 때 사용합니다.


## 데이터 형식
- INT: 소수점이 없는 정수형
- CHAR: 문자형
- DATE: 날짜형
- NOT NULL: 비어있는 데이터를 허용하지 않습니다.

## market_db.sql
```sql
DROP DATABASE IF EXISTS market_db; -- 만약 market_db가 존재하면 우선 삭제한다.
CREATE DATABASE market_db;

USE market_db; -- market_db 데이터베이스를 선택
    
CREATE TABLE member -- 회원 테이블
( mem_id  	CHAR(8) NOT NULL PRIMARY KEY, -- 사용자 아이디(PK)
  mem_name    	VARCHAR(10) NOT NULL, -- 이름
  mem_number    INT NOT NULL,  -- 인원수
  addr	  	CHAR(2) NOT NULL, -- 지역(경기,서울,경남 식으로 2글자만입력)
  phone1	CHAR(3), -- 연락처의 국번(02, 031, 055 등)
  phone2	CHAR(8), -- 연락처의 나머지 전화번호(하이픈제외)
  height    	SMALLINT,  -- 평균 키
  debut_date	DATE  -- 데뷔 일자
);
CREATE TABLE buy -- 구매 테이블
(  num 		INT AUTO_INCREMENT NOT NULL PRIMARY KEY, -- 순번(PK)
   mem_id  	CHAR(8) NOT NULL, -- 아이디(FK)
   prod_name 	CHAR(6) NOT NULL, --  제품이름
   group_name 	CHAR(4)  , -- 분류
   price     	INT  NOT NULL, -- 가격
   amount    	SMALLINT  NOT NULL, -- 수량
   FOREIGN KEY (mem_id) REFERENCES member(mem_id)
);

INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015.10.19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016.08.08');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015.01.15');
INSERT INTO member VALUES('OMY', '오마이걸', 7, '서울', NULL, NULL, 160, '2015.04.21');
INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울', '02', '44444444', 168, '2007.08.02');
INSERT INTO member VALUES('ITZ', '잇지', 5, '경남', NULL, NULL, 167, '2019.02.12');
INSERT INTO member VALUES('RED', '레드벨벳', 4, '경북', '054', '55555555', 161, '2014.08.01');
INSERT INTO member VALUES('APN', '에이핑크', 6, '경기', '031', '77777777', 164, '2011.02.10');
INSERT INTO member VALUES('SPC', '우주소녀', 13, '서울', '02', '88888888', 162, '2016.02.25');
INSERT INTO member VALUES('MMU', '마마무', 4, '전남', '061', '99999999', 165, '2014.06.19');

INSERT INTO buy VALUES(NULL, 'BLK', '지갑', NULL, 30, 2);
INSERT INTO buy VALUES(NULL, 'BLK', '맥북프로', '디지털', 1000, 1);
INSERT INTO buy VALUES(NULL, 'APN', '아이폰', '디지털', 200, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '아이폰', '디지털', 200, 5);
INSERT INTO buy VALUES(NULL, 'BLK', '청바지', '패션', 50, 3);
INSERT INTO buy VALUES(NULL, 'MMU', '에어팟', '디지털', 80, 10);
INSERT INTO buy VALUES(NULL, 'GRL', '혼공SQL', '서적', 15, 5);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 2);
INSERT INTO buy VALUES(NULL, 'APN', '청바지', '패션', 50, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 1);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 4);

SELECT * FROM member;
SELECT * FROM buy;


```

## USE 문
현재 사용하는 데이터베이스를 변경한다.
```sql
USE market_db;
```

## SELECT 문

### 기본 형식
```sql
SELECT select_expr -- 열_이름
     [FROM table_reference] -- 테이블_이름 
     [WHERE where_condition] -- 조건식
     [GROUP BY {col_name | expr | position}] -- 열_이름
     [HAVING where_conditon] -- 조건식
     [ORDER BY {col_name | expr | position}] -- 열_이름
     [LIMIT {[offset,] row_count | row_count OFFSET offset}] -- 숫자
```

데이터베이스 이름을 생략하면 USE 문으로 지정해 놓은 데이터베이스가 자동으로 선택됩니다. 

다음 두 쿼리는 동일한 것입니다. 
```sql
USE market_db;
SELECT * FROM member;
```
```sql
SELECT * FROM market_db.member;
```

### 열 이름의 별칭(alias)
열 이름 다음에 지정하고 싶은 별칭을 입력하면 됩니다. 별칭에 공백이 있으면 큰따옴표(")로 묶어줍니다.
```sql
SELECT addr 주소, debut_date "데뷔 일자", mem_name FROM member;
```

### IN()
다음과 같이 문자로 표현되는 데이터는 어느 범위에 들어 있다고 표현할 수 없습니다.
```sql
SELECT mem_name, addr
    FROM member
    WHERE addr = '경기' OR addr = '전남' OR addr = '경남';
```
IN()을 사용하면 코드를 간결하게 작성가능합니다.
```sql
SELECT mem_name, addr
    FROM member
    WHERE addr IN('경기', '전남', '경남');
```

### LIKE
문자열의 일부를 검색 할 수 있습니다.
```sql
SELECT *
    FROM member
    WHERE mem_name LIKE '우%'; -- 제일 앞 글자가 '우'이고 그 뒤는 무엇이든(%) 허용
```
한 글자와 매치하기 위해서는 언더바(_) 사용
```sql
SELECT *
    FROM member
    WHERE mem_name LIKE '__핑크'; -- 앞 두글자는 상관없고 뒤는 '핑크'인 회원을 검색
```

### 서브 쿼리
SELECT 안에는 또 다른 SELECT 가 들어갈 수 있습니다.
```sql
SELECT mem_name, height FROM member
    WHERE height > (SELECT height FROM member WHERE mem_name = '에이핑크');
```