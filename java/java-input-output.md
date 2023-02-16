- [Java Input](#java-input)
  - [BuffereDReader](#bufferedreader)
    - [주의할 점](#주의할-점)
  - [StringTokenizer](#stringtokenizer)
- [Java Ouput](#java-ouput)
  - [BufferWriter](#bufferwriter)
      - [BOJ\_16928](#boj_16928)

# Java Input

## BuffereDReader
기존에 쓰던 `scanner`와 `System.out.println()`보다 속도 측면에서 훨씬 빠르기 때문에 (입력된 데이터가 바로 전달되지 않고 버퍼를 거쳐 전달되므로 데이터 처리 효율성을 높임) 많은 양의 데이터를 처리할 때 유리합니다.

### 주의할 점
1. readLine()시 리턴값을 String으로 고정되기에 String이 아닌 다른타입으로 입력을 받을려면 형변환을 꼭 해주어야합니다. 
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String s = bf.readLine(); //return 값이 String
int i = Integer.parseInt(bf.readLine()); //Int 
```
2. 예외처리를 꼭 해주어야 합니다. `readLine`을 할 때마다 try & catch를 활용하여 예외처리를 해주어도 되지만 대개 `throws IOException`을 통하여 작업합니다.

throw 이용 시

(1) 클래스를 import 해주어야 한다.
```java
import java.io.IOException; 
```
(2) main 클래스 옆에 throws IOException를 작성한다.
```java
public static void main(String[] args) throws IOException {}
```
---
 Read한 데이터는 Line단위로만 나눠지기에 공백단위로 데이터를 가공하려면 따로 작업을 해주어야 합니다.
1. StringTokenizer에 nextToken()함수를 쓰면 readLine()을 통해 입력받은 값을 공백단위로 구분하여 순서대로 호출할 수 있습니다.
2. String.split()함수를 활용하여 배열에 공백단위로 끊어서 데이터를 넣고 사용할 수 있습니다.

## StringTokenizer

```java
StringTokenizer st = new StringTokenizer(s); //StringTokenizer인자값에 입력 문자열 넣음

int a = Integer.parseInt(st.nextToken()); //첫번째 호출
int b = Integer.parseInt(st.nextToken()); //두번째 호출

String array[] = s.split(" "); //공백마다 데이터 끊어서 배열에 넣음
```

<br>

# Java Ouput

## BufferWriter
`BufferedWriter` 의 경우 버퍼를 잡아 놓았기 때문에 반드시 `flush()` / `close()` 를 반드시 호출해 주어 뒤처리를 해주어야 합니다.

`bw.write`에는 `System.out.println();`과 같이 자동개행기능이 없기때문에 개행을 해주어야할 경우에는 \n를 통해 따로 처리해주어야 합니다.

```java
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   //할당된 버퍼에 값 넣어주기
String s = "abcdefg";   //출력할 문자열
bw.write(s+"\n");   //버퍼에 있는 값 전부 출력
bw.flush();   //남아있는 데이터를 모두 출력시킴
bw.close();   //스트림을 닫음
```

#### BOJ_16928
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_16928_뱀과사다리게임 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[] snakeAndladder = new int[101];
        boolean[] isVisited = new boolean[101];
        int[] count = new int[101];

        for(int i = 0 ; i < N+M ; i++){
            stringTokenizer  = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stringTokenizer.nextToken());
            int v = Integer.parseInt(stringTokenizer.nextToken());

            snakeAndladder[u] = v;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        count[1] = 0;
        isVisited[1] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();

            if(now == 100){
                System.out.println(count[now]);
                break;
            }

            for(int i = 1; i <= 6; i++){
                int next = now + i;

                if(100 < next || isVisited[next])  continue;

                if(snakeAndladder[next] != 0){
                    if(!isVisited[snakeAndladder[next]]){
                        isVisited[snakeAndladder[next]] = true;
                        count[snakeAndladder[next]] = count[now] + 1;
                        queue.offer(snakeAndladder[next]);
                    }
                }
                else{
                    isVisited[next] = true;
                    count[next] = count[now] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}
```