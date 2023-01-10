# Java Input

## BufferReader
기존에 쓰던 `scanner`와 `System.out.println()`보다 속도 측면에서 훨씬 빠르기 때문에 (입력된 데이터가 바로 전달되지 않고 버퍼를 거쳐 전달되므로 데이터 처리 효율성을 높임) 많은 양의 데이터를 처리할 때 유리합니다.

### 주의할 점
1. readLine()시 리턴값을 String으로 고정되기에 String이 아닌 다른타입으로 입력을 받을려면 형변환을 꼭 해주어야합니다. 
```java
BufferReader br = new BufferReader(new InputStreamReader(System.in));
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
1.  StringTokenizer에 nextToken()함수를 쓰면 readLine()을 통해 입력받은 값을 공백단위로 구분하여 순서대로 호출할 수 있습니다.

## StringTokenizer
```java
StringTokenizer st = new StringTokenizer(s); //StringTokenizer인자값에 입력 문자열 넣음
int a = Integer.parseInt(st.nextToken()); //첫번째 호출
int b = Integer.parseInt(st.nextToken()); //두번째 호출

String array[] = s.split(" "); //공백마다 데이터 끊어서 배열에 넣음
```

2.   String.split()함수를 활용하여 배열에 공백단위로 끊어서 데이터를 넣고 사용하는 방식이다.


# BOJ_16928
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