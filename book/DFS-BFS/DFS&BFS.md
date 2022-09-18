# DFS-BFS

- 대표적인 탐색 알고리즘

- 사전에 필요한 지식으로 스택, 큐, 재귀함수를 먼저 알아보자

# 스택

 스택은 박스 쌓기에 비유할 수 있다. 아래부터 쌓고 박스를 치우기 위해서는 위에 있는 박스를 먼저 내려야한다. 이러한 구조를 선입후출 `FILO` 구조라고한다.

파이썬 코드로 표현하면 다음과 같다.

		stack = []
		
		stack.append(1)
		stack.append(2)
		stack.append(3)
		# stack: [1, 2, 3]
		
		stack.pop()
		# stack: [1, 2]
		
		stack.pop()
		# stack: [1]	
	
파이썬에서는 기본 리스트에 append()와 pop() 메서드를 이용하면 스택 자료구조와 동일하게 동작한다.

# 큐

큐는 대기 줄에 비유할 수 있다. 먼저 온 사람이 먼저 들어온 것처럼 선입선출`FIFO` 구조라고 한다.

 파이썬 코드로 표현하면 다음과 같다

		from collections import deque
		
		# 큐 구현을 위해 deque 라이브러리사용
		queue = deque()
		
		queue.append(1)
		queue.append(2)
		queue.append(3)
		# queue [1, 2, 3]
		
		queue.popleft()
		# queue[2, 3]
		
		queue.popleft()
		# queue[3]

파이썬으로 큐를 구현할 때는 collections 모듈에서 제공하는 deque 자료구조를 활용할 수 있다. list로 변경하고자 한다면 list() 함수를 이용한다.

# 재귀 함수

DFS와 BFS를 구현하려면 재귀 함수도 이해하고 있어야 한다. **재귀 함수**란 자기 자신을 다시 호출하는 함수다.

## 재귀 함수 종료 조건

재귀 함수는 언제 끝날지 종료 조건을 꼭 명시해야 한다.
 
 		def recursive_function(i):
 		
 			# 100번째 출력했을 때 종료되도록 종료
 			if i == 100:
 				return
 			
 			recursive_function(i+1)
 
 			recursive_function(1)
 
컴퓨터 내부에서 재귀함수의 수행은 스택 자료구조를 이용한다. 따라서 스택 자료구조를 활용해야 하는 상당수 알고리즘은 재귀함수를 이용해서 간편하게 구현될 수 있다. DFS가 대표적인 예이다.

대표적인 예로 팩토리얼 문제가 있다.

		def factorial_recursive(n):
			if n <= 1:
				return n
			
			return n * factorial_recursive(n - 1)


 # DFS
 
 DFS는 `Depth-First Search`, 깊이 우선 탐색이라고도 부르며, 그래프에서 깊은 부분을 우선적으로 탐색하는 알고리즘이다.
 DFS를 설명하기 전에 그래프 구조를 알아야한다.
 
 ## 그래프

 그래프는 노드`node`와 간선`edge`으로 표현되며 이때 노드를 정점이라고도 말한다. 
 프로그래밍에서 그래프는 크게 2가지 방식으로 표현할 수 있다.
 
 	- 인접 행렬(Adjacency Matrix): 2차원 배열로 그래프의 연결 관계를 표현하는 방식
 	- 인접 리스트(Adjacency List): 리스트로 그래프의 연결 관계를 표현하는 방식

인접 행렬 방식은 모든 관계를 저장하므로 노드 개수가 많을수록 메모리가 불필요하게 낭비된다. 반면에 인접 리스트 방식은 연결된 정보만을 저장하기 때문에 메모리를 효율적으로 사용한다. 하지만 이와 같은 속성 때문에 인접 리스트 방식은 인접 행렬 방식에 비해 특정한 두 노드가 연결되어 있는지에 대한 정보를 얻는 속도가 느리다. (주변을 다 확인해야하기 때문)

## DFS 탐색 방식

**DFS**는 `깊이 우선 탬색` 알고리즘이다. 이 알고리즘은 특정한 경로로 탐색하다 특정한 상황에 최대한 깊숙이 들어가서 노드를 방문한 후, 다시 돌아가 다른 경로로 탐색하는 알고리즘이다.

1. 탐색 시작 노드를 스택에 삽입하고 방문 처리를 한다.
2. 스택의 최상 노드에 방문하지 않은 인접 노드가 있으면 그 인접 노드를 스택에 넣고 방문 처리를 한다. 방문하지 않은 인접 노드가 없으면 스택에서 최상단 노드를 꺼낸다.
3. 2번 과정을 더 이상 수행할 수 없을 때까지 반복한다.

(침고: 취업을 위한 코딩테스트 p.137)

# BFS

**BFS**알고리즘은 `너비 우선 탐색`이라는 의미를 가진다. 쉽게 말해 가까운 노드부터 탐색하는 알고리즘이다. BFS 구현에서는 선입 선출 방식인 큐 자료구조를 이용하는 것이 정석이다.

1. 탐색 시작 노드를 큐에 삽입하고 방문 처리를 한다.
2. 큐에서 노드를 꺼내 해당 노드의 인접 노드 중에서 방문하지 않은 노드를 모든 큐에 삽입하고 방문 처리를 한다.
3. 2번 과정을 더 이상 수행할 수 없을 때까지 반복한다.

(참고: 취업을 위한 코딩테스트 p.144)

BFS는 큐 자료구조에 기초한다는 점에서 구현이 간단하다. 실제로 구현함에 있어서 deque 라이브러리를 사용해 구현한다. 일반적인 경우 DFS보다 수행시간은 좋은 편이다.
