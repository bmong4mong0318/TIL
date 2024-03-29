# SQL 함수 정리

### DATE_FORMAT() 
DATE_FORMAT(날짜, 형식): 날짜를 지정한 항셕으로 출력합니다.
```sql
SELECT DATE_FORMAT(변경하기 원하는 값 또는 칼럼,'%Y-%m-%d') AS 컬럼명 FROM 테이블명
-- 2022-12-29 출력
```

### YEAR()
날짜, 시간과 관련된 함수 중 하나입니다.
```sql
SELECT YEAR(NOW()) FROM 테이블명
-- 2022 출력
```

### ROUND()
지정한 자리에서 반올림하는 함수입니다. 
0이 소수점 첫째 자리이므로 1은 소수점 둘째 자리에서 반올림, -1은 정수 첫째 자리에서 반올림하겠다는 의미입니다.
```sql
ROUND(숫자 or 열 이름, 반올림 할 자리값)
```

### UNION()
각각에 쿼리에서 나온 데이터를 하나로 합쳐주는 역할을 하고 있으며, 중복되는 값도 그대로 출력이 됩니다.
```sql
SELECT ID, NAME FROM TABLE1;
 UNION ALL
 SELECT ID, NAME FROM TABLE2;
```
중복되는 부분은 하나에 로우로만 출력이 됩니다.
```sql
SELECT ID, NAME FROM TABLE1;
 UNION
 SELECT ID, NAME FROM TABLE2;
```