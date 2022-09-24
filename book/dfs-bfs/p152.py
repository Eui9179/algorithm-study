from collections import deque

def solution(all_path:str):
    answer = 1
    
    # 경로 graph화
    path = all_path.split('\n')
    graph = [[int(g) for g in p] for p in path]
    
    # 종착지
    n = len(graph)
    m = len(graph[0])
    
    # 출발지
    graph[0][0] = 0
    queue = deque([(0,0)])
    
    while queue:
        q = queue.popleft()
        
        is_append = False
        y = q[0]
        x = q[1]
        
        if y == n-1 and x == m-1:
            return answer + 1
        
        if x+1 < m:
            if y == n-1 and x+1 == m-1:
                return answer + 1
            
            if graph[y][x+1] == 1:
                graph[y][x+1] = 0
                queue.append((y, x+1))
                is_append = True
                
        if x-1 >= 0:
            if y == n-1 and x-1 == m-1:
                return answer + 1
            
            if graph[y][x-1] == 1:
                graph[y][x-1] = 0
                queue.append((y, x+1))
                is_append = True
                
        if y+1 < n:
            if y+1 == n-1 and x == m-1:
                return answer + 1
            
            if graph[y+1][x] == 1:
                graph[y+1][x] = 0
                queue.append((y+1, x))
                is_append = True
                
        if y-1 >= 0:
            if y-1 == n-1 and x == m-1:
                return answer + 1
            
            if graph[y-1][x] == 1:
                graph[y-1][x] = 0
                queue.append((y-1, x))
                is_append = True
                
        if is_append:
            # 여러개가 추가되어도 한번 이동으로 간주
            answer += 1
        
path = '''101010
111111
000001
111111
111111'''

print(solution(path))