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

## HTTP 메서드

## HTTP 헤더

## HTTP 캐시