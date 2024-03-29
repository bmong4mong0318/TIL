![img](https://assets.lulu.com/cover_thumbs/1/5/15gjeeky-front-shortedge-384.jpg)

[PDF:Operating Systems: Three Easy Pieces](https://pages.cs.wisc.edu/~remzi/OSTEP/)

- [4. 프로세스의 개념](#4-프로세스의-개념)
  - [프로세스](#프로세스)
    - [하드웨어 상태](#하드웨어-상태)
  - [프로세스 생성](#프로세스-생성)
    - [프로그램 실행 과정에서 운영체제가 하는 일](#프로그램-실행-과정에서-운영체제가-하는-일)
  - [프로세스 상태](#프로세스-상태)
  - [자료 구조](#자료-구조)
- [5. 프로세스 API](#5-프로세스-api)
- [6. 제한적 직접 실행 원리(Limited Direct Execution)](#6-제한적-직접-실행-원리limited-direct-execution)
  - [기본 원리: 제한적 직접 실행](#기본-원리-제한적-직접-실행)
  - [문제점 1: 제한된 연산](#문제점-1-제한된-연산)
    - [trap 명령어 사용시 주의점](#trap-명령어-사용시-주의점)
    - [LDE 방식의 두단계](#lde-방식의-두단계)
  - [문제점 2: 프로세스 간 전환](#문제점-2-프로세스-간-전환)
    - [협조 방식: 시스템 호출시 까지 대기](#협조-방식-시스템-호출시-까지-대기)
    - [비협조 방식: 운영체제가 제어권 확보](#비협조-방식-운영체제가-제어권-확보)
- [주소 공간 (address space)](#주소-공간-address-space)
- [주소 변환 (address translation)](#주소-변환-address-translation)
- [17. 세그멘테이션](#17-세그멘테이션)
- [18. 페이징: 개요](#18-페이징-개요)
  - [페이지 테이블](#페이지-테이블)
  - [예시](#예시)
  - [페이지 테이블이 저장되는 곳](#페이지-테이블이-저장되는-곳)
  - [페이지 테이블의 구성](#페이지-테이블의-구성)
    - [선형 페이지 테이블](#선형-페이지-테이블)
  - [페이징: 너무 느림](#페이징-너무-느림)
    - [각 메모리 참조 시 일어나느 세부 동작](#각-메모리-참조-시-일어나느-세부-동작)
  - [메모리 트레이스](#메모리-트레이스)
- [19. 페이징: 더 빠른 변환(TLB)](#19-페이징-더-빠른-변환tlb)
  - [TLB 제어 흐름 알고리즘](#tlb-제어-흐름-알고리즘)
  - [예제: 배열 접근](#예제-배열-접근)
    - [지역성](#지역성)
  - [TLB 미스의 처리](#tlb-미스의-처리)
    - [CISC(complex-instruction set computers)](#cisccomplex-instruction-set-computers)
    - [RISC(reduced instruction set computing)](#riscreduced-instruction-set-computing)
- [20. 페이징: 더 작은 테이블](#20-페이징-더-작은-테이블)
  - [더 큰 페이지](#더-큰-페이지)
  - [하이브리드: 페이장과 세그먼트](#하이브리드-페이장과-세그먼트)
  - [멀티 레벨 페이지 테이블](#멀티-레벨-페이지-테이블)
    - [멀티 레벨 페이지 테이블의 장점](#멀티-레벨-페이지-테이블의-장점)
    - [단점](#단점)
  - [역 페이지 테이블](#역-페이지-테이블)
  - [페이지 테이블을 디스크로 스와핑](#페이지-테이블을-디스크로-스와핑)
- [21. 물리 메모리 크기의 극복: 메커니즘](#21-물리-메모리-크기의-극복-메커니즘)
  - [스왑 공간](#스왑-공간)
  - [Present Bit](#present-bit)
  - [페이지 폴트](#페이지-폴트)
  - [페이지 폴트의 처리](#페이지-폴트의-처리)
    - [페이지 오류 제어 흐름의 알고리즘 (하드웨어)](#페이지-오류-제어-흐름의-알고리즘-하드웨어)
    - [페이지 오류 제어 흐름의 알고리즘 (소프트웨어)](#페이지-오류-제어-흐름의-알고리즘-소프트웨어)
  - [교체가 일어나는 때](#교체가-일어나는-때)
  - [요약](#요약)
- [22. 물리 메모리 크기의 극복: 정책](#22-물리-메모리-크기의-극복-정책)
  - [캐시 관리](#캐시-관리)
  - [최적 교체 정책](#최적-교체-정책)
  - [간단한 정책: FIFO](#간단한-정책-fifo)
  - [무작위 선택](#무작위-선택)
  - [과거 정보의 사용: LRU](#과거-정보의-사용-lru)
  - [워크로드에 따른 성능 비교](#워크로드에-따른-성능-비교)
  - [과거 이력 기반 알고리즘의 구현](#과거-이력-기반-알고리즘의-구현)
  - [LRU 정책 근사하기](#lru-정책-근사하기)
    - [use bit(or reference bit)](#use-bitor-reference-bit)
    - [시계 알고리즘(clock algorithm)](#시계-알고리즘clock-algorithm)
  - [갱신된 페이지(Dirty Page)의 고려](#갱신된-페이지dirty-page의-고려)
  - [다른 VM 정책들](#다른-vm-정책들)
    - [요구 페이징(damand paging) 정책](#요구-페이징damand-paging-정책)
    - [클러스터링](#클러스터링)
  - [쓰레싱(Thrashing)](#쓰레싱thrashing)
- [26. 병행성: 개요](#26-병행성-개요)
  - [프로세스와 쓰레드의 큰 차이점 몇가지](#프로세스와-쓰레드의-큰-차이점-몇가지)
  - [왜 쓰레드를 사용하는가?](#왜-쓰레드를-사용하는가)
  - [예제: 쓰레드 생성](#예제-쓰레드-생성)
  - [데이터의 공유](#데이터의-공유)
  - [제어 없는 스케줄링](#제어-없는-스케줄링)
  - [원자성에 대한 바람](#원자성에-대한-바람)
- [27. 쓰레드 API](#27-쓰레드-api)
- [28. 락](#28-락)
  - [락: 기본 개념](#락-기본-개념)
  - [Pthread 락](#pthread-락)
  - [락의 평가기준](#락의-평가기준)
  - [인터럽트 제어](#인터럽트-제어)
  - [실패한 시도: 오직 load/store 명령어만 사용하기](#실패한-시도-오직-loadstore-명령어만-사용하기)
  - [Test-And-Set](#test-and-set)

## 4. 프로세스의 개념

프로그램: 디스크 상에 존재하며 실행을 위한 명령어와 정적 데이터의 묶음이다. 이 명령어와 데이터 묶음을 읽고 실행하여 프로그램에 생명을 불어넣는 것이 운영체제이다.

운영체제는 CPU를 **가상화**하여 적은 개수의 CPU가 무한개에 가까운 CPU가 있는 듯한 환상을 만든다.

**시분할(time sharing)** 이라 불리는 이 기업은 원하는 수 만큼의 프로세스를 동시에 실행할 수 있게 한다.

### 프로세스

**프로세스(process)**: 실행 중인 프로그램

#### 하드웨어 상태

프로세스가 실행되는 동안 하드웨어 상태를 읽거나 갱신할 수 있으며, 프로세스의 구성 요소를 이해하기 위해서 하드웨어 상태를 이해해야 한다.

- **메모리**: 프로세스가 접근 할 수 있는 메모리(**주소 공간(address space)**)는 프로세스를 구성하는 요소이다.
- **레지스터**: 레지스터란 CPU가 요청을 처리하는데 필요한 데이터를 일시적으로 저장하는 기억장치이다. CPU 내부의 임시 저장장치인 레지스터를 사용해 명령을 빠르게 수행할 수 있다.
  - PC (Program Counter)
    - 다음에 수행될 명렁어의 주소를 저장하는 레지스터
  - IR (Instruction Register)
    - 현재 실행 중인 명령을 기억하는 레지스터
  - 스택 포인터 (stack pointer), 프레임 포인터 (frame pointer)
    - 함수의 변수와 리턴주소를 저장하는 스택을 관리할 때 사용

### 프로세스 생성

#### 프로그램 실행 과정에서 운영체제가 하는 일

1. 코드와 정적 데이터를 메모리, 프로세스의 주소공간에 **탑재(load)**.
   - 프로그램은 **디스크** 또는 플래시 기반 **SSD**에 특정 **실행 파일 형식**으로 존재한다.
   - 코드와 정적 데이터를 메모리에 탑재하기 위해서 운영체제는 디스크의 해당 바이트를 읽어서 메모리의 어딘가에 저장해야 한다.
   - 프로그래을 실행하면서 코드나 데이터가 필요할 때 필요한 부분만 메모리에 탑재한다.
     - ex) 페이징(paging), 스와핑(swapping)
2. 특정 크기의 메모리 공간이 프로그램에 **스택(run-time stack)** 용도로 할당되어야 한다.
   - main() 함수 인자인 argc와 argv 벡터를 사용하여 스택을 초기화한다.
3. **힙(heap)**을 위한 메모리 영역을 할당한다.
   - 프로그램이 실행되면 malloc 라이브러리 API를 호출하여 메모리를 요청하고, 운영체제가 이를 충족하도록 메모리를 할당한다.
4. 입출력과 관계된 초기화 작업을 수행.
   - ex) UNIX 시스템에서 각 프로세스는 기본적으로 표준 입력(STDIN), 표준 출력(STDOUT), 표준 에러(STDERROR) 장치에 해당하는 세 개의 **파일 디스크럽터(file descriptor)** 를 갖는다.

### 프로세스 상태

![process_state](../img/process-state.png)

- new : 프로세스가 생성된 상태입니다. OS 커널에 존재하는 Ready queue에 올라가면 ready 상태가 됩니다.

- ready : 프로세스가 CPU로부터 메모리 공간을 할당받길 기다리는 상태입니다. 이때 프로세스 스케줄러에 의해 프로세스가 할당을 받게 되면 running 상태가 됩니다. 이것을 dispatch 라고 합니다.

- running : 명령어들이 실행되는 상태입니다.

- waiting : 특정 event가 발생하길 기다리는 상태입니다. 이때 I/O나 특정 event가 완료되면 ready상태로 변합니다.

- terminated: 프로세스가 실행을 끝마친 상태입니다.

### 자료 구조

**프로세스 리스트(process list)**: 프로세스 상태를 파악하기 위해 준비 상태의 프로세스들을 저장.

**레지스터 문맥(register context)**: 프로세스가 중단되었을 때 해당 프로세스의 페지스터 값들을 저장한다. 이 레지스터값들을 복원하여 (해당 값을 실제 물리 레지스터에 다시 저장함으로써) 운영체제는 프로세스 실행을 재개한다.

## 5. 프로세스 API

// skip

## 6. 제한적 직접 실행 원리(Limited Direct Execution)

CPU 시간을 나누어 씀으로써 가상화를 구현할 수 있다. 가상화 기법을 구현하기 위해서는 몇가지 문제를 해결해야 한다.

1. 성능 저하
   - 시스템에 과도한 오버헤드를 주지 않으면서 가상화를 구현해야 한다.
2. 제어 문제
   - CPU에 대한 통제를 유지하면서 프로세스를 효율적으로 실행시킬 수 있는 방법이 필요하다.

### 기본 원리: 제한적 직접 실행

**제한적 직접 실행(Limited Direct Execution)**: 프로그램을 CPU 상에서 직접 실행하는 것.

### 문제점 1: 제한된 연산

직접 실행의 장점은 빠르게 실행된다는 것이다. 기본적으로 프로그램이 하드웨어 CPU에서 실행되기 때문이다.

프로세스가 특수한 종류의 연산(디스크 입출력 요청이나, CPU 또는 메모리와 같은 시스템 자원에 대한 추가할당 요청)을 수행하길 원한다면?

- **사용자 모드(user mode)**: 사용자 모드에서 실행되는 코드는 할 수 있는 일이 제한된다.

- ex) 프로세스가 사용자 모드에서 실행 중이면 입출력 요청을 할 수 없도록 설정한다.

  - 이때 입출력 요청을 하면 프로세서가 예외를 발생시키고, 운영체제는 해당 프로세스를 제거한다.

- **커널 모드(kernel mode)**: 사용자 모드와 대비되는 모드로서 운영체제의 중요한 코드들이 실행된다. 이 모드에서 실행되는 코드는 모든 특수한 명령어를 포함하여 원하는 모든 작업을 수행할 수 있다.

- **시스템 콜**: 파일 시스템 접근, 프로세스 생성 및 제거, 다른 프로세스와의 통신 및 메모리 할당등의 기능 제공

시스템 콜을 실행하기 위해 프로그램은 **trap** 특수 명령어를 실행해야 한다. 이 명령어는 커널 안으로 분기하는 동시에 특권 수준을 커널 모드로 상향 조정한다.

커널 모드로 진입하면 운영체제는 모든 명령어를 실행할 수 있고 이를 통하여 프로세스가 요청한 작업을 처리할 수 있다.

완료되면 운영체제는 **return-from-trap** 특수 명령어를 호출한다. 이 명령어는 특권 수준을 사용자 모드로 다시 하향 조정하면서 호출한 사용자 프로그램을 리턴한다.

#### trap 명령어 사용시 주의점

운영체제가 return-from-trap 명령어 실행 시 사용자 프로세스로 제대로 리턴할 수 있도록 호출한 프로세스의 필요한 레지스터들을 저장해야 한다.

- ex) x86에서는 프로그램 카운터, 플래그와 다른 몇개의 레지스터를 각 프로세스의 **커널 스택(kernel stack)** 에 저장한다. return-from-trap 명령어가 이 값들을 스택에서 pop하여 사용자모드 프로그램의 실행을 다시 시작한다.

커널은 부팅시에 **트랩 테이블(trap)** 을 만들고 이를 이용하여 시스템을 통제한다.

운영체제가 하는 초기 작업 중 하나는 하드웨어에게 예외 사건이 일어났을때 어떤 코드를 실행해야 하는지 알려주는 것이다.

운영체제는 특정 명령어를 사용하여 하드웨어에게 **트랩 핸들러(trap handler)** 의 위치를 알려준다.

하드웨어는 이 정보를 전달받으면 해당 위치를 기억하고 있다. 따라서 시스템 콜과 같은 예외적인 사건이 발생했을 때 하드웨어는 무엇을 해야 할지 알 수 있다.

모든 시스템 콜은 자신의 고유 번호를 갖는다. 사용자 프로그램은 원하는 시스템 콜을 호출하기 위해서, 해당 시스템콜 번호를 레지스터 또는 스택의 지정된 위치에 저장한다. 그리고 trap 명령어를 호출한다. 그리고 이를 처리하는 trap 핸들러가 실행된다.

운영체제는 시스템 콜 코드의 시작 위치를 사용자 프로그램으로부터 숨김으로써, 사용자는 시스템 콜 번호를 이용하여 커널에게 시스템 콜의 실행을 요청해야 한다. 커널 코드의 무분별한 실행을 방지하기 위한 일종의 보안기법이다.

#### LDE 방식의 두단계

1. **부팅시에** 커널은 트랩 테이블을 초기화하고 CPU는 나중에 사용하기 위하여 테이블의 위치를 기억한다. 커널은 이러한 작업을 커널 모드에서만 사용할 수 있는 명령어를 이용하여 수행한다.

2. **프로세스를 실행할 떼** return-from-trap을 이용하여 사용자 프로세스를 시작할때 몇 가지 작업을 수행한다. 새로운 프로세스를 위한 노드를 할당하여 프로세스 리스트에 삽입하고, 메모리를 할당하는 등의 작업이 포함된다.

### 문제점 2: 프로세스 간 전환

#### 협조 방식: 시스템 호출시 까지 대기

CPU를 장기간 사용해야하는 프로세스들은 다른 프로세스들이 CPU를 사용할 수 있도록 주기적으로 CPU를 반납할 것이리라 믿는다.

협조 방식을 사용하는 운영체제는 yield 시스템 콜을 제공한다. 이 시스템 콜은 운영체제에게 제어를 넘겨 운영체제가 CPU를 다른 프로세스에게 할당할 수 있는 기회를 제공한다.

응용 프로그램이 비정상적인 행위를 하게되면 운영체제에게 제어가 넘어간다. 예를 들어 응용 프로그램이 어떤 수를 0으로 나누는 연산을 실행하거나 허가되지 않은 메모리에 접근을 시도하면 운영체제로의 **트랩** 이 일어난다. 그러면 운영체제는 다시 CPU를 획득하여 해당 프로세스를 종료할 수 있다.

협조 방식의 스케줄링 시스템은 근본적으로 수동적이다. CPU 제어권 획들을 위해 운영체제는 시스템 콜이 호출되기를 기다리거나 불법적인 연산이 일어나기를 대기하는 것이다. 만약 프로세스가 무한 루프에 빠져 시스템 콜을 호출할 수 없다면 문제가 발생할 수 있다.

#### 비협조 방식: 운영체제가 제어권 확보

// restart from here

## 주소 공간 (address space)

프로세스마다 각각의 메모리 공간이 별개로 할당된다.
protection을 위해 address space를 만든다.

## 주소 변환 (address translation)

MMU(memmory management unit)같은 하드웨어를 통해 이루어진다.

## 17. 세그멘테이션

## 18. 페이징: 개요

프로세스의 주소 공간을 몇 개의 가변 논리 세그먼트로 나누는 것이 아니라 고정 크기의 단위로 나눈다. 이 각각의 고정 크기의 단위를 **페이지(page)** 라고 부른다.

### 페이지 테이블

- 주소 공간의 각 가상 페이지에 대한 물리 메모리 위치 기록을 위하여 운영체제는 프로세스 마다
  **페이지 테이블(page table)** 이라는 자료구조를 유지한다.

- 페이지 테이블의 주요역할: 가상 페이지 **주소 변환(address translation)** 정보를 저장한다. 각 페이지가 저장된 물리 메모리의 위치를 알려준다.

- 페이지 테이블은 프로세스마다 존재한다.

### 예시

```assembly
movl <virtual address>, %eax
```

주소 `<virtual address>`의 데이터를 eax 레지스터에 탑재

1. 프로세스가 생성한 가상 주소의 변환을 위해 먼저 가상 주소를 **가상 페이지 번호(virtual page number, VPN)** 와 페이지 내의 **오프셋** 2개의 구성요소로 분할한다.

2. 프로세스가 가상 주소를 생성하면 운영체제와 하드웨어가 의미있는 물리 주소로 변환한다.

```assembly
movl 21, %eax
```

- 21을 이진 형식으로 변환하면 "010101"을 얻는다.
- 이 가상 주소를 검사하고 가상 페이지 번호와 오프셋으로 나눈다.
  > 가상 주소 "21"은 가상 페이지 "01"(또는 1)의 5번째("0101"번째) 바이트이다.
- 이 가상 페이지 번호를 가지고 페이지 테이블의 인덱스로 사용하여 가상페이지 1이 어느 물리 프레임에 저장되어 있는지 찾을 수 있다.
- 위의 페이지 테이블에서 **물리 프레임 번호(physical frame number, PFN)** 는 7(111)이다 (예시로)
- VPN을 PFN으로 교체하여 가상 주소를 변환 할 수 있다. 그런 후에 물리 메모리에 탑재 명령어를 실행한다.
  - "01 0101" -> "111 0101" (이때 오프셋은 동일하다)
- 최종적으로 계산된 물리 주소는 "1110101"(십진수 117)이며, 이곳이 탑재할 데이터가 저장된 정확한 위치이다.

### 페이지 테이블이 저장되는 곳

페이지 테이블은 매우 커질 수 있기 때문에 현재 실행 중인 프로세스 페이지 테이블을 저장 할 수 있는 회로를 MMU안에 저장 하지 않는다. 대신 각 프로세스의 페이지 테이블을 메모리에 저장한다.

### 페이지 테이블의 구성

#### 선형 페이지 테이블

운영체제는 원하는 물리 프레임 번호(PFN)를 찾기 위해서 가상 페이지 번호(VPN)로 배열의 항목에 접근하고 그 항목의 페이지 테이블 항목(PTE)을 검색한다.

각 PTE에는 심도있는 이해가 필요한 비트들이 존재한다.

- Valid bit: 특정 변환의 유효 여부를 나타내기 위하여 포함된다.
  - 프로그램이 실행을 시작할 때 코드와 힙이 주소 공간의 한쪽에 있고 반대쪽은 스택이 차지하고 있을 것이다. 그 사이의 모든 미사용 공간은 무효(invalid)로 표시되고, 프로세스가 그런 메모리를 접근하려고 하면 운영체제에 트랩을 발생시킨다.
  - 주소 공간의 미사용 페이지를 모두 표시함으로써 이러한 페이지들에게 물리 프레임을 할당할 필요를 없애 대량의 메모리를 절약한다.
- Potection bit: 페이지가 읽을 수 있는지, 쓸 수 있는지, 또는 실행 될 수 있는지를 표시한다.
  - protection bit가 허용하지 않는 방식으로 페이지에 접근하려고 하면 운영체제에서 트랩을 생성한다.
- Present bit: 이 페이지가 물리 메모리에 있는지 혹은 디스크에 있는지(즉, 스왑 아웃되었는지) 가리킨다.
  - 스와핑은 운영체제가 드물게 사용되는 페이지를 디스크로 이동시켜 물리 메모리를 비울 수 있게 한다.
- Dirty bit: 메모리에 반입된 후 페이지가 변경되었는지 여부를 나타낸다.
- Reference bit: 페이지가 접근되었는지를 추적하기 위해 사용한다.

### 페이징: 너무 느림

페이지 테이블의 크기가 메모리상에서 매우 크게 증가할 수 있다. 이로 인해 처리 속도가 저할 될 수 있다.

```assembly
movl 21, %eax
```

주소 21에 대한 참조만 고려하고 명령어 반입에 대해서는 고려하지 않기로 한다.
이 예에서 하드웨어가 주소 변환을 담당한다고 가정한다.

원하는 데이터를 가져오기 위해서 먼저 시스템은 가상 주소(21)을 정확한 물리 주소(117)로 변환해야 한다. 주소 117에서 데이터를 반입하기 전에 시스템은 프로세스의 페이지 테이블에서 적절한 페이지 테이블 항목을 가져와야 하고, 변환을 수행한 후, 물리 메모리에서 데이터를 탑재한다. 이를 위해서 하드웨어는 현재 실행 중인 프로세스의 페이지 테이블의 위치를 알아야 한다. 원하는 PTE의 위치를 찾기 위해 하드웨어는 다음과 같은 연산을 수행한다.

```
VPN = (VirtualAddress & VPN_MASK) >> SHIFT
PTEAddr = PageTableBaseRegister + (VPN * seizof(PTE))
```

이 예제에서 VPN_MASK는 0x30(16진수 30 또는 이진수 110000)으로 설정되고, 전체 가상 주소에서 VPN 비트만 골라낸다. SHIFT는 4로 설정되고(오프셋 비트 수), 올바른 정수 가상 페이지 번호를 형성하기 위해 VPN 비트를 오른쪽으로 이동시킨다.

- 가상 주소 21(010101)을 마스킹하면 010000이 되고,
- 우측 방향으로 비트를 이동시켜 01 또는 우리가 원하는 가상 페이지 1로 변환한다.

이 값을 페이지 테이블 베이스 레지스터가 가리지는 PTE 배열에 대한 인덱스로 사용한다.

```
offset = VirtualAddress & OFFSET_MASK
PhysAddr = (PFN << SHIFT) | offset
```

이 물리주소가 알려지면 하드웨어는 메모리에서 PTE를 반입할 수 있고, PFN을 추출하고 가상 주소의 오프셋과 연결하여 원하는 물리 주소를 만들 수 있다.

마지막으로, 하드웨어는 메모리에서 원하는 데이터를 가져와서 eax 레지스터에 넣을 수 있다.
이제 프로그램은 메모리로부터 값을 성공적으로 탑재하였다.

#### 각 메모리 참조 시 일어나느 세부 동작

```
1 // 가상 주소에서 VPN 추출
2 VPN = (VirtualAddress & VPN_MASK) >> SHIFT
3 // 페이지 테이블 항목 (PTE) 의 주소 형성
4 PIEAddr = PTBR + (VPN * SiZeOE (PTE))
5 // PTE 반입
6 PIE = AccessMemory (PTEAddr)
7 // 프로세스가 페이지를 접근할 수 있는지 확인
8 if (PTE. Valid == False)
9     RaiseException (SEGMENTATION _FAULT)
10 else if (CanAccess (PTE.ProtectBits) == False)
11    RaiseException (PROTECTION_FAULT)
12 else
13    //접근 가능하면 물리 주소 만들고 값 가져오기
14    offset = VirtualAddress & OFFSET_MASK
15    PhysAddr = (PTE.PFN << PFN_SHIFT) | offset
16    Register = AccessMemory (PhysAddr)
```

- 모든 메모리 참조에 대해 먼저 페이지 테이블에서 변환 정보를 반입해야 하기 때문에 반드시 한번의 추가적인 메모리 참조가 필요하다.
- 메모리 참조는 비용이 비싸고 이 경우에 프로세스는 2배 이상 느려진다.

결론: **하드웨어와 소프트웨어의 신중한 설계 없이는 페이지 테이블로 인해 시스템이 매우 느려질 수 있으며 너무 많은 메모리를 차지한다.**

### 메모리 트레이스

```c
int array[1000];
...
for (int i = 0; i < 1000; i++)
  array[i] = 0;
```

우리는 array.c를 컴파일하고 다음과 같이 실행한다.

```shell
prompt> gcc -o array array.c -Wall -O
prompt> ./array
```

array.c의 어셈블리 코드

```assembly
1024 movl $0x0, (%edi, %eax, 4)
1028 incl %eax
102c cmp1 $0x03e8,%eax
1030 jne 0x1024
```

위 코드는 x86 어셈블리어로 작성된 코드로서, 주소 계산과 메모리 초기화 기능을 수행하는 반복문으로 구성되어 있습니다.

1. `movl $0x0, (%edi, %eax, 4)` 구문은 `%eax` 레지스터와 4를 곱한 값에 `%edi` 레지스터의 값(주소)을 더한 주소에 0을 저장합니다. 이는 0으로 초기화된 4바이트 워드를 메모리에 저장하는 기능을 합니다.

2. `incl %eax` 구문은 `%eax` 레지스터의 값을 1 증가시킵니다. 이는 다음에 초기화할 메모리 위치의 주소를 계산하기 위한 용도입니다.

3. `cmp1 $0x03e8,%eax` 구문은 `%eax` 레지스터의 값이 1000(0x03e8)인지 비교합니다. 만약 같지 않으면, `jne 0x1024` 구문으로 인해 반복문의 시작점으로 점프하여 다시 초기화를 수행합니다. 이는 1000개의 워드를 초기화할 때까지 계속 반복하는 기능을 합니다.

따라서, 이 코드는 `%edi`가 가리키는 메모리 위치부터 0으로 초기화된 1000개의 4바이트 워드를 만드는 기능을 수행합니다.

이 명령어 시퀀스가 어떤 메모리 접근을 생성하는지 이해하기 위해서는 몇가지 가정이 필요하다.

```
- 64KB의 가상 주소 공간을 가정한다.
- 페이지의 크기는 1KB로 가정한다.
- 선형 페이지 테이블이고 물리 주소 1KB(1024)에 위치한다고 가정한다.
- 페이지 크기가 1KB(1024)이기 때문에 가상 주소 1024는 가상 주소 공간의 두번째 페이지(VPN=1)에 상주한다.(VP=0이 첫번째 페이지이기 때문에)
- 이 가상 페이지가 물리 프레임(4)에 매핑된다고 가정하자(VPN 1 -> PFN 4)
- 배열 자체의 크기는 4000바이트(1000개의 정수)이고, 가상 주소 40000에서 44000까지 존재한다고 가정한다.
- 이 범위에 해당하는 가상페이지는 VPN = 39 ... VPN = 42이다.
- 가상-대-물리 주소 매핑이 다음과 같다고 가정한다.
  - (VPN 39 -> PFN 7), (VPN 40 -> PFN 8), (VPN 41 -> PFN 9), (VPN 42 -> PFN 10)
```

프로그램이 실행되면 명령어 반입 시에 메모리가 두번 참조된다.

1. 명령어 위치 파악을 위한 페이지 테이블 접근
2. 명령어 자체에 한번

추가적으로 mov 명령어는 메모리 참조를 한번 한다.

처음 다섯번의 루프 반복에 대한 전체과정
![](../img/os-tes-1.png)

- 가상 주소가 좌측 Y축, 물리 주소가 우측 Y축
- 가장 아래 그래프가 명령어 메모리 참조
- 중앙의 그래프는 배열에 대한 접근
- 맨 위의 그래프는 테이블 메모리 접근

루프당 10번의 메모리 접근이 존재한다.

- 네번의 명령어 반입과 한번의 메모리 갱신
- 이러한 네번의 반입과 한번의 메모리 갱신을 위한 주소 변환을 위한 총 다섯번의 페이지 테이블 접근

## 19. 페이징: 더 빠른 변환(TLB)

운영체제의 실행 속도를 개선하기 위해서 하드웨어의 도움을 받는다.

**TLB**: 변환-색인 버퍼(translation-lookside buffer)

- 칩의 메모리 관리부(memory-management unit, MMU)의 일부다.
- 자주 참조되는 가상 주소-실주소 변환 정보를 저장하는 하드웨어 캐시이다.

가상 메모리 참조시, 하드웨어는 먼저 TLB에 원하는 변환 정보가 있는지를 확인한다. 만약 있다면 페이지 테이블을 통하지 않고 변환을 빠르게 수행한다.

### TLB 제어 흐름 알고리즘

```
1 VPN = (VirtualAddress & VPN_MASK) >> SHIFT
2 (Success, TlbEntry) = TLB_Lookup(VPN)
3 if (Success == True) // TLB Hit
4     if (CanAccess(TlbEntry.ProtectBits) == True)
5         Offset = VirtualAddress & OFFSET_MASK
6         PhysAddr = (TlbEntry.PFN << SHIFT) | Offset
7         Register = AccessMemory(PhysAddr)
8     else
9         RaiseException(PROTECTION_FAULT)
10 else // TLB Miss
11    PTEAddr = PTBR + (VPN * sizeof(PTE))
12    PTE = AccessMemory(PTEAddr)
13    if (PTE.Valid == False)
14        RaiseException(SEGMENTATION_FAULT)
15    else if (CanAccess(PTE.ProtectBits) == False)
16        RaiseException(PROTECTION_FAULT)
17    else
18        TLB_Insert(VPN, PTE.PFN, PTE.ProtectBits)
19        RetryInstruction()
```

1번라인. 가상 페이지 번호(VPN)을 추출한다.

2번라인. 해당 VPN의 존재 여부를 검사한다.

- 만약 존재하면 **TLB 히트** 이고 TLB가 변환 값을 갖고 있다는 것을 뜻한다.
- 이제 해당 TLB 항목에서 페이지 프레임 번호(PFN)를 추출할 수 있다.

4번라인. 해당 페이지에 대한 접근 권한 검사가 성공하면

5~7번라인. 그 정보 를 원래 가상주소의 오프셋과 합쳐서 원하는 물리 주소(PA)를 구성하고 메모리에 접근 할 수 있다.

**TLB 미스**인 경우에는 할일이 많다.

11~12번 라인. 하드웨어가 변환 정보를 찾기 위해서 페이지 테이블에 접근하며

13~15번 라인. 프로세스가 생성한 가상 메모리 참조가 유효하고 접근 가능하다면

18번 라인. 해당 정보를 TLB로 읽어들인다.

- 이는 매우 시간이 많이 소요되는 작업이다. 페이지 테이블 접근을 위한 12번 라인의 메모리 참조 때문이다.
- 메모리 접근 연산은 다른 CPU연산(예, 덧셈, 곱셈 등)에 비해 매우 시간이 오래 걸린다.
- TLB 미스가 많이 발생할수록 메모리 접근 횟수가 많아진다.

### 예제: 배열 접근

- 가상 주소 100번지의 10개의 4바이트 크기의 정수 배열이 존재한다.
- 가상 주소 공간은 8비트이며, 페이지의 크기는 16바이트이다.
- 가상 주소는 4비트 VPN(16개의 가상 페이지들)과 4비트 오프셋(각 페이지는 16바이트 크기)

![](../img/os-tes-2.png)

```c
int sum = 0;
for (int i = 0; i < 10; i++){
  sum += a[i];
}
```

1. 첫 번째 배열의 항목(a[0])이 접근된다. 가상 주소 100번이다.
2. 하드웨어는 VPN을 추출한다. VPN이 06번이다.
3. 하드웨어는 TLB에서 해당 VPN을 검색한다.
   - TLB가 완전히 초기화되어 있다 가정하자.
4. TLB 미스가 발생한다.
   - 미스가 발생하면 해당 VPN 06번에 대한 물리 페이지 번호를 찾아, TLB를 갱신한다.
5. 다음은 a[1]를 읽는다. a[1]을 읽을 때는 TLB히트다.
   - 배열의 두번째 항목은 첫번째 항목과 같은 페이지에 존재한다.
   - 첫번째 항목을 읽을 때, 이미 해당 페이지를 접근하였기 때문에, 필요한 변환 정보가 이미 TLB에 탑재되어 있다.
   - a[2]를 읽을 때에도 같은 상황이다.
6. 같은 상황으로 a[3]과 a[7]를 읽을 때도 미스가 발생한다.

이 예제에서 보는 바와 같이 **페이지의 크기** 는 TLB의 효용성에 매우 중요한 역할을 한다.

페이지의 크기가 두배가 되면, TLB의 미스 횟수가 더 줄어든다.

#### 지역성

1. 시간 지역성(temporal locality): 최근에 접근된 명령어 또는 데이터는 곧 다시 접근될 확률이 높다는 사실에 근거한다.
   - for문이나 while문 같은 경우 일정시간 동안 반복적으로 접근된다.
2. 공간 지역성(spatial locality): 프로그램이 메모리 주소 x를 읽거나 쓰면, x와 인접한 메모리 주소를 접근할 확률이 높다는 사실에 근거한다.
   - 배열을 순차적으로 읽는 프로그램이 공간 지역성을 갖는 대표적인 예이다.

### TLB 미스의 처리

크게 두가지 방법이 있다. 하드웨어와 소프트웨어(운영체제)이다.

#### CISC(complex-instruction set computers)

미스 발생시 **하드웨어**는 다음과 같은 일을 한다:

1. 페이지 테이블에서 원하는 페이지 테이블 엔트리를 찾고,
2. 필요한 변환 정보를 추출하여,
3. TLB를 갱신한 후,
4. TLB 미스가 발생한 명령어를 재실행한다.

> 대표적인 예) 인텔 x86 CPU(하드웨어로 관리되는 TLB)

#### RISC(reduced instruction set computing)

- CISC 보다 최근에 등장한 컴퓨터 구조이다.

- RISC 기반 컴퓨터는 소프트웨어 관리 TLB를 사용한다.

- RISC 기반 컴퓨터에서 TLB 미스를 처리하는 과정은 다음과 같다.
  - TLB에서 주소 찾는 것이 실패하면 하드웨어는 예외 시그널을 발생시킨다.
  - 예외 시그널을 받은 운영체제는 명령어 실행을 잠정 중지하고, 실행 모드를 커널모드로 변경하여, 커널 코드 실행을 준비한다.
    - 이때 핵심은 커널 주소 공간을 접근할 수 있도록 특권 레벨(privilege level로) 상향 조정하는 것이다.
  - 커널 모드로 변경이 되면 트랩 핸들러를 실행한다.
    - 이때 실행되는 트랩핸들러는 TLB 미스의 처리를 담당하는 운영체제 코드이다.
  - 이 트랩 핸들러는 페이지 테이블을 검색하여 변환 정보를 찾고, TLB 접근이 가능한 특권 명령어를 사용하여 TLB를 갱신한 후에 리턴한다.
  - 트랩 핸들러에서 리턴되면 하드웨어가 명령어를 재실행한다.
    - 트랩 핸들러가 TLB를 갱신했으므로 이제는 TLB 히트가 날 것이다.

// 추가정리

## 20. 페이징: 더 작은 테이블

### 더 큰 페이지

페이지 테이블의 크기를 줄일 수 있는 방법이 한 가지 있다. 페이지의 크기를 증가시키면 된다.

페이지 크기의 증가는 부작용을 수반한다. 이는 페이지 내부의 낭비 공간이 증가한다는 것이다.

이를 **내부 단편화(internal fragmentation)**라고 한다.

응용 프로그램이 여러 페이지를 할당 받았지만, 할당받은 페이지의 일부분만 사용하는 터에, 결국
컴퓨터 시스템의 메모리가 금방 고갈되는 현상이 발생한다.

### 하이브리드: 페이장과 세그먼트

하이브리드 방식: 프로세스의 전체 주소 공간을 위해 하나의 페이지 테이블을 두는 대신, 논리 세그먼트마다 따로 페이지 테이블을 두는 것이다.

세그멘테이션에서는 세그먼트의 물리 주소 시작 위치를 나타내는 **베이스(base)** 레지스터, 크기를 나타내는 **바운드(bound)** 또는 **리미트(limit)** 레지스터가 있다.

비슷한 방식으로, 베이스 레지스터는 세그먼트의 시작주소를 가리키는 것이 아니라 **세그멘트의 테이블 페이블의 시작주소**를 갖는다.

// 추가정리

### 멀티 레벨 페이지 테이블

멀티 레벨 페이지 테이블: 선형 페이지 테이블을 트리 구조로 표현한다.

1. 페이지 테이블을 페이지 크기의 단위로 나눈다
2. 페이지 테이블의 페이지가 유효하지 않읂 항목만 있으면, 해당 페이지를 할당하지 않는다.
3. **페이지 디렉토리(page directory)** 라는 자료구조를 사용하여 페이지 테이블 각 페이지의 할당 여부와 위치를 파악한다.
   - 페이지 디렉토리는 페이지 테이블을 구성하는 각 페이지의 할당 여부와 위치를 가지고 있다.

간단한 2단계 테이블에서, 페이지 디렉터리의 각 항목은 페이지 테이블의 한 페이지를 나타낸다.

페이지 디렉토리는 **페이지 디렉터리 항목(PDE)**들로 구성된다.

각 항목(PDE)의 구성은 페이지 테이블의 각 항목(Page Table Entry)과 유사하다. **유효(valid)** 비트와 **페이지 프레임 번호(page frame number, PFN)**를 가지고 있다.

#### 멀티 레벨 페이지 테이블의 장점

1. 사용된 주소 공간의 크기에 비례하여 페이지 테이블 공간이 할당되기 때문에 보다 작은 페이지의 페이지 테이블로 주소 공간을 표현할 수 있다.
2. 페이지 테이블을 페이지 크기로 분할 함으로써 메모리 관리가 매우 용이하다.
   - 페이지 테이블을 할당하거나 확장할 때, 운영체제는 free 페이지 풀에 있는 빈 펜이지를 가져다 쓰면 된다.
   - 페이지 테이블의 각 페이지들이 물리 메모리에 산재해 있더라도 페이지 디렉토리를 이용하여 그 위치를 파악할 수 있으므로, 페이지 테이블을 위한 공간 할당이 매우 유연하다.

#### 단점

1. 멀티 레벨 테이블에는 추가 비용이 발생한다.

TLB 미스 시, 주소 변환을 위해 두번의 메모리 로드가 발생한다. (페이지 디렉토리와 PTE 접근을 위해 각각 한번씩)

> 멀티 레벨 테이블은 시간(페이지 테이블 접근 시간)과 공간(페이지 테이블 공간)을 상호 절충(time-space-trade-offs)한 예라고 할 수 있다.

TLB 히트시 성능은 동일하지만, TLB 미스 시에는 두배의 시간이 소요된다.

2. 복잡도

페이지 테이블 검색이 단순 선형 페이지 테이블의 경우보다 더 복잡해진다.

### 역 페이지 테이블

이 방법에서는 여러 개의 페이지 테이블(시스템의 프로세스당 하나씩) 대신 시스템에 단 하나의 페이지 테이블만 둔다. 역 페이지 테이블은 물리 페이지를 가상 주소 상의 페이지로 변환한다.

역 페이지 테이블의 각 항목은 해당 물리 페이지를 사용중인 프로세스 번호, 해당 가상 페이지 번호를 갖고 있다.

### 페이지 테이블을 디스크로 스와핑

어떤 테이블들은 페이지 테이블들을 커널 가상 메모리에 위치시키고, 메모리가 부족할 경우, 페이지 테이블들을 디스크로 **스왑(swap)** 한다.

## 21. 물리 메모리 크기의 극복: 메커니즘

주소 공간이 충분히 크면 프로그램의 자료 구조들을 위한 충분한 메모리 공간이 있는지 걱정하지 않아도 된다. 필요 시 메모리 할당을 운영체제에게 요청하기만 하면 된다.

멀티 프로그래밍 시스템이 개발되면서 많은 프로세스들의 페이지를 물리 메모리에 전부 저장하는 것이 불가능하게 되었다. 그래서 일부 페이지를 스왑 아웃 하는 기능이 필요하게 되었다.

### 스왑 공간

**스왑 공간(swap space**): 디스크에 페이지들을 저장할 수 있는 일정 공간을 확보하는 것

- 스왑 공간이라 불리는 이유는 메모리 페이지를 읽어서 이곳에 쓰고, 여기서 페이지를 읽어 메모리에 탑재시키기 때문이다.
- 디스크에 스왑 공간이 있다는 것은 하드 드라이브나 솔리드 스테이트 드라이브(SSD)의 일부가 가상 메모리로 사용되도록 예약되어 있다는 것을 의미한다.
- 컴퓨터의 물리적 메모리(RAM)가 가득 찬 경우 운영 체제는 현재 실행 중인 프로그램을 위해 더 많은 메모리를 확보하기 위해 RAM에서 사용 빈도가 가장 낮은 데이터를 디스크의 스왑 공간으로 이동할 수 있다.
- 스왑 공간의 입출력 단위는 페이지라고 가정한다. 운영체제는 스왑 공간에 있는 모든 페이지들의 **디스크 주소**를 기억해야 한다.
- 스왑 공간을 이용하면, 시스템에 실제 물리적으로 존재하는 메모리 공간보다 더 많은 공간이 존재하는 것처럼 가장할 수 있다.

### Present Bit

하드웨어는 present bit를 사용하여 각 페이지 테이블 항목에 어떤 페이지가 존재하는지를 표현한다.

- Present bit가 1로 설정되어 있다면, 물리 메모리에 해당 페이지가 존재한다는 것이고 위에 설명한 대로 동작한다.
- 만약 그 비트가 0으로 설정되어 있다면, 메모리에 해당 페이지가 존재하지 않고 디스크 어딘가에 존재한다는 것을 나타낸다.
- 물리 메모리에 존재하지 않는 페이지를 접근하는 행위를 일반적으로 **페이지 폴트(page fault)** 라고 한다.
- 페이지 폴트가 발생하면, 페이지 폴트를 처리하기 위해 운영체제로 제어권이 넘어간다.
- **페이지 폴트 핸들러(page-fault handler)** 가 실행된다.

### 페이지 폴트

만약 요청된 페이지가 메모리에 없고, 디스크로 스왑되었다면, 운영체제는 해당 페이지를 메모리로 스왑해온다. 운영체제는 PFN과 같은 PTE 비트 들은 페이지의 디스크 주소를 나타내는데 사용할 수 있다. 페이지 폹트 발생시, 운영체제는 페이지 테이블 항목에서 해당 페이지의 디스크 상 위치를 파악하여, 메모리로 탑재한다.

디스크 I/O가 완료가 되면 운영체제는 해당 페이지 테이블 항목(PTE)의 PFN 값을 탑재된 페이지의 메모리 위치로 갱신한다.

이 작업이 완료되면 페이지 폴트를 발생시킨 명령어가 재실행된다. 재실행으로 인해 TLB 미스가 발생될 수 있다. TLB 미스 처리 과정에서 TLB 값이 갱신된다.

최종적으로 마지막 재실행 시에 TLB에서 주소 변환 정보를 찾게 되고, 이를 이용하여 물리 주소에서 원하는 데이터나 명령어를 가져온다.

I/O 전송 중에는 해당 프로세스가 **차단된(blocked)** 상태가 된다는 것을 유의해야 한다. 페이지 폴트 처리 시 운영체제는 다른 프로세스들을 실행할 수 있다.

I/O 실행은 매우 시간이 많이 소요되기 때문에 한 프로세스의 I/O 작업(페이지 폴트)과 다른 프로세스의 실행을 **중첩(overlap)** 시키는 것은 멀티 프로그램된 시스템에서 하드웨어를 최대한 효율적으로 사용하는 방법 중 하나다.

**페이지 아웃(page out)** : 새로운 페이지를 위한 공간을 확보한다.

**교체(replace)** 페이지를 선택하는 것을 **페이지 교체 정책(page-replacement policy)** 이라고 한다.

### 페이지 폴트의 처리

#### 페이지 오류 제어 흐름의 알고리즘 (하드웨어)

```
1 VPN = (VirtualAddress & VPN_MASK) >> SHIFT
2 (Success, TlbEntry) = TLB_Lookup(VPN)
3 if (Success == True) // TLB Hit
4     if (CanAccess(TlbEntry.ProtectBits) == True)
5         Offset = VirtualAddress & OFFSET_MASK
6         PhysAddr = (TlbEntry.PFN << SHIFT) | Offset
7         Register = AccessMemory(PhysAddr)
8     else
9         RaiseException(PROTECTION_FAULT)
10 else // TLB Miss
11    PTEAddr = PTBR + (VPN * sizeof(PTE))
12    PTE = AccessMemory(PTEAddr)
13    if (PTE.Valid == False)
14        RaiseException(SEGMENTATION_FAULT)
15    else
16        if (CanAccess(PTE.ProtectBits) == False)
17            RaiseException(PROTECTION_FAULT)
18        else if (PTE.Present == True)
19            // assuming hardware-managed TLB
20            TLB_Insert(VPN, PTE.PFN, PTE.ProtectBits)
21            RetryInstruction()
22        else if (PTE.Present == False)
23            RaiseException(PAGE_FAULT)
```

위의 처리 과정에서 TLB 미스 발생 시, 세가지 중요한 경우가 있다는 것을 알 수 있다.

첫째는 페이지가 **존재** 하며 **유효** 한 경우이다.(18-21 라인).

- 이 경우에는 TLB 미스 핸들러가 PTE에서 PFN을 가져와서 여러 차례 명령어를 재시도한다.

두번재 경우는(22-23라인) 페이지지가 유효하지만 존재하지 않는 경우다.

- 페이지 폴트 핸들러가 반드시 실행되어야 한다.
- 프로세스가 사용할 수 있는 제대로된 페이지이기는 하지만(유효한 경우이기 때문에) 물리 메모리에 존재하지 않기 때문이다.

마지막 경우는 페이지가 유효하지 않은 경우다.(13-14 라인)

- 프로그램 버그 등으로 잘못된 주소를 접근하는 경우의 처리를 나타낸다.
- 이 경우에는 PTE의 다른 비트는 의미가 없다.
- 이 무효한 접근이 운영체제의 트랩 핸들러에 의해서 처리되도록 한다.
- 이때 문제를 일으킨 프로세스는 종료될 수가 있다.

#### 페이지 오류 제어 흐름의 알고리즘 (소프트웨어)

```
1 PFN = FindFreePhysicalPage()
2 if (PFN == -1) // no free page found
3     PFN = EvictPage() // run replacement algorithm
4     DiskRead(PTE.DiskAddr, PFN) // sleep (waiting for I/O)
5     PTE.present = True // update page table with present
6     PTE.PFN = PFN // bit and translation (PFN)
7     RetryInstruction() // retry instruction
```

운영체제는 먼저 탑재할 페이지를 위한 물리 프레임을 확보한다. 만약 여유 프레임이 없다면, 교체 알고리즘을 실행하여 메모리에서 페이지를 내보내고 여유 공간을 확보한다. 물리 프레임을 확보한 후, I/O 요청을 통해 스왑 영역에서 페이지를 읽어 온다. 마지막으로 이 느린 작업이 완료되면 운영체제는 페이지 테이블을 갱신하고 명령어를 재시도한다. 재시도를 하게되면 TLB 미스가 발생하며, 또 한번의 재시도를 할 때에 TLB 히트가 된다.

### 교체가 일어나는 때

메모리에 항상 어느 정도의 여유 공간을 비워두기 위해서, 대부분의 운영체제들은 여유 공간에 관련된 **최댓값(high watermark, HW)** 과 **최솟값(low watermark, LW)** 을 선정하여 교체 알고리즘 작동에 활용한다.

- 운영체제가 여유 공간의 크기가 최솟값보다 작아지면 여유 공간 확보를 담당하는 백그라운드 쓰레드가 실행된다.
- 이 쓰레드는 여유 공간의 크기가 최댓값에 이를 때 까지 페이지를 제거한다.
- 이 백그라운드 쓰레드는 일반적으로 **스왑 데몬(swap daemon)** 또는 **페이지 데몬(page daemon)** 이라고 불린다.
- 충분한 여유 메모리가 확보되면 이 백그라운드 쓰레드는 슬립 모드로 들어간다.

### 요약

실제 물리 메모리의 크기보다 더 많은 메모리를 사용하는 개념

1. 메모리에 특정 페이지가 존재하는지를 알리기 위한 **present bit** 와 좀 더 복잡한 페이지 테이블 구조가 필요하다.
2. 운영체제는 **페이지 폴트(page fault)** 를 처리하기 위해서 **페이지 폴트 핸들러(page-fault handler)** 를 실행시킨다.
3. 핸들러는 원하는 페이지를 디스크에서 메모리로 전송하기 위해 메모리의 일부 페이지들을 먼저 교체하여 새롭게 스왑되서 들어올 페이지를 위한 공간을 만드는 조치를 취한다.

이 모든 작업은 프로세스가 인지하지 못하는 상황에서 처리된다.

프로세스가 보기에는 자신의 개별적인 연속된 가상 메모리를 접근하는 것처럼 보인다.

실제로 페이지들은 물리 메모리 임의의(불연속적인) 위치에 배치되며, 때로는 디스크에서 가져와야 할 때도 있다.

일반적인 경우의 메모리 접근 작업이 빠르다고 기대하지만, 어떤 경우 여러번의 디스크 작업 후에 처리가 되기도 한다.

## 22. 물리 메모리 크기의 극복: 정책

빈 메모리 공간이 거의 없는 경우에 운영체제는 **메모리 압박 (memory pressure)** 을 해소하기 위해 다른 페이지들을 강제적으로 페이징 아웃(paging out)하여 활발히 사용 중인 페이지들을 위한 공간을 확보한다.

**내보낼(evict)** 페이지 선택은 운영체제의 **교체 정책(replacement policy)** 안에 집약되어 있다.
과거의 시스템들은 물리 메모리의 크기가 작았기 때문에 초기 가상 메모리 시스템의 가장 중요한 역할 중 하나가 바로 이 교체 정책 이였다.

### 캐시 관리

시스템의 전체 페이지들 중 일부분만이 메인 메모리에 유지된다는 것을 가정하면, 메인 메모리는 시스템의 가상 메모리 페이지를 가져다 놓기 위한 **캐시**로 생각될 수 있다.

이 캐시를 위한 교체 정책의 목표는 **캐시 미스**의 횟수를 최소화하는 것이다. 즉, 디스크로부터 페이지를 가져오는 횟수를 최소로 만드는 것이다.

한편으로는 **캐시 히트** 의 횟수를 최대로 하는 것도 목표. 접근된 페이지가 메모리에 이미 존재하는 횟수를 최대로 하는 것이다.

캐시 히트와 미스의 횟수를 안다면 프로그램의 **평균 메모리 접근 시간(average memory access time, AMAT)** 을 계산할 수 있다.

현대 시스템에서는 디스크 접근 비용이 너무 크기 때문에 아주 작은 미스가 발생하더라도 전체적인 AMAT에 큰 영향을 주게 된다.

컴퓨터가 디스크 속도 수준으로 느리게 실행되는 것을 방지하기 위해서는 미스를 최대한 줄여야한다.

### 최적 교체 정책

최적 교체 정책(The optimal replacement policy)은 미스를 최소화한다.

가장 나중에 접근될 페이지를 교체하는 것이 최적이며 가장 적은 횟수의 미스를 발생시킨다.

핵심: 가장 먼 시점에 필요한 페이지보다 캐시에 존재하는 다른 페이지들이 더 중요하다는 것이다.

하지만 **미래는 일반적으로 미리 알 수 없기 때문에** 범용 운영체제에서는 최적 기법의 구현은 불가능하다. 최적 기법은 비교의 기준으로만 사용된다.

### 간단한 정책: FIFO

먼저 들어온 것이 먼저 나간다.(선입 선출)

시스템에 페이지가 들어오면 큐에 삽입되고, 교체를 해야 할 경우 큐의 테일에 있는 페이지가(먼저 들어온 페이지) 내보내진다.

### 무작위 선택

메모리의 압박이 있을 때 페이지를 무작위로 선택하여 교체한다. FIFO와 유사하게 구현하기 쉽지만 내보낼 블럭을 제대로 선택하려는 노력을 하지 않는다.

### 과거 정보의 사용: LRU

- **빈도수(frequency)** : 한 페이지가 여러 차례 접근되었는지

- **최근성(recency)** : 더 최근에 접근된 페이지인지

- **Lesat-Frequently-Used(LFU)** : 정챌은 가장 적은 빈도로 사용된 페이지를 교체한다.

- **Least-Recently-Used(LRU)** : 가장 오래 전에 사용하였던 페이지를 교체한다.

### 워크로드에 따른 성능 비교

1. 지역성이 없는 워크로드

- 어느 정책을 사용하든 상관이 없다. LRU와 FIFO 그리고 무작위 선택 정책은 모두 동일한 성능을 보이며, 히트율은 정확히 캐시의 크기에 의해서 결정된다.
- 캐시가 충분히 커서 모든 워크로드를 다 포함할 수 있다면 역시 어느 정책을 사용하든지 상관 없다. 참조되는 모든 블럭들이 캐시에 들어갈 수 있으면 모든 정책들은(무작위 선택마저도) 히트율이 100%에 도달한다.
- 최적 기법이 구현 가능한 기타 정책들보다 눈에 띄게 더 좋은 성능을 보인다. 미래를 알 수 있다면 교체 작업을 월등히 잘할 수 있다.

2. "80 대 20" 워크로드

20%의 페이지들(인기 있는 페이지)에서 80%의 참조가 발생하고 나머지 80%의 페이지(비 인기 페이지)들에 대해서 20%의 참조만 발생한다.

이때, 랜덤과 FIFO 정책은 상당히 좋은 성능을 보이지만, 인기 있는 페이지들을 캐시에 더 오래두는 경향이 있는 LRU가 더 좋은 성능을 보인다.

인기있는 페이지들이 과거에 빈번하게 참조되었기 때문에 그 페이지들은 가까운 미래에 다시 참조되는 경향이 있기 때문이다.

3. "순차 반복" 워크로드

일정 개수의 워크로드를 순차적으로 참조한다. 처음부터 끝까지 참조한 후에 다시 처음으로 돌아가서 그 접근 순서를 반복한다.

### 과거 이력 기반 알고리즘의 구현

LRU를 완벽하게 구현하기 위해서는 각 페이지 접근마다(즉, 명령어 탑재나 로드 또는 저장하려는 각 메모리 접근) 해당 페이지가 리스트에 가장 앞으로 이동하도록(즉, MRU 측으로) 자료 구조를 갱신해야 한다.

LRU 에서는 어떤 페이지가 가장 최근에 또는 가장 오래전에 사용되었는지를 관리하기 위해서 모든 메모리 참조 정보를 기록해야 한다.

세심한 주의 없이 정보를 기록하면 성능이 크게 떨어질 수 있다.

이 작업을 좀 더 효율적으로 하는 방법은 약간의 하드웨어 지원을 받는 것이다.

- 페이지 접근이 있을 때마다 하드웨어가 메모리의 시간 필드를 갱신하도록 할 수 있다.
- 페이지가 접근되면 하드웨어가 시간 필드를 현재 시간으로 설정한다.
- 페이지 교체시에 운영체제는 가장 오래전에 사용된 페이지를 찾기 위해 시간 필드를 검사한다.

시스템의 페이지 수가 증가하면 페이지들의 시간 정보 배열을 검색하여 가장 오래 전에 사용된 페이지를 찾는 것은 매우 고비용의 연산이 된다. 따라서 비슷하게 오래된 페이지를 찾는 방법을 생각한다.

### LRU 정책 근사하기

#### use bit(or reference bit)

- 시스템의 각 페이지마다 하나의 use bit가 있으며, 이 use bit는 메모리 어딘가에 존재한다.

- 페이지가 참조될 때 마다 하드웨어에 의해서 use bit가 1로 설정된다.
- 하드웨어는 이 비트를 절대로 0으로 바꾸지 않는다. 0으로 바꾸는 것은 운영체제의 몫이다.

#### 시계 알고리즘(clock algorithm)

시스템의 모든 페이지들이 환형 리스트를 구성한다고 가정.

**시계 바늘(clock hand)** 이 특정 페이지를 가리킨다고 해보자.

1. 페이지를 교체해야 할 때 운영체제는 현재 바늘이 가리키고 있는 페이지 P의 use bit가 1인지 0인지 검사한다.
2. 만약 1이라면 페이지 P는 최근에 사용되었으며 바람직한 교체 대상이 아니라는 것을 뜻한다.
3. P의 use bit는 0으로 설정되고 시계바늘은 다음 페이지 P + 1로 이동한다.
4. 알고리즘은 use bit가 0으로 설정되어 있는, 즉 최근에 사용된 적이 없는 페이지를 찾을 때까지 반복된다.

완벽한 LRU 만큼 좋은 성능을 보이지는 않지만 과거 정보를 고려하지 않는 다른 기법들에 비해서는 성능이 더 좋다.

### 갱신된 페이지(Dirty Page)의 고려

만약 어떤 페이지가 **변경(modified)**되어 **더티(dirty)** 상태가 되었다면, 그 페이지를 내보내기 위해서는 디스크에 변경 내용을 기록해야 하기 때문에 비싼 비용을 지불해야 한다.

만약 변경 되지 않았다면, 내보낼 때 추가 비용은 없다. 해당 페이지 프레임은 추가적인 I/O 없이 다른 용도로 재사용될 수 있다.

때문에 어떤 VM 시스템들은 더티 페이지 대신 깨끗한 페이지를 내보내는 것을 선호한다.

이런 동작을 지원하기 위해 하드웨어는 **modified bit(or dirty birt)** 를 포함해야 한다. 페이지가 변경될 때마다 이 비트가 1로 설정되므로 페이지 교체 알고리즘에서 이를 고려하여 교체 대상을 선택한다.

### 다른 VM 정책들

VM 시스템은 페이지 교체 정책만을 사용하지는 않는다. **페이지 선택(page selection) 정책**

#### 요구 페이징(damand paging) 정책

이 정책은 말 그대로 "요청된 후 즉시", 즉 페이지가 실제로 접근될 때 운영체제가 해당 페이지를 메모리로 읽어들인다.

운영체제는 어떤 페이지가 곧 사용될 것이라는 것을 대략 예상할 수 있기 때문에 미리 메모리로 읽어 들일 수도 있다.

이와 같은 동작을 **선반입(prefetching)** 이라고 하며 성공할 확률이 충분히 높을 때에만 해야 한다.

#### 클러스터링

운영체제가 변경된 페이지를 디스크에 반영하는데 관련된 방식이다.

한번에 한 페이지씩 디스크에 쓸 수 있지만, 많은 시스템은 기록해야 할 페이지들을 메모리에 모은 후, 한 번에 (더 효율적으로) 디스크에 기록하다.

### 쓰레싱(Thrashing)

메모리 사용 요구가 감당할 수 없을 만큼 많고 실행 중인 프로세스가 요구하는 메모리가 가용 물리 메모리 크기를 초과하는 경우에 운영체제는 끊임없이 페이징을 할 수 밖에 없고, 이와 같은 상황을 **쓰레싱** 이라고 부른다.

몇몇 초기 운영체제들은 쓰레싱이 발했을 때, 이의 발견과 해결을 위한 상당히 정교한 기법들을 가지고 있었다.

예를 들면, 다수의 프로세스가 존해할 때, 일부 프로세스의 실행을 중지시킨다.

실행되는 프로세스의 수를 줄여서 나머지 프로세스를 모두 메모리에 탑재하여 실행하기 위해서이다.

**워킹 셋(working set)** 이란 프로세스가 실행 중에 일정 시간 동안 사용하는 페이지들의 집합이다.

일반적으로 **진입 제어(admission control)** 라고 알려져 있는 이 방법은 많은 일들을 엉성하게 하는 것보다는 더 적은 일을 제대로 하는 것이 나을 때가 있다고 말한다.

일부 버전의 Linux는 메모리 요구가 초과되면 **메모리 부족 킬러(out-of-memory killer)** 를 실행시킨다. 이 데몬은 많은 메모리를 요구하는 프로세스를 골라 죽이는, 그다지 교묘하지 않은 방식으로 메모리 요구를 줄인다.

## 26. 병행성: 개요

멀티 쓰레드 프로그램은 하나 이상의 실행 지점(독립적으로 불러 들여지고 실행될 수 있는 여러개의 PC 값)을 가지고 있다.

### 프로세스와 쓰레드의 큰 차이점 몇가지

- 쓰레드들은 주소 공간을 공유하기 때문에 동일한 값에 접근할 수 있다는 것이다.
- 쓰레드간의 문맥 교환(context switcher)에서는 주소 공간을 그대로 사용한다.
- 멀티쓰레드 프로세스의 주소 공간에는 하나의 스택이 아니라 쓰레드마다 스택이 할이 할당 되어 있다.

### 왜 쓰레드를 사용하는가?

1. 병렬 처리(paralleism)
   1. 표준 **단일 쓰레드(single-threaded)** 프로그램을 멀티프로세서 상에서 같은 작업을 하는 프로그램을 변환하는 작업을 **병렬화(paralleization)** 라고 부르며, CPU 마다 하나의 쓰레드를 사용하여 주어진 일을 하는 것이 최신 하드웨어 상에서 프로그램을 더 빠르게 실행하게 만드는 방법이다.
2. 느린 I/O로 인해 프로그램 실행이 멈추지 않도록 하기 위해
   1. 쓰레딩은 하나의 프로그램 안에서 I/O와 다른 작업이 중첩(overlap)될 수 있게 한다.
   2. 이는 여러 프로그램을 대상으로 프로세스를 멀티 프로그래밍(multiprogramming)하는 것과 비슷하다.

### 예제: 쓰레드 생성

한 쓰레드는 "A"라고 출력하고 다른 쓰레드는 "B" 라고 출력하는 독립적인 두 개의 쓰레드를 생성하는 프로그램

```c
#include <stdio.h>
#include <assert.h>
#include <pthread.h>
#include "common.h"
#include "common_threads.h"

void *mythread(void *arg) {
  printf("%s\n", (char *) arg);
  return NULL;
}

int main(int argc, char *argv[]) {
  pthread_t p1, p2;
  int rc;
  printf("main: begin\n");
  Pthread_create(&p1, NULL, mythread, "A");
  Pthread_create(&p2, NULL, mythread, "B");

  // join waits for the threads to finish
  Pthread_join(p1, NULL);
  Pthread_join(p2, NULL);
  printf("main: end\n");
  return 0;
}
```

스케줄러의 동작에 따라 다르겠지만, 쓰레드가 생성되면, 즉시 실행될 수도 있고, 준비(ready) 상태에서 실행은 되지 않을 수도 있다.

두개의 쓰레를 생성한 후에 메인 쓰레드는 pthread_join()을 호출하여 특정 쓰레드의 동작의 종료를 대기한다. T1, T2가 실행되고 완료된 후에야 마침내 메인 쓰레드가 다시 실행될 수 있다.

이때 T1이 T2보다 먼저 생성된 경우라 하더라도 만약 스케쥴러가 T2를 먼저 실행하면 "B"가 "A"보다 먼저 출력될 수도 있다. 먼저 생성되었다고 해서 먼저 실행될 것이라는 가정을 할 어떤 이유도 없다.

### 데이터의 공유

```c
#include <stdio.h>
#include <pthread.h>
#include "common.h"
#include "common_threads.h"

static volatile int counter = 0;

// mythread()
//
// Simply adds 1 to counter repeatedly, in a loop
// No, this is not how you would add 10,000,000 to
// a counter, but it shows the problem nicely.
//
void *mythread(void *arg) {
  printf("%s: begin\n", (char *) arg);
  int i;
  for (i = 0; i < 1e7; i++) {
    counter = counter + 1;
  }
  printf("%s: done\n", (char *) arg);
  return NULL;
}

// main()
//
// Just launches two threads (pthread_create)
// and then waits for them (pthread_join)
//
int main(int argc, char *argv[]) {
  pthread_t p1, p2;
  printf("main: begin (counter = %d)\n", counter);
  Pthread_create(&p1, NULL, mythread, "A");
  Pthread_create(&p2, NULL, mythread, "B");

  // join waits for the threads to finish
  Pthread_join(p1, NULL);
  Pthread_join(p2, NULL);
  printf("main: done with both (counter = %d)\n", counter);
  return 0;
}
```

counter 의 예상값은 20000000 이지만, 때론 19345221 이나 19221041 과같은 오차가 발생한다.

### 제어 없는 스케줄링

counter에 단순히 1이라는 숫자를 더하려고 한다.

```assembly
mov 0x8049a1c, %eax
add $0x1, %eax
mov %eax, 0x8049a1c
```

counter 변수 위치의 주소는 0x8049alc 라고 가정한다.

1. x86의 mov 명령어가 명시한 메모리 주소의 값을 읽어들인 후 eax 레지스터에 넣는다.
2. 1 (0x1)을 eax 레지스터의 값에 더한다.
3. 마지막으로 eax에 저장되어 있는 값을 메모리의 원래의 주소에 다시 저장한다.

두 개의 쓰레드 중에 쓰레드 1이 counter를 증가시키는 코드 영역에 진입하여 counter 값을 1 증가시키려는 상황을 가정해보자.

counter에 있는 값이 50이었다고 하면 50을 eax 레지스터에 넣는다.

쓰레드 1에 있어서 eax=50이된다.

그 후에 레지스터의 값에 1을 더하여 eax=51이 된다.

타이머 인터럽트가 발생하여 운영체제가 실행 중인 쓰레드의 PC값과 eax를 포함하는 레지스터들 등의 현재 상태를 쓰레드의 TCB에 저장한다.

쓰레드 2가 선택되고 counter 값을 증가시키는 똑같은 코드 영역에 진입한다.

// 설명추가

이때 명령어의 실행 순서에 따라 결과가 달라지는 상황을 **데이터 경쟁(data race)** 라고 부른다.

컴퓨터의 작동에서 일반적으로 발생하는 결정적 결과와 달리 결과가 어떠할지 알지 못하거나 실행할 때마다 결과가 다른 경우를 **비결정적(indeterminate)** 인 결과라고 부른다.

**임계 영역(critical section)** : 멀티 쓰레드가 같은 코드를 실행할 때 경쟁 조건이 발생하는 이러한 코드 부분

- 공유 자원에 접근하고 하나 이상의 쓰레드에서 동시에 실행되면 안 되는 코드를 임계 영역이라고 부른다.

이러한 코드에서 필요한 것은 **상호 배제(mutual exclusion)** 이다. 이 속성은 하나의 쓰레드가 임계 영역 내의 코드를 실행 중일때는 다른 쓰레드가 실행할 수 없도록 보장해 준다.

### 원자성에 대한 바람

1. 임계 영역 문제에 대한 해결 방법 중 하나로 강력한 명령어 한개로 의도한 동작을 수행하여, 인터럽트 발생 가능성을 원천적으로 차단하는 것이다.

```assembly
memory-add 0x8049a1c, $0x1
```

이 명령어는 메모리 상의 위치에 어떤 값을 더하는 명령어 이다. 하드웨어는 이 명령어가 원자적으로 실행되는 것을 보장한다고 하자. 이 명령어가 실행되면 원하는 것 처럼 값이 갱신된다.

2. 하드웨어에 **동기화 함수(synchronization primitives)** 구현에 필요한 몇 가지 유용한 명령어를 요청하는 것이다.

이 하드웨어 지원을 사용하고 운영체제의 도움을 받아 한번에 하나의 쓰레드만 임계 영역에서 실행하도록 구성된, 멀티 쓰레드 프로그램을 작성 할 수 있다.

## 27. 쓰레드 API

// 생 략

## 28. 락

### 락: 기본 개념

락을 사용하기 위해서 락으로 임계 영역을 다음과 같이 감쌌다.

```c
lock_t mutex; // 글로벌 변수로 선언된 락
...
lock(&mutex);
balance = balance + 1;
unlock(&mutex);
```

**락 변수**는 락의 상태를 나타낸다.

1. 첫 번째는 **사용 가능(available)** 상태 (**unlocked** 또는 **free**)이다. 즉 어떤 쓰레드도 락을 소유하고 있지 않다.

2. 두번째는 **사용 중(acauired)** 상태이다. 즉, 임계 영역에서 정확히 하나의 쓰레드가 락을 획득한 상태이다.

lock() 루틴 호출을 통해 락 획득을 시도한다. 만약 어떤 쓰레드도 락을 갖고 있지 않으면 그 쓰레드는 락을 획득하여
임계 영역 내로 진입한다. 이렇게 락을 획득한 쓰레드를 **락 소유자(owner)** 라고 부른다.

만약 다른 쓰레드가 lock()을 호출할 경우, 락이 사용중인 동안에는 lock() 함수는 리턴하지 않는다. 락을 소유한 쓰레드가 임계 영역에 존재하는 상태에서는 다른 쓰레드들이 임계 영역으로 진입할 수가 없다.

락 소유자가 unlock()을 호출 한다면 락은 이제 다시 사용가능한 상태가 된다.

락은 프로그래머에게 스케줄링에 대한 최소한의 제어권을 제공한다. 락은 쓰레드에 대한 제어권을 일부 이양 받을 수 있도록 해준다.

### Pthread 락

쓰레드 간에 **상호 배제(mutual exclusion)** 기능을 제공하기 때문에 POSIX 라이브러리는 락을 **mutex** 라고 부른다.

```c
pthread_mutex_t lock = PTHREAD_MUTEX_INITIALIZER; // 글로벌 변수로 선언된 락
...
pthread_mutex_lock(&mutex); // 레퍼. 실패시 exit
balance = balance + 1;
pthread_mutex_unlock(&mutex);
```

### 락의 평가기준

락의 정상동작 여부 판단을 위한 평가기준

1. 상호 배제

- 락이 동작하여 임계 영역 내로 다수의 쓰레드의 진입을 막을 수 있는지

2. 공정성

- 쓰레드들이 락 획득에 대한 공정한 기회가 주어지는지
- 락을 전혀 얻지 못해 **굶주리는(starve)** 상황이 발생하는지

3. 성능

- 락 사용 시간적 오버헤드를 평가해야 한다.
  1. 경쟁이 전혀 없는 경우의 성능
  - 하나의 쓰레드가 실행 중에 락을 획득하고 해제하는 과정에서 발생하는 부하는 얼마나 되는지
  2. 여러 쓰레드가 단일 CPU 상에서 락을 획득하려고 경쟁할 때의 성능
  3. 멀티 CPU 상황에서 락 경쟁 시의 성능

### 인터럽트 제어

단일 프로세서 시스템에서, 임계 영역 진입 전에 특별한 하드웨어 명령어를 사용하여 인터럽트를 비활성화 시킨다면, 임계 영역 내의 코드에서는 인터럽트가 발생할 수가 없다. 모든 동작이 끝난 후에 다시 하드웨어 명령어를 통해 인터럽트를 활성화하여 프로그램이 이전처럼 실행된다.

장점: 단순하다.

단점:

1. 요청을 하는 쓰레드가 인터럽트를 활성/비활성화하는 **특권(privileged)** 연산을 실행할 수 있도록 허가해야한다. 또 이를 다른 목적으로 사용하지 않음을 신뢰할 수 있어야 한다. 운영체제가 잘 알지 못하는 다른 프로그램을 신뢰해야 하는 경우가 생긴다면, 대부분 곤경에 빠진 것이라고 보면 된다.
   ex1) 탐욕적(greedy) 기법을 사용한 프로그램이 시작과 동시에 lock()을 호출하여 프로세서를 독점하여 사용할 수도 있다.
   ex2) 악의적인 프로그램 lock()을 호출하고 무한 반복문에 들어갈 수도 있다.
2. 멀티프로세서에서 적용을 할 수가 없다. 여러 쓰레드가 여러 CPU에서 실행 중이라면 각 쓰레드가 동일한 임계 영역에 진입하려고 시도할 수 있다.
3. 장시간 동안 인터럽트를 중지시키는 것은 중요한 인터럽트의 시점을 놓칠 수가 있다는 것이다.
4. 일반적인 명령어의 실행에 비해 인터럽트를 비활성화시키는 코드들은 최신의 CPU들에서는 느리게 실행되는 경향이 있다.

위의 이유들로 상호 배제를 위하여 인터럽드를 비활성화하는 것은 **제한된 범위에서만** 사용되어야 한다.

### 실패한 시도: 오직 load/store 명령어만 사용하기

하나의 변수와 load와 store 명령어만으로는 락의 구현이 불가능하다.

```c
typedef struct __lock_t {int flag; } lock_t;

void init(lock_t *mutex) {
  // 0 -> 락이 사용 가능함, 1 -> 락 사용 중
  mutex->flag = 0;
}

void lock(lock_t *mutex){
  while(mutex->flag == 1) // flag 변수를 검사(TEST)함
    ; // spin-wait (do nothing)
  mutex->flag = 1; // 이제 설정(SET) 한다!
}

void unlock(lock_t *mutex){
  mutex->flag = 0;
}
```

두가지 문제점

1. 제대로 작동하는가 여부
   - 병행 프로그래밍시에, 만약 적시에 인터럽트가 발생하면 두 쓰레드 모두 플래그를 1로 설정하는 경우가 생길 수 있다.
2. 성능
   - **spin-wait** 라는 방법을 사용하여 플래그의 값을 무한히 검사하는데, 이 방법은 다른 쓰레드가 락을 해제할 때까지 시간을 낭비한다.

### Test-And-Set

```c
int TestAndSet(int *old_ptr, int new) {
  int old = *old_ptr; // fetch old value at old_ptr
  *old_ptr = new; // store ’new’ into old_ptr
  return old; // return the old value
}
```
