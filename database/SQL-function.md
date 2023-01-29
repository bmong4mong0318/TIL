# SQL 함수 정리


### DATE_FORMAT() 
DATE_FORMAT(날짜, 형식): 날짜를 지정한 항셕으로 출력
```sql
SELECT DATE_FORMAT(NOW(),'%Y-%m-%d') AS 컬럼명 FROM 테이블명
-- 2022-12-29 출력
```

### YEAR()
날짜, 시간과 관련된 함수 중 하나이다.
```sql
SELECT YEAR(NOW()) FROM 테이블명
-- 2022 출력
```