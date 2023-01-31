# HTTP

[인프런 | 김영한] 모든 개발자를 위한 HTTP 웹 기본 지식 (2023.01.27~)

## 인터넷 네트워크
### 인터넷 통신
**IP(인터넷 프로토콜)의 역할**
- 지정한 IP 주소(IP Address)에 데이터 전달
- 패킷(Packet)이라는 통신 단위로 데이터 전달

**TCP(전송 제어 프로토콜)의 특징**
- 연결지향 - TCP 3 way handshake(가상 연결)
- 데이터 전달 보증
- 순서 보장

**UDP(사용자 데이터그램 프로토콜) 특징**
- 하얀 도화지에 비유(기능이 거의 없음)
- 데이터 전달 및 순서가 보장되지 않지만, 단순하고 빠름
- IP와 거의 같다. +PORT +체크섬 정도만 추가
- 애플리케이션에서 추가 작업 필요

**PORT**
- 같은 IP내에서 프로세스 구분
- 0 ~ 65535 할당 가능
- 0 ~ 1023: 잘 알려진 포트, 사용하지 않는 것이 좋음
  - FTP - 20, 21
  - TELNET - 23
  - HTTP - 80
  - HTTPS - 443

**DNS**
- 도메인 네임 시스템(Domain Name System)
- 전화번호부
- 도메인 명을 IP 주소로 변환

## URI와 웹 브라우저 요청 흐름
### URI
- URI(Resource Identifier)
  - Uniform: 리소스 식별하는 통일된 방식
  - Resource: 자원, URI로 식별할 수 있는 모든 것 (제한 없음)
  - Identifier: 다른 항목과 구분하는데 필요한 정보
- URL(Resource Locator)
  - Locator: 리소스가 있는 위치를 지정
- URN(Resource Name)
  - Name: 리소스에 이름을 부여

### URL 전체 문법
- scheme://[userinfo@]host[:port][/path][?query][#fragment]
- https://www.google.com:443/search?q=hello&hl=ko
  - scheme
    - 주로 프로토콜 사용
    - 프로토콜: 어떤 방식으로 자원에 접근할 것인가 하는 약속 규칙
    - 예) http, https, ftp 등등
    - http는 80포트, https는 443포트를 주로 사용, 포트는 생략 가능
    - https는 http에 보안 추가 (HTTP Secure)
  - userinfo
    - URL에 사용자정보를 포함해서 인증
    - 거의 사용하지 않음
  - 호스트명
    - 도메인명 또는 IP 주소를 직접 사용가능
  - PORT
    - 일반적으로 생략, 생략시 http는 80, https는 443
  - path
    - 리소스 경로(path), 계층적 구조
    - 예) 
      - /home/file1.jpg
      - /members
      - /members/100, /itmes/ihone12
  - query
    - key=value 형태
    - ?로시작, &로 추가 가능 ?keyA=valueA&keyB=valueB
    - query parameter, query string 등으로 불림, 웹서버에 제공하는 파라미터, 문자 형태
  - fragment
    - html 내부 북마크 등에 사용
    - 서버에 전송하는 정보 아님
### 웹 브라우저 요청 흐름
- https://www.google.com:443/search?q=hello&hl=ko
- 예) 웹 브라우저(IP: 100.100.100.1), 구글 서버(IP: 200.200.200.2)
1. 웹 브라우저가 DNS 서버를 조회 -> IP: 200.200.200.2와 포트(443) 정보 획득
2. HTTP 요청 메시지 생성
```
GET /search?q=hello&hl=ko HTTP/1.1
HOST: www.google.com
```
3. SOCKET 라이브러리를 통해 전달
   - A: TCP/IP 연결(IP, PORT)
   - B: 데이터 전달
4. TCP/IP 패킷 생성, HTTP 메시지 포함, 서버로 전송
5. 서버에서 HTTP 응답 메시지 생성
```
HTTP/1.1 200 OK
Content-Type: text/html;charset=UTF-8
Content-Length: 3423

<html>
  <body>...</body>
</html>
```
6. 웹 브라우저 HTML 렌더링

## HTTP 기본
- HTTP: HyperText Transfer Protocol
- 거의 모든 형태의 데이터 전송 가능
- 서버간에 데이터를 주고 받을 때도 대부분 HTTP 사용
### HTTP 특징
#### 클라이언트 서버 구조
- Request Response 구조
- 클라이언트는 서버에 요청을 보내고, 응답을 대기
- 서버가 요청에 대한 결과를 만들어서 응답
#### 무상태 프로토콜(스테이스리스)
- 서버가 클라이언트의 상태를 보존X
- 장점: 서버 확장성 높음(스케일 아웃)
  - 갑자기 고객이 증가해도 점원을 대거 투입할 수 있다.
  - 갑자기 클라이언트 요청이 증가해도 서버를 대거 투입할 수 있다.
  - 무한한 서버 증설 가능
  - 단점: 클라이언트가 추가 데이터 전송
#### 실무 한계
- 모든 것을 무상태로 설계 할 수 있는 경우도 있고 없는 경우도 있다.
- 무상태
  - 예) 로그인이 필요 없는 단순한 서비스 소개 화면
- 상태 유지
  - 예) 로그인
- 로그인한 사용자의 경우 로그인 했다는 상태를 서버에 유지
- 일반적으로 브라우저 쿠키와 서버 세션등을 사용해서 상태 유지
- 상태 유지는 최소한만 사용
#### 비연결성
- HTTP는 기본이 연결을 유지하지 않는 모델
- 일반적으로 초 단위의 이하의 빠른 속도로 응답
- 1시간 동안 수천명이 서비스를 사용해도 실제 서버에서 동시에 처리하는 요청은 수십개 이하로 매우 작음
- 서버 자원을 매우 효율적으로 사용할 수 있음 
#### HTTP 메시지
##### 메시지 구조
```
start-line 시작 라인
header 헤더
empty line 공백 라인 (CRLF)
message body
```
1. **시작 라인**
- start-line = request-line / status-line 
  - 요청메시지
    - request-line = method SP(공백) request-target SP HTTP-version CRLF(엔터)
      - HTTP 메서드
      - 요청 대상 (/search?q=hello&hl=ko)
      - HTTP version
  - 응답메시지
    - status-line = HTTP-version SP status-code SP reason-phrase CRLF
      - HTTP 버전
      - HTTP 상태코드: 요청 성공, 실패를 나타냄
        - 200: 성공
        - 400: 클라이언트 요청 오류
        - 500: 서버 내부 오류
      - 이유 문구: 사람이 이해할 수 있는 짧은 상태 코드 설명 글

2. **헤더**
- HTTP 전송에 필요한 모든 부가정보
  - 예) 메시지 바디의 내용, 메시지 바디의 크기, 압축, 인증, 요청 클라이언트(브라우저) 정보, 서버 애플리케이션 정보, 캐시 관리 정보
- 표준 헤더가 너무 많음
- 필요시 임의의 헤더 추가 가능

3. **메시지 바디**
- 실제 전송할 데이터
- HTML 문서, 이미지, 영상, JSON 등등 byte로 표현할 수 있는 모든 데이터 전송 가능

## HTTP 메서드
URI 설계에서 가장 중요한 것은 **리소스 식별**이다.
### 리소스의 의미
- 회원을 등록하고 수정하고 조회하는게 리소스가 아니다.
- 예) 미네랄을 캐라 -> 미네랄이 리소스
- 회원이라는 개념 자체가 리소스이다.
- 회원을 등록하고 수정하고 조회하는 것을 모두 배제
- 회원이라는 리소스만 식별하면 된다 -> 회원 리소스를 URI에 매핑

### API URI 설계
- 리소스와 행위를 분리해야한다.
  - 리소스: 회원
  - 행위: 조회, 등록, 삭제, 변경
- 리소스는 명사, 행위는 동사

## HTTP 헤더

## HTTP 캐시