def solution(d:list, budget:int):    
    answer = 0
    d.sort()
    
    for dept in d:
        if budget < dept:
            break
        budget -= dept
        answer += 1
    
    return answer