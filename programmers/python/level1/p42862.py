#체육복

def solution(n:int, lost:list, reserve:list):
    _lost = sorted([l for l in lost if l not in reserve])
    _reserve = sorted([r for r in reserve if r not in lost])
    
    answer = n - len(_lost)
    
    for l in _lost:
        for r in _reserve:
            if abs(l - r) <= 1:
                _reserve.remove(r)
                answer += 1
                break
        
    return answer

print(solution(5, [1, 3], [1]))