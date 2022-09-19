from collections import deque

def solution(maps):
    
    # 하나 갈때마다 1씩 증가
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    
    n = len(maps)
    m = len(maps[0])
    
    que = deque([(n-1, m-1)])
    
    while que:
        position = que.popleft()
        
        for i in range(4):
            pre_x = position[1]
            pre_y = position[0]
            
            x = pre_x + dx[i]
            y = pre_y + dy[i]
            
            if x >= m or x < 0 or y >= n or y < 0:
                continue
            
            if maps[y][x] == 0:
                continue
            
            if x == 0 and y == 0:
                return maps[pre_y][pre_x] + 1
            
            if maps[y][x] == 1:
                maps[y][x] = maps[pre_y][pre_x] + 1
                que.append((y,x))
                print(que)
                print(maps[y][x])
                
    return -1

maps = [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]
print(solution(maps))