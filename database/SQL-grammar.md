# SQL 스터디
![](https://image.aladin.co.kr/product/28203/15/cover200/k032835973_1.jpg)

`혼자 공부하는 SQL`(한빛미디어) (2023.01.06 ~ 2023.01.30.)

## 목차
- [market_db.sql](#market-dbsql)
- [USE 문](#use_문)
- [SELECT 문](#select--)
  * [기본 형식](#-----)
  * [FROM](#from)
  * [WHERE](#where)
    + [열 이름의 별칭(alias)](#---------alias-)
    + [IN()](#in--)
    + [LIKE](#like)
  * [서브 쿼리](#-----)
  * [ORDER BY](#order-by)
  * [LIMIT](#limit)
  * [DISTINCT](#distinct)
  * [GROUP BY 절](#group-by--)
  * [Having 절](#having--)
- [INSERT 문](#insert--)
  * [기본 형식](#------1)
  * [AUTO_INCREMENT](#auto-increment)
  * [INSERT INTO ~ SELECT](#insert-into---select)
- [UPDATE](#update)
  * [기본 형식](#------2)
  * [WHERE가 없는 UPDATE 문](#where-----update--)
- [DELETE](#delete)
  * [기본형식](#----)
  * [대용량 테이블의 삭제](#-----------)
- [데이터 형식](#------)
  * [정수형](#---)
  * [문자형](#---)
  * [대량의 데이터 형식](#----------)
  * [실수형](#---)
  * [날짜형](#---)
- [변수의 사용](#------)
  * [PREPARE과 EXECUTE](#prepare--execute)
- [데이터 형 변환](#--------)
  * [명시적 변환](#------)
  * [암시적 변환](#------)
- [JOIN](#join)
  * [기본 형식 (내부 조인)](#-------------)
  * [활용](#--)
  * [기본 형식 (외부 조인)](#-------------)
- [스토어드 프로시저](#---------)
  * [IF ~ ELSE 문](#if---else--)
    + [날짜 관련 함수](#--------)
  * [CASE 문](#case--)
  * [WHILE 문](#while--)
  * [동적 SQL 문](#---sql--)
    + [PREPARE과 EXECUTE](#prepare--execute-1)
- [SQL로 테이블 만들기](#sql---------)
  * [테이블 생성하기](#--------)
  * [데이터 입력하기](#--------)
- [제약 조건](#-----)
  * [기본 키 제약조건](#---------)
    + [CREATE TABLE에서 설정](#create-table-----)
    + [ALTER TABLE에서 설정](#alter-table-----)
  * [외래 키 제약조건](#---------)
    + [CREATE TABLE에서 설정](#create-table------1)
    + [ALTER TABLE에서 설정](#alter-table------1)
  * [고유 키 제약조건](#---------)
  * [체크 제약조건](#-------)
  * [기본값 정의](#------)
- [뷰](#-)
  * [뷰의 형식](#-----)
  * [뷰를 사용하는 이유](#----------)
  * [뷰의 실제 작동](#--------)
    + [뷰의 실제 생성, 수정, 삭제](#----------------)
    + [뷰의 정보 확인](#--------)
- [인덱스](#---)
  * [인덱스의 장단점](#--------)
  * [인덱스의 종류](#-------)
    + [클러스터형 인덱스](#---------)
    + [보조형 인덱스](#-------)
  * [인덱스의 내부 작동](#----------)
    + [균형 트리의 개념](#---------)
  * [인덱스의 실제 사용](#----------)
  * [인덱스를 효과적으로 사용하는 방법](#------------------)

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

### FROM
데이터베이스 이름을 생략하면 USE 문으로 지정해 놓은 데이터베이스가 자동으로 선택됩니다. 

다음 두 쿼리는 동일한 것입니다. 
```sql
USE market_db;
SELECT * FROM member;
```
```sql
SELECT * FROM market_db.member;
```
### WHERE
#### 열 이름의 별칭(alias)
열 이름 다음에 지정하고 싶은 별칭을 입력하면 됩니다. 별칭에 공백이 있으면 큰따옴표(")로 묶어줍니다.
```sql
SELECT addr 주소, debut_date "데뷔 일자", mem_name FROM member;
```

#### IN()
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

#### LIKE
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

### ORDER BY
결과가 출력되는 순서를 조절합니다.
```sql
SELECT mem_id, mem_name, debut_date
    FROM member
    ORDER BY debut_date; -- 데위 일자가 빠른 순서대로 출력, ASC(Ascending)-기본값
```

```sql
SELECT mem_id, mem_name, debut_date
    FROM member
    ORDER BY debut_date DESC; -- 데위 일자가 늦은 순서대로 출력, DESC(Descending)
```

```sql
SELECT mem_id, mem_name, debut_date, height
    FROM member
    WHERE height >= 164
    ORDER BY height DESC, debut_date ASC; -- 키가 큰 순서대로 정렬하되, 키가 같으면 데뷔일자가 빠른 순서로 정렬
```

### LIMIT
출력하는 개수를 제한합니다.

형식: LIMIT 시작, 개수 (LIMIT 3 == LIMIT 0, 3)
```sql
SELECT mem_name, debut_date
    FROM member
    ORDER BY debut_date
    LIMIT 3; -- 3건만 출력
```

```sql
SELECT mem_name, debut_date
    FROM member
    ORDER BY debut_date
    LIMIT 3, 2; -- 3번째부터 2건만 조회
```

### DISTINCT
중복된 데이터 1개만 남기고 제거합니다.
```sql
SELECT DISTINCT addr FROM member;
```

### GROUP BY 절
그룹을 묶어주는 역할을 합니다.
```sql
SELECT mem_id, SUM(amount) FROM bouy GROUP BY mem_id;
```
SUM 외의 집계함수들
- AVG() : 평균을 구합니다.
- MIN() : 최소값을 구합니다.
- MAX(): 최대값을 구합니다.
- COUNT() : 행의 개수를 셉니다.
- COUNT(DISTINCT) : 행의 개수를 셉니다. (중복은 1개만 인정)

### Having 절
WHERE 과 비슷한 개념으로 조건을 제한하는 것이지만, 집계 함수에 대해서 조건을 제한하는 것입니다.
```sql
SELECT  mem_id "회원 아이디", SUM(price*amount) "총 구매 금액"
    FROM buy
    GROUP BY mem_id
    HAVING SUM(price*amount) > 1000 -- 집계 함수에 대해서 조건을 제한
    ORDER BY SUM(price*amount) DESC;
```

## INSERT 문
테이블에 행 데이터를 삽입하는 명령입니다.

### 기본 형식
열 이름을 생략할 경우에 VALUES 다음에 나오는 값들의 순서 및 개수는 테이블을 정의할 때의 열 순서 및 개수와 동일해야 합니다. 
```sql
INSERT INTO 테이블 [(열1, 열2, ...)] VALUES (값1, 값2, ...)
```

```sql
USE market_db;
CREATE TABLE hongong1 (toy_id INT, toy_name CHAR(4), age INT);
INSERT INTO hongong1 VALUES (1, '우디', 25);
```

나이(age)는 생략하고 싶다면 다음과 같이 적으면 됩니다. 이 경우에 생략한 열에는 `NULL` 값이 들어갑니다.
```sql
INSERT INTO hongong1 VALUES (1, '우디', 25);
```
### AUTO_INCREMENT
열을 정의할때 1부터 증가하는 값을 입력해줍니다.
```sql
CREATE TABLE hongong2 (
    toy_id INT AUTO_INCREMENT PRIMARY KEY, -- AUTO_INCREMENT로 지정하는 열은 꼭 PRIMARY KEY로 지정해줘야합니다.
    toy_name CHAR(4),
    age INT);
ALTER TABLE hongong2
```

자동 증가하는 부분은 `NULL` 값으로 채워 놓으면 됩니다.
```sql
INSERT INTO hongong2 VALUES (NULL, '보핍', 25);
INSERT INTO hongong2 VALUES (NULL, '슬링키', 22);
INSERT INTO hongong2 VALUES (NULL, '렉스', 21);
SELECT * FROM hongong2;
```

```sql
CREATE TABLE hongong3 (
    toy_id INT AUTO_INCREMENT PRIMARY KEY,
    toy_name CHAR(4),
    age INT);
ALTER TABLE hongong3 AUTO_INCREMENT=1000; -- 시작값은 1000으로 지정
SET @@auto_increment_increment=3; -- 증가값은 3으로 지정
```

### INSERT INTO ~ SELECT

다른 테이블의 데이터를 가져와서 한 번에 입력할 수 있습니다. 

이때, SELECT 문의 열 개수는 INSERT할 테이블의 열 개수와 같아야합니다.
```sql
CREATE TABLE city_popul (city_name CHAR(35), population INT); -- city_popul 테이블 생성

INSERT INTO city_popul
    SELECT Name, Population FROM world.city; --- world.city의 테이블의 내용을 city_popul 테이블에 입력
```

## UPDATE
행 데이터를 수정합니다.
### 기본 형식
```sql
UPDATE 테이블_이름
    SET 열1=값1, 열2=값2
    WHERE 조건;
```
```sql
UPDATE city_popul
    SET city_name = '뉴욕', population = 0
    WHERE city_name = 'New  York';
SELECT * FROM city_popul WHERE city_name = '뉴욕';
```
### WHERE가 없는 UPDATE 문
```sql
UPDATE city_popul
    SET population = population / 10000;
-- WHERE 절은 생략이 가능하지만 생략시 모든 행의 값이 변경
-- 모든 인구 열(population)을 한꺼번에 10,000로 나누어서 인구 단위를 변경
SELECT * FROM city_popul LIMIT 5;
```

## DELETE
행 데이터를 삭제합니다.
### 기본형식
```sql
DELETE FROM 테이블이름 WHERE 조건 ;
```

```sql
DELETE FROM city_popul
    WHERE city_name LIKE 'New%'; -- 'New' 글자로 시작하는 도시 중에서
    LIMIT 5; -- 상위 5건만 삭제됩니다.
```

### 대용량 테이블의 삭제
DROP은 테이블이 아예 없어지지만, DELETE와 TRUNCATE는 빈 테이블을 남깁니다.
```sql
DELETE FROM big_table1;
DROP TABLE big_table2; -- 테이블 자체를 삭제합니다
TRUNCATE TABLE big_table3; -- DELETE와 동일한 효과를 내지만 속도가 빠르다
```

대용량 테이블의 전체 내용을 삭제할 때 테이블 자체가 필요없을 경우에는 DROP으로 삭제하고,

테이블의 구조는 남겨놓고 싶다면 TRUNCATE로 삭제하는 것이 효율적입니다.

---

## 데이터 형식

### 정수형

|  데이터 형식  | 바이트수 |    숫자범위          |
|:--------:|:----:|:----------------:|
| TINYINT  |  1   |    -128 ~ 127    |
| SMALLINT |  2   | -32,768 ~ 32,767 |
|   INT    |  4   |   약 -21억 ~ 21억   |
|  BIGINT  |  8   |  약 -900경 ~ 900경  |

UNSIGNED를 붙이면 0부터 범위가 지정됩니다.

```sql
TINYINT : -128 ~ 127
TINYINT UNSIGNED : 0 ~ 255
```

### 문자형
|   데이터 형식    |   바이트수    |
|:-----------:|:---------:|
|  CHAR(개수)   |  1 ~ 255  |
| VARCHAR(개수) | 1 ~ 16383 |

- VARCHAR(Variable Character)는 가변길이 문자형으로 3글자를 저장할 경우 3자리만 사용합니다.

- VARCHAR가 CHAR보다 공간을 효율적으로 운영할 수 있지만, MySQL 내부적으로 성능(빠른 속도)면에서는 CHAR로 설정하는 것이 조금더 좋습니다.

- 데이터가 숫자 형태라도 연산이나 크기에 의미가 없다면 문자형으로 지정하는 것이 좋습니다.

### 대량의 데이터 형식
|  데이터 형식  |          바이트수          |
|:--------:|:----------------------:|
|   TEXT   |       1 ~ 65535        |
| LONGTEXT | 1 ~ 4294967295 (약 42억) |
|   BLOB   |       1 ~ 65535        |
| LONGBLOB | 1 ~ 4294967295 (약 42억) |

- 소설이나 영화 대본과 같은 내용을 저장한다면 필요한 데이터 형식입니다.

- BLOB(BINARY LONG Object)는 글자가 아닌 이미지 동영상 등의 데이터라고 생각하면 됩니다. 이런 것을 이진 데이터(Binary)라고 합니다. 

- LONGTEXT 및 LONGBLOB으로 설정하면 각 데이터는 최대 4GB까지 입력할 수 있습니다.

### 실수형
실수형은 소수점이 있는 숫자를 저장할 때 사용합니다.

| 데이터 형식 |          바이트수          | 설명|
|:------:|:----------------------:|:---:|
| FLOAT  | 4|소수점 아래 7자리까지 표현|
|DOUBLE | 8 | 소수점 아래 15자리까지 표현|

과학 기술용 데이터가 아닌 이상 FLOAT면 충분합니다.

### 날짜형
날짜 및 시간을 저장할 때 사용합니다.

|  데이터 형식  | 바이트 수 |                    설명                    |
|:--------:|:-----:|:----------------------------------------:|
|   DATE   |   3   |        날짜만 저장. YYYY-MM-DD 형식으로 사용        |
|   TIME   |   3   |         시간만 저장. HH:MM:SS 형식으로 사용         |
| DATETIME |   8   | 날짜 및 시간을 저장. YYYY-MM-DD HH:MM:SS 형식으로 사용 |

---
## 변수의 사용 
```sql
SET @변수이름 = 변수의 값; -- 변수의 선언 및 값 대입
SELECT @변수이름; -- 변수의 값 출력 
```

```sql
SET @txt = '가수 이름==> ';
SET @height = 166;
SELECT @txt, mem_name FROM member WHERE height > @height;

-- 가수 이름==> 소녀시대
-- 가수 이름==> 잇지
-- 가수 이름==> 트와이스
```

### PREPARE과 EXECUTE
LIMIT에는 변수를 사용할 수 없기 때문에 PREPARE과 EXECUTE를 사용합니다.
```sql
SET @count = 3;
PREPARE mySQL FROM 'SELECT mem_name, height FROM member ORDER BY height LIMIT ?';
EXECUTE mySQL USING @count;

-- 위 아래는 실핼 결과가 동일

SELECT mem_name, height FROM member ORDER BY height LIMIT 3;
```
- PREPARE는 `SELECT ~~ LIMIT ?`문을 실행하지 않고 mySQL이라는 이름으로 준비만 해놓습니다.
- ?는 현재는 모르지만 나중에 채워진다는 뜻입니다.
- EXCUTE로 mySQL에 저장된 SELECT 문을 실행할 때, USING으로 물음표(?)에 @count변수의 값을 대입하는 것입니다.

## 데이터 형 변환

### 명시적 변환
```sql
CAST ( 값 AS 데이터_형식 [ (길이) ])
CONVERT ( 값, 데이터_형식 [ (길이) ])
```

```sql
SELECT AVG(price) AS '평균 가격' FROM buy; -- 142.9167
```

```sql
SELECT CAST(AVG(price) AS SIGNED) '평균 가격' FROM buy; -- 143
-- 또는
SELECT CONVERT(AVG(price) , SIGNED) '평균 가격' FROM buy; -- 143
```
가격은 실수보다는 정수가 보기 좋기 때문에 바꿔주었습니다.
```sql
SELECT num, CONCAT(CAST(price AS CHAR), 'X', CAST(amount AS CHAR), '=') -- '30X2='와 같은 형태
    '가격 X 수량', price * amount '구매액'
FROM buy;
```
- 가격과 수량은 정수이지만 CAST() 함수를 통해 문자로 바꿨습니다.
- CONCAT()함수는 문자를 이어주는 역할을 합니다.

### 암시적 변환

```sql
SELECT '100' + '200'; -- 300
```

```sql
SELECT CONCAT('100' + '200'); -- 100200
```

```sql
SELECT COCAT(100, '200'); -- 100200
SELECT 100 + '200'; -- 300
```

## JOIN

### 기본 형식 (내부 조인)
두 테이블에 모두 있는 내용만 출력됩니다.

```sql
SELECT <열 목록>
FROM <첫 번째 테이블>
    INNER JOIN <두 번째 테이블>
    ON <조인될 조건>
[WHERE 검색 조건]
```
구매한 기록이 있는 회원들의 목록만 추출합니다.
```sql
USE market_db;
SELECT *
    FROM buy
    INNER JOIN member
    ON buy.mem_id = member.mem_id
WHERE buy.mem_id = 'GRL';
```
1. buy 테이블의 mem_id(buy.mem_id)인 'GRL'을 추출합니다.
2. 'GRL'과 동일한 값을 회원 테이블의 mem_id(member.mem_id)열에서 검색합니다.
3. 'GRL'이라는 아이디를 찾으면 구매 테이블과 회원 테이블의 두행을 결합(JOIN)합니다.

### 활용
```sql
-- 중복된 이름 제거 
SELCET DISTINCT M.mem_id, M.mem_name, B.prod_name, M.addr
  FROM buy B -- 별칭의 사용
    INNER JOIN member M
    ON B.mem_id = M.mem_id
  ORDER BY M.mem_id;
```
### 기본 형식 (외부 조인)
한 쪽에만 데이터가 있어도 결과가 나옵니다.
```sql
SELECT <열 목록>
    FROM <첫 번째 테이블(LEFT 테이블)>
        <LEFT | RIGHT | FULL> OUTER JOIN <두 번째 테이블(RIGHT 테이블)>
        ON <조인될 조건>
[WHERE 검색 조건] ;
```
회원으로 가입만하고, 한번도 구매한 적이 없는 회원의 목록을 출력합니다.
```sql
SELECT M.mem_id, M.mem_name, B.prod_name, M.addr
    FROM member M
        LEFT OUTER JOIN buy B -- 왼쪽에 있는 회원 테이블을 기준으로 외부 조인합니다.
        ON M.mem_id = B.mem_id
    WHERE B.prod_name IS NULL
    ORDER BY M.mem_id;
```
## 스토어드 프로시저
### IF ~ ELSE 문
```sql
DROP PROCEDURE IF EXISTS ifProc1; -- 기존에 ifProc()1을 만든 적이 있다면 삭제합니다.
DELIMITER $$
CREATE PROCEDURE ifProc1()
BEGIN
    DECLARE debutDate DATE; -- 변수 선언, 데뷔 일자
    DECLARE curDate DATE; -- 오늘
    DECLARE days INT; -- 활동한 일수
        
    SELECT debut_date INTO debutDate -- 에이핑크의 데뷔일자가 debutDate에 저장됩니다. 
        FROM market_db.member
        WHERE mem_id = 'APN';

    SET curDATE = CURRENT_DATE(); -- 현재 날짜
    SET days = DATEDIFF(curDATE, debutDate); -- 날짜의 차이, 일 단위
        
    IF (days/365) >= 5 THEN -- 5년이 지났다면
        SELECT CONCAT('데뷔한 지', days, '일이나 지났습니다. 핑순이들 축하합니다!');
    ELSE
        SELECT '데위한 지 ' + days + '일밖에 안되었네요. 핑순이들 화이팅~';
    END IF;
END $$
DELIMITER; -- $$를 사용해 스토어드 프로시저의 끝인지를 구별합니다.
CALL ifProc1(); -- CALL로 호출하면 ifProc1()이 실행됩니다.
```
#### 날짜 관련 함수
- CURRENT_DATE(): 오늘 날짜를 알려줍니다.
- CURRENT_TIMESTAMP(): 오늘 날짜 및 시간을 함께 알려줍니다.
- DATEDIFF(날짜1, 날짜2): 날짜2부터 날짜1까지 일수로 몇일인지 알려줍니다.

### CASE 문
```sql
SELECT M.mem_id, M.mem_name, SUM(price*amount) "총구매액",
       CASE
           WHEN (SUM(price*amount) >= 1500) THEN '최우수고객'
           WHEN (SUM(price*amount) >= 1000) THEN '우수고객'
           WHEN (SUM(price*amount) >= 1) THEN '일반고객'
           ELSE '유령고객'
        END "회원등급"
    FROM buy B
        RIGHT OUTER JOIN member M
        ON B.mem_id = M.mem_id
    GROUP BY M.mem_id, M.mem_name
    ORDER BY SUM(price*amount) DESC ;
```
### WHILE 문
```sql
DROP PROCEDURE IF EXISTS whileProc1;
DELIMITER $$
CREATE PROCEDURE whileProc1()
BEGIN
    DECLARE i INT;
    DECLARE hap INT;
    SET i = 1;
    SET hap = 0;

    myWhile: -- 레이블 지정
    WHILE (i <= 100) DO
        IF (i % 4 = 0) THEN
            SET i = i + 1;
            ITERATE myWhile; -- 지정한 label 문으로 가서 계속 진행
        ENF IF;
            
        SET hap = hap + i;
            
        IF (hap > 1000) THEN
            LEAVE myWhile; -- 지정한 label 문을 떠남. 즉 While 종료
        END IF;
            
        SET i = i + 1;
    END WHILE;

    SELECT '1부터 100까지의 합(4의 배수 제외), 1000 넘으면 종료 ==>', hap;
END $$
DELIMITER ;
CALL whileProc1();
```

### 동적 SQL 문
SQL문은 내용이 고정되어 있는 경우가 대부분입니다. 하지만 상황에 따라 내용 변경이 필요할 때 동적 SQL을 사용하면 변경되는 내용을 실시간으로 적용시켜 사용할 수 있습니다.
#### PREPARE과 EXECUTE
```sql
DROP TABLE IF EXISTS gate_table;
CREATE TABLE gate_table (id INT AUTO_INCREMENT PRIMARY KEY, entry_time DATETIME);

SET @curDate = CURRENT_TIMESTAMP(); -- 현재 날짜와 시간

PREPARE myQuery FROM 'INSERT INTO gate_table VALUES(NULL, ?)'; -- myQuery에 입력만 해놓는다.
EXECUTE myQuery USING @curDate; -- 실행이 필요한 시점에 EXECUTE myQuery문 실행
DEALLOCATE PREPARE myQuery; -- 실행 후에 문장 해제

SELECT  * FROM gate_table;
```

## SQL로 테이블 만들기
### 테이블 생성하기
```sql
USE naver_db;
DROP TABLE IF EXISTS member;
CREATE TABLE member -- 회원테이블
(   mem_id		CHAR(8) NOT NULL PRIMARY KEYmember, -- 회원 아이디(PK)
    mem_name    VARCHAR(10) NOT NULL, -- 이름
    mem_number	TINYINT NOT NULL, -- 인원수
    addr        CHAR(2) NOT NULL, -- 주소(경기, 서울, 경남 식으로 2글자만 입력)
    phone1		CHAR(3) NULL, -- 연락처의 국번(02, 031, 055 등)
    phone2		CHAR(8) NULL, -- 연락처의 나머지 전화번호(하이픈 제외)
    height		TINYINT UNSIGNED NULL, -- 평균 키
    debut_date	DATE NULL -- 데뷔 일자
)
```

```sql
DROP TABLE IF EXISTS buy;
CREATE TABLE buy -- 구매 테이블
(	num	INT AUTO_INCREMENT NOT NULL PRIMARY KEY, -- 순번(PK)
	mem_id CHAR(8) NOT NULL, -- 아이디(FK)
    prod_name CHAR(8) NOT NULL, -- 제품 이름
    group_name CHAR(4) NULL, -- 분류
    price INT UNSIGNED NOT NULL, -- 가격
    amount SMALLINT UNSIGNED NOT NULL, -- 수량
    FOREIGN KEY(mem_id) REFERENCES member(mem_id)
);
```
```sql
FOREIGN KEY(mem_id) REFERENCES member(mem_id)
```
이 테이블의 mem_id열을 member 테이블의 mem_id 열과 외래 키 관계로 연결하라는 의미입니다. 즉 이 테이블의 mem_id열은
혼자 존재 하는 것이 아니라, 꼭 member 테이블의 mem_id에도 값이 있어야 한다는 것입니다.

### 데이터 입력하기
```sql
INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015-10-19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016-8-8');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015-1-15');
```

## 제약 조건
### 기본 키 제약조건
기본 키: 데이터를 구분 할 수 있는 식별자
- 기본 키에 입력되는 값은 중복될 수 없으며, NULL 값이 입력될 수 없습니다.
  - ex) 대부분의 인터넷 쇼핑몰에서는 회원 테이블의 기본 키를 회원 아이디로 설정해 놓았다.
- 기본 키로 지정하면 클러스터형 인덱스가 자동으로 생성된다.
- 테이블은 기본 키를 1개만 가질 수 있습니다.
- 어떤 열에 설정해도 문제는 문법상 문제는 없으나 테이블의 특성을 가장 잘 반영하는 열을 선택하는 것이 좋습니다.

#### CREATE TABLE에서 설정
```sql
USE naver_db;
DROP TABLE IF EXISTS buy, member;
CREATE TABLE member
(   mem_id  CHAR(8) NOT NULL PRIMARY KEY, -- 열 이름 뒤에 붙혀주면 기본 키로 설정
    mem_name VARCHAR(10) NOT NULL,
    height TINYINT UNSIGEND NULL
);
```
```sql
USE naver_db;
DROP TABLE IF EXISTS member;
CREATE TABLE member
(   mem_id  CHAR(8) NOT NULL,
    mem_name VARCHAR(10) NOT NULL,
    height TINYINT UNSIGEND NULL,
    PRIMARY KEY (mem_id) -- 테이블의 제일 마지막에 붙여주면 그 열이 기본 키로 설정
);
```

#### ALTER TABLE에서 설정
이미 만들어진 테이블을 수정하는 ALTER TABLE 구문을 사용합니다.
```sql
DROP TABLE IF EXISTS member;
CREATE TABLE member
(   mem_id  CHAR(8) NOT NULL,
    mem_name VARCHAR(10) NOT NULL,
    height TINYINT UNSIGEND NULL,
);
ALTER TABLE member
    ADD CONSTRAINT 
    PRIMARY KEY (mem_id);
```

### 외래 키 제약조건
두 테이블 사이의 관계를 연결해주고, 그 결과 데이터의 무결성을 보장해주는 역할을 합니다.
외래 키가 설정된 열은 꼭 다른 테이블의 기본 키와 연결됩니다.

- 기준 테이블: 기본 키가 있는 테이블
- 참조 테이블: 외래 키가 있는 테이블

#### CREATE TABLE에서 설정
```sql
DROP TABLE IF EXISTS buy, member;
CREATE TABLE member
(   mem_id    CHAR(8) NOT NULL PRIMARY KEY,
    mem_name    VARCHAR(10) NOT NULL,
    height  TINYINT UNSIGNED NULL
);
CREATE TABLE buy
(
    num     INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    user_id CHAR(8) NOT NULL,
    prod_name CHAR(6) NOT NULL,
    FOREIGN KEY(user_id) REFERENCES member(mem_id)
);
```
```sql
FOREIGN KEY(mem_id) REFERENCES member(mem_id)
```
구매 테이블(buy)의 열(user_id)이 참조하는 기준 테이블(member)의 열(mem_id)은 기본 키로 
설정 되어 있다. 만약 기준 테이블의 열이 Primary Key 또는 Unique가 아니라면 외래 키 관계는 설정되지 않습니다.

#### ALTER TABLE에서 설정
```sql
DROP TABLE IF EXISTS buy;
CREATE TABLE buy
(   num     INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    mem_id  CHAR(8) NOT NULL,
    prod_name CHAR(6) NOT NULL
);
ALTER TABLE buy
    ADD CONSTRAINT
    FOREIGN KEY (mem_id) REFERENCES member(mem_id)
    ON UPDATE CASCADE -- 기존 테이블의 열 이름이 변경되면 참조 테이블도 변경
    ON DELETE CASCADE -- 기존 테이블의 데이터가 삭제되면 참조 테이블의 데이터도 삭제
```
### 고유 키 제약조건
고유 키 제약조건은 '중복되지 않는 유일한 값'을 입력해야하는 조건입니다. 
```plain text
기본 키 제약 조건 다른 점

- 고유 키 제약조건은 NULL 값을 허용
- NULL 값은 여러 개가 입력되어도 상관 X
- 기본 키는 테이블에 1개만 설정해야 하지만, 고유 키는 여러개도 설정 가능
```
```sql
DROP TABLE IF EXISTS buy, member;
CREATE TABLE member
(   mem_id    CHAR(8) NOT NULL PRIMARY KEY,
    mem_name    VARCHAR(10) NOT NULL,
    height  TINYINT UNSIGNED NULL,
    email   CHAR(30) NULL UNIQUE -- 중복은 허용하지 않지만, 비어 있는 값은 허용
);
```

### 체크 제약조건
입력되는 데이터를 점검하는 기능입니다.
```sql
DROP TABLE IF EXISTS member;
CREATE TABLE member
(   mem_id      CHAR(8) NOT NULL PRIMARY KEY,
    mem_name    VARCHAR(10) NOT NULL,
    height  TINYINT UNSIGNED NULL CHECK (height >= 100),
    phone1  CHAR(3) NULL
);
```
ALTER TABLE 문으로 제약조건을 추가해도 됩니다.
```sql
ALTER TABLE member
    ADD CONSTRAINT
    CHECK (phone 1 IN ('02', '031', '032', '054', '055', '061'));
```

### 기본값 정의
기본값 정의는 값을 입력하지 않았을 때 자동으로 입력될 값을 지정해 놓는 방법입니다.
```sql
DROP TABLE IF EXISTS member;
CREATE TABLE member
(   mem_id      CHAR(8) NOT NULL PRIMARY KEY,
    mem_name    VARCHAR(10) NOT NULL,
    height  TINYINT UNSIGNED DEFAULT 100,
    phone1  CHAR(3) NULL
);
```
ALTER TABLE 문으로 제약조건을 추가해도 됩니다.
```sql
ALTER TABLE member
    ALTER COLUMN phone1 SET DEFAULT '02';
```
기본값이 설정된 열에 기본값을 입력하려면 default라고 써주면 됩니다.
```sql
INSERT INTO member VALUES('RED', '레드벨벳', 161, '054');
INSERT INTO member VALUES('SPC', '우주소녀', default, default);
```

## 뷰

### 뷰의 형식
```sql
CREATE VIEW 뷰_이름
AS
    SELECT 문;
```
### 뷰를 사용하는 이유
1. 보안에 도움이 됩니다.
   - 뷰를 통해 한정된 정보만 제공을 하여 권한을 제한합니다.
   - 사용자마다 테이블에 접근하는 권한에 차별을 둬서 처리하도록 하여 보안을 강화합니다.
2. 복잡한 SQL을 단순하게 만들 수 있습니다.

매번 아래와 같은 복잡한 쿼리를 입력하는 것은 번거롭습니다.
```sql
SELECT B.mem_id, M.mem_name, B.prod_name, M.addr, CONCAT(M.phone1, M.phone2) '연락처'
    FROM buy B
        INNER JOIN member M
        ON B.mem_id = M.mem_id;
```
따라서 아래와 이 SQL을 다음과 같이 뷰로 생성해 놓고 해당 뷰에만 접근 할 수 있도록 합니다.
```sql
CREATE view v_memberbuy
AS 
    SELECT B.mem_id, M.mem_name, B.prod_name, M.addr, CONCAT(M.phone1, M.phone2) '연락처'
        FROM buy B
            INNER JOIN member M
            ON B.mem_id = M.mem_id;
```
v_memberbuy를 테이블이라고 생각하고 접근 할 수 있습니다.
```sql
SELECT * FROM v_memberbuy WHERE mem_name = '블랙핑크';
```
### 뷰의 실제 작동
#### 뷰의 실제 생성, 수정, 삭제
생성
```sql
USE market_db;
CREATE VIEW v_viewtest1
AS
        SELECT B.mem_id `Member ID`, M.mem_name AS `Member Name`,
            B.prod_name `Product Name`,
                        CONCAT(M.phone1, M.phone2) AS "Office Phone"
            FROM buy B
                INNER JOIN member M
                ON B.mem_id = M.mem_id;

SELECT DISTINCT `Member ID`, `Member Name` FROM v_viewtest1; -- 별칭을 사용할 때는 백틱(`)을 사용
```
수정
```sql
ALTER VIEW v_viewtest1
AS
    SELECT B.mem_id `회원 아이디`, M.mem_name AS '회원 이름',
        B.prod_name "제품 이름",
                    CONCAT(M.phone1, M.phone2) AS "연락처"
        FROM buy B
            INNER JOIN member M
            ON B.mem_id = M.mem_id;

SELECT  DISTINCT `회원 아이디`, `회원 이름` FROM v_viewtest1; -- 열 이름에 한글 사용 가능
```
삭제
```sql
DROP VIEW v_viewtest1;
```
#### 뷰의 정보 확인
```sql
USE market_db;
CREATE OR REPLACE VIEW v_viewtest2 -- DROP VIEW와 CREATE VIEW를 연속으로 작성한 효과
AS
    SELECT mem_id, mem_name, addr FROM member;
```
DESCRIBE 문으로 기존 뷰의 정보를 확인할 수 있습니다. PRIMARY KEY 등의 정보는 확인되지 않습니다.
```sql
DESCRIBE v_viewtest2;
```

## 인덱스
### 인덱스의 장단점
장점
- SELECT 문으로 검색하는 속도가 매우 빨라집니다.
- 그 결과 컴퓨터의 부담이 줄어들어서 결국 전체 시스템의 성능이 향상됩니다.
단점
- 인덱스도 공간을 차지해서 데이터베이스 안에 추가적인 공간이 필요합니다.
- 처음에 인덱스를 만드는데 시간이 오래 걸릴 수 있습니다.
- SELECT가 아닌 데이터의 변경 작업(INSERT, UPDATE, DELETE)이 자주 일어나면 오히려 성능이 나빠질 수 있습니다.
### 인덱스의 종류
#### 클러스터형 인덱스
기본 키로 지정하면 자동으로 그 열에 클러스터형 인덱스가 생성됩니다.
```sql
USE market_db;
CREATE TABLE table1 (
    col1 INT PRIMARY KEY , -- 기본 키로 지정
    col2 INT UNIQUE,
    col3 INT UNIQUE
);
```
- 기본 키는 테이블에 하나만 지정할 수 있습니다.
- 기본키와 더불어 고유 키도 인덱스가 자동을 생성됩니다.
- 클러스터형 인덱스가 생성된 열로 데이터가 자동 정렬 됩니다.

#### 보조형 인덱스
보조 인덱스를 생성해도 데이터의 순서는 변경되지 않고 별도로 인덱스를 만듭니다.
```sql
USE market_db;
CREATE TABLE table1 (
    col1 INT PRIMARY KEY ,
    col2 INT UNIQUE, -- 고유 키로 지정
    col3 INT UNIQUE
);
```
- 보조 인덱스는 여러개로 설정 할 수 있습니다.
### 인덱스의 내부 작동
인덱스는 균형 트리의 자료구조로 구성되어 있습니다.
#### 균형 트리의 개념
- 균형 트리 구조에서 데이터가 저장되는 공간을 **노드**라고 한다.
- MySQL에서는 **페이지**라고 부릅니다.
- 페이지는 최소한의 저장 단위로 16Kbyte(16384byte) 크기를 가집니다.
- 인덱스를 구성하면 INSERT 작업시에 페이지 분할이 발생해 성능에 영향을 줄 수도 있다.

### 인덱스의 실제 사용
인덱스 생성
```sql
CREATE [UNIQUE] INDEX 인덱스_이름
    ON 테이블_이름 (열_이름) [ASC | DESC]
```
인덱스 제거
```sql
DROP INDEX 인덱스_이름 ON 테이블_이름
```

### 인덱스를 효과적으로 사용하는 방법 
- 인덱스는 열 단위에 생성됩니다.
- WHERE 절에서 사용되는 열에 인덱스를 만들어야 합니다.
- WHERE 절에 사용되더라도 자주 사용해야 가치가 있습니다.
- 데이터의 중복이 높은 열은 인덱스를 만들어도 별 효과가 없습니다.
- 클러스터형 인덱스는 테이블당 하나만 생성할 수 있습니다.
