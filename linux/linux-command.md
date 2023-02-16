# **Linux Command**
- [**Linux Command**](#linux-command)
  - [**System**](#system)
  - [**Directories and Files**](#directories-and-files)
  - [**User**](#user)
  - [**Relative paths \& Absolute paths**](#relative-paths--absolute-paths)
  - [**How to get help**](#how-to-get-help)



## **System**
- **uname**
    - input format : `uname [option]`
        - System information output command
    - option
      - -a : Displays the kernel name, network host name, kernel release information, kernel version, hardware type (architecture) of the system, and operating system name.
- **nproc**
    - input format : `nproc [option]`
        - It prints the number of processing units available to the current process. It may be less than the number of online processors.
    - option
        - —all : print the number of all installed cores/processes
- **free**
    - input format : `free [option]`
        - displays system memory usage status
    - option
        - -m : expressed in megabytes
- **df**
    - disk free
    - input format : `df [option]`
        - This command shows the size and capacity of the mounted file system, allowing you to see the usage status of the entire file system at a glance.
    - option
        - a: 0 블록의 파일시스템을 포함해 모든 파일시스템을 출력하는 옵션
        - B: 지정한 크기(SIZE)를 블록단위로 정하여 용량 표시하는 옵션
        - BM: 크기를 1M으로 블록단위를 정해 용량을 표시
- **mpstat**
    - needs `apt-get -y install sysstat`
    - input format : `mpstat`
        - Command to print available CPU and usage by core (sysstat installation required).
- **who**
    - input format :  `who [option] [file]`
        - It is used to get information about currently logged in user on to system.
    - option
        - -b : print last system boot time
- **lsblk**
    - list block devices
    - 형태 : `lsblk`
      - 설명 : 리눅스 시스템에서 사용 가능한 블록 장치를 리스트화 하여 출력한다.
- **ss**
    - socket statistics
    - input format : `ss`
        - show network statistics
        - simpler and faster than netstat
- **systemctl**
    - input format : `systemctl [command] [service_name]`
    - command
        - **start** : start service
        - **stop** : stop service
        - **status** : check service status (can check whether the service is running or not)
        - **restart** : service restart (usually used after changing settings)
        - **reload** : Apply the setting value without stopping the service
        - **enable** : Register the service to run automatically when the system reboots
        - **disable** : Disable the enabled service
- **ifconfig**
    - input format : `ifconfig`
        - 모든 활성 인터페이스 세부 정보를 표시하는 명령어.
- **hostname**
    - input format : `hostname [option]`
    - option
        - -I : print the host's IP address
    
    hostnamectl set-hostname [name] 
    
    reboot
    
- **journalctl**
    - systemd의 서비스 로그를 확인할 수 있다.
    - 부팅부터 모든 이벤트가 바이너리 형태의 journal에 저장된다.
    - _COMM
        - 로그 발생 명령
## **Directories and Files**
- **ls**
    - 형태: `ls [옵션]`
    - 설명: 현재 디렉토리의 파일 목록을 출력하는 명령어.
    - 옵션
        - -l : 자세히 보기
        - -a , --all : 모든 파일을 표시 해준다.
- **pwd**
    - 형태: `pwd`
    - 설명: 현재 위치하고 있는 디렉토리를 알려주는 명령어
- **mkdir**
    - 형태: `mkdir [옵션] {디렉토리명1} {디렉토리명2} …`
    - 설명: 새로운 디렉토리를 생성하는 명령어
    - 옵션
        - -p, --parents: 필요한 개수만큼 부모 디렉토리를 생성한다.
            - ex) mkdir -p dir1/dir2/dir3/dir4
- **touch**
    - 형태: `touch {새로 생성할 파일 명}`
    - 설명: 비어있는 새로운 파일을 생성할 때 사용하는 명령어
- **cd**
    - 형태: `cd {이동할 디렉토리의 경로명}`
        - 설명: 현재 디렉토리 안에 있는 원하는 디렉토리로 이동할 수 있는 명령어
- **rm**
    - remove
    - input format : `rm [option] {file1} {file2} …`
    - 설명: 현재 디렉토리에 있는 파일을 삭제할 수 있는 명령어
    - 옵션
        - -**f :** 강제로 파일이나 디렉토리를 삭제하고 대상이 없는 경우에는 메시지를 출력하지 않음
        - -**r :** 디렉토리 내부의 모든 내용을 삭제
            - rm -r {디렉토리/파일명}: 해당 디렉토리/파일 무조건 삭제
        - -**d :** 비어있는 디렉토리들만 제거
        - -**i :** 매번 삭제할때마다 사용자에게 삭제할것인지 물어봄
        - -**l :** 3개의 이상의 파일을 삭제하거나 디렉토리 내부가 비어있지 않을때만 삭제할지 물음
        - -**v :** 삭제되는 대상의 정보를 출력함
- **cp**
    - 형태: `cp {파일 위치 및 파일 이름} { 목적지 파일 위치 및 파일 이름}`
    - 파일을 복제하여 원하는 위치에 저장할 수 있다.
- **mv**
    - 형태: `mv {파일 위치 및 파일 이름} {파일 위치 및 파일 이름}`
    - 파일을 다른 디렉토리로 이동하거나 파일의 이름을 바꿀 수 있다.
- **wget**
    - 형태: `wget [옵션] {파일 링크}`
    - (Web get) url을 통해 파일을 다운로드 받는 명령어
    - HTTP, HTTPS, FTP 프로토콜 지원
    - 속도 느리거나 불안정한 네트워크 환경에서도 매우 잘 작동한다.
    - 옵션
        - -O {파일 명} : 다운로드 받은 파일 명 정하기
- **htop**
    - 현재 컴퓨터에서 실행되고 있는 프로그램의 목록을 보여주는 프로그램
    - 형태: `htop`
        - q를 누르면 나갈 수 있음
- **wc**
    - word count
    - input format : `wc [option] [files]`
        - counts the number of lines, words, bytes, and even characters and bytes in a text file
    - output format : `7 30 207 hello.txt`
        - **Column 1:** Displays the number of lines existing in the text file. As observed from the output, the file has seven lines. Be advised that this accounts for both the blank and the non-blank lines.
        - **Column 2:** This prints the word count.
        - **Column 3:** This displays the number of bytes in the file.
        - **Column 4:** This is the file name of the text file.
- **awk**
    - **A**ho + **W**einberger + **K**ernighan. → people who designed ‘awk’
    - input format : `awk [option] 'pattern { action }' [ARGUMENT]`
    
    ```bash
    # pattern 생략.
    $ awk '{ print }' ./file.txt       # file.txt의 모든 레코드 출력.
    
    # action 생략.
    $ awk '/p/' ./file.txt.       # file.txt에서 p를 포함하는 레코드 출력.
    ```
  ![awk-command](../img/awk-command.png)
        
    - input examples
        - 파일의 전체 내용 출력 : `awk '{ print }' [FILE]`
        - 필드 값 출력 : `awk '{ print $1 }' [FILE]`
        - 필드 값에 임의 문자열을 같이 출력 : `awk '{print "STR"$1, "STR"$2}' [FILE]`
        - 특정 필드들의 합 구하기 : `awk '{sum += $3} END { print sum }' [FILE]`
        - 필드에 연산을 수행한 결과 출력하기 : `awk '{print $1, $2, $3+2, $4, $5}' [FILE]`
        - 특정 레코드만 출력하기 : `awk 'NR == 2 { print $0; exit }' [FILE]`
- **grep**
    - input format : `grep`
        - Used to find the desired character or string
    - option
        - -i : Insensitive to uppercase and lowercase letters
- **diff**
    - input format : `diff [option] [file01] [file02]`
        - if the file contents are the same nothing is output
    - option
        - -c (context) : To view differences in context mode
        - -u (unified) **:** It is similar to context mode but it doesn’t display any redundant information
    
    [https://www.geeksforgeeks.org/diff-command-linux-examples/](https://www.geeksforgeeks.org/diff-command-linux-examples/)
    
- **sed**
    - streamlined editor (능률적인)
        - 수정, 치환, 삭제, 글 추가, 등 편집기 기능을 수행 가능.
        - vi, vim은 편집기를 열어서 수정하는 방식이라면, sed는 명령행에서 파일을 인자로 받고, sed 명령어를 통해 작업한 후에 결과를 화면으로 확인할 수 있다.
        - 모든 결과는 명렬을 수행한 화면으로 출력이 되고, 원본을 손상하지 않는다.
    - input format : `sed [option] [sed command]`
    - examples
    - [https://etloveguitar.tistory.com/47](https://etloveguitar.tistory.com/47)
        
        ```bash
        #첫 번째 라인만 출력
        sed -n '1p' richet.txt
        
        ```
        
- **ar**
    - archive (static library)
        - A static library is a form of compiled object files bundled into one archive.
    - input format : `ar [option] <.a> <.o1> <.o2> …`
        - Object file bundle command
    - option
        - r : If it is a new object file, it is added, if it is an existing file, it is replaced.
        - c : Create an archive (library file), do not output a warning message even when creating (or updating) an archive that does not exist
        - u : Compare the timestamp of the object file and replace only if it is a new file
        - s : Like ranlib(1), create an archive index. If the archive index is not created, the link speed will be slow, and an error may occur depending on the system environment.
## **User**
    
- ✅ root와 admin, user
    
`cat /etc/passwd` 하면 사용자 목록 출력가능

```bash
ouput format:
[ID : 패스워드 : UID : GID : 주석 : 홈디렉토리 : 쉘]
```

- **root :** 해당 시스템 전체의 관리권한을 가진 전지전능한 슈퍼유저 (**#** → `root상태일때 표시`)
- **admin** : 일반유저, Root가 원하면 관리권한을 줄 수 도 있음
- **user :** 그냥 일반유저 (**$** → `user상태일때 표시`)

- **sudo**
	- sudo(super user do) : super user의 권한으로 명령어 실행
	- 리눅스는 다중 사용자 시스템
	- permission(권한) : 각 사용자마다 할 수 있는 일과 할 수 없는 일을 정의해 놓음
	- super user(root user) : 사용자의 우두머리
- **groups**
	- input format : `groups [user01]`
	- 사용자가 포함된 그룹을 나열합니다.
- **addgroup**
	- input format : `addgroup [group01]`
- **getent**
	
	→ “**get entries from the administrative database”**
	
	- input format : `getent group [group_name]`
		- queries the `/etc/group` file and gets the entry for the mentioned group from the file.
	- output format : `group:password:GID:user(s)`
		- `group` is the group's name
		- `password` is the encrypted group password, empty field signifies no password, `x` bit signifies the password is in the file `/etc/gshadow`
		- `GID` is the Group ID
		- `user(s)` is the list of users member of this group, empty means this group has no member.
- **adduser**
	- input format : `adduser [user01] [group01]`
		- The adduser command automatically creates user-related settings, including the user's home directory. Specifies the default shell set by the user as the user's shell.
- **usermod**
	- input format : `usermod [option] [party01] [user01]`
	- option
		- -g : 주 그룹을 변경한다.
		- -G : 주 그룹은 그대로 두고 추가로 다른그룹에 속하게 할 때 쓰인다.
		- -a : -G 옵션과 같이 사용하는 옵션으로 기존의 2차 그룹 이외에 추가로 2차 그룹을 지정할 때 사용한다.
- **userdel**
	- input format : `userdel [option] [user01]`
	- option
		- -r : deletes the home directory too.
		- -f : ignore the error and forcefully delete.
- **su**
	- switch user
	- input format : `su [계정명]`
		- A command to switch the current user to another user's account without logging out.
	- input format2 : `su - 계정명`
		- A command to completely switch to another user's account and load the switched user's preferences(env settings).

## **Relative paths & Absolute paths**
    
    상대경로는 현재 디렉토리의 위치를 기준으로 다른 디렉토리의 위치를 표현하는 것으로 ..은 부모 디렉토리를 의미합니다. 'cd ..'은 현재 디렉토리의 부모 디렉토리로 이동하는 명령이 됩니다. 참고로 현재 디렉토리는 '.' 입니다.
    
    절대경로는 최상위 디렉토리를 기준으로 경로를 표현하는 것을 의미합니다. 최상위 디렉토리는 루트(root) 디렉토리라고 하고 '/' 입니다. 'cd /'는 최상위 디렉토리로 이동한다는 뜻입니다. 'cd /home/egoing'은 현재 디렉토리가 무엇이건 언제나 '/home/egoing'을 의미하는데 이런 식의 경로 표현을 절대경로라고 합니다.
    

## **How to get help**

---

- **-- help**
    - input format: `[command] **--help**`
    - 설명: 명령어 뒤에 --help를 붙이면 명령의 사용설명서가 출력됩니다.
    - 예
        - ls --help
        - rm --help
        - mkdir --help
        - pwd --help
- **man**
    - input format : **`man [command]`**
    - 설명: 명령어의 매뉴얼을 확인할 수 있다.
    - 세부 기능
        - /{검색하고 싶은 단어} : 검색 가능
        - q: 매뉴얼 나가기