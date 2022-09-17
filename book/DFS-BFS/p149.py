# 음료수 얼려먹기

ice_frame = '''00110
00011
11111
00000'''

ice = ice_frame.split('\n')
arrays = [[int(a) for a in i] for i in ice]
n = 4
m = 5

def solution():
    result = 0
    for i in range(n):
        for j in range(m):
            if dfs(i, j) == True:
              result += 1
              
    return result  

def dfs(x, y):
    # 0에서 시작해서 자기를 포함해서 주변을 다 1로 만듬
    if x <= -1 or x >=n or y <= -1 or y >= m:
        return False
    
    if arrays[x][y] == 0:
        arrays[x][y] = 1
        dfs(x-1, y)
        dfs(x+1, y)
        dfs(x, y-1)
        dfs(x, y+1)
        
        return True
    
    return False


print(solution())

