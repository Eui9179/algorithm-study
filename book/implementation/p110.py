def solution(n:int, behavior:list):
    coor = [1,1]
    for be in behavior:
        coor = go(be, coor, n)
        print(coor)
        
    return coor

def go(behavior:str, coor:list, n:int):
    if behavior == 'R' and is_over(n, coor[1]+1):
        return [coor[0], coor[1] + 1]
    elif behavior == 'L' and is_over(n, coor[1]-1):
        return [coor[0], coor[1] - 1]
    elif behavior == 'U' and is_over(n, coor[0]-1):
        return [coor[0] - 1, coor[1]]
    elif behavior == 'D' and is_over(n, coor[0]+1):
        return [coor[0] + 1, coor[1]]
    return coor
    
def is_over(n, coor):
    if n < coor or coor <= 0:
        return False
    return True

print(solution(5, ['R','R','R','U','D','D']))