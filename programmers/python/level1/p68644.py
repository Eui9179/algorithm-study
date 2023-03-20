from itertools import combinations

def solution(numbers):
    answer = []
    
    combs = list(combinations(numbers, 2))
    
    for comb in combs:
        answer.append(comb[0] + comb[1])
        
    return sorted(set(answer))

print(solution([2,1,3,4,1]))