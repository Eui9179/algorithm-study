# 게임 맵 최단거리
'''
<(n,m) 타일로 가는 최소경로>
[parameter] 2차원 배열, 0: 벽, 1: 길
[return] 지나온 최소 타일의 수

[풀이 방식]
(0,0) 부터 시작해서 맵을 벗어나지 않고 벽에 부딪히지 않으면서
현재 타일의 값이 1일때만(처음 도착한 타일) 
이전 지나온 타일의 값을 더함
그 다음 타일을 큐에 넣고 반복
'''

from collections import deque

def solution(maps):
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    
    n = len(maps) # 목적지 (n, m)
    m = len(maps[0])
    
    que = deque([(0, 0)]) # 출발지를 큐에 넣음
    
    while que:
        position = que.popleft()
        
        for i in range(4):
            pre_y = position[0] # 이전 위치의 값
            pre_x = position[1] 
            
            y = pre_y + dy[i]
            x = pre_x + dx[i]
            
            if y >= n or y < 0 or x >= m or x < 0:
                # 맵을 벗어남
                continue
            
            if maps[y][x] < 1 or maps[y][x] > 1:
                # 벽을 만났거나 이미 지나온 자리(1보다 크기때문)
                continue
            
            if y == n - 1 and x == m - 1:
                # 목적지 도착
                return maps[pre_y][pre_x] + 1
            
            # 처음 가는 타일
            maps[y][x] = maps[pre_y][pre_x] + 1
            que.append((y,x))
                
    return -1

maps =[[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]
print(solution(maps))