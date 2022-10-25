## Maximum recursion depth exceed


```python
import sys
sys.setrecursionlimit(100000)
```
---
⚠️ 파이썬(Python)에서는 **1000번** 이상의 <u>재귀(recursion)</u>가 발생하면 에러가 뜬다.

기본 재귀 깊이 제한이 매우 적기 때문에 반드시 `sys.setrecursionlimit()` 함수를 사용하여 재귀 깊이를 크게 잡아주어야 한다.

파이썬으로 재귀를 사용해 문제를 풀 때 *(특히 BFS, DFS)* 는 항상 위 함수를 사용하여 코드를 작성하는 것이 좋다!  


 [Reference](https://ye5ni.tistory.com/178)
