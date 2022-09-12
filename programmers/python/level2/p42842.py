# 카펫

def solution(brown, yellow):
    answer = []
    if yellow == 1:
        return [3, 3]
    
    for w in range(yellow, 0, -1):
        if yellow % w == 0:
            h = yellow / w
            if (2*(w + h -2) + 8) == brown:
                return [w + 2, int(h) + 2]
        
    return answer

print(solution(24,24))