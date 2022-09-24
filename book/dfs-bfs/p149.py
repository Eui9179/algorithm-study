# 음료수 얼려먹기
# 0만 뭉쳐있는 부분 개수 출력
# dfs 재귀함수 이용

ice_frame = '''00110
00011
11111
00000'''

ice = ice_frame.split('\n')
graph = [[int(a) for a in i] for i in ice]

n = len(graph)
m = len(graph[0])

def dfs(x, y):
    if x <= -1 or x >= n or y <= -1 or y >= m:
        return False
    
    if graph[x][y] == 0:
        graph[x][y] = 1 # 방문한 곳은 표시해줘야됨
        dfs(x+1, y)
        dfs(x-1, y)
        dfs(x, y+1)
        dfs(x, y-1)
        return True
    
    return False

result = 0
for x in range(n):
    for y in range(m):
        if dfs(x, y) == True:
          result += 1
          
print(result)  