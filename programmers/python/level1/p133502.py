def solution(ingredient:list):
    answer = 0
    last_i = 0
    i = 0
    
    while i < len(ingredient)-3:
        if ingredient[i] == 1 and\
            ingredient[i + 1] == 2 and \
            ingredient[i + 2] == 3 and \
            ingredient[i + 3] == 1:
                answer += 1
                ingredient = ingredient[:i] + ingredient[i+4:]
                i = last_i
        
        elif ingredient[i] != 1:
            last_i = i
        
        i += 1

    return answer

print(solution([2, 1, 1, 2, 3, 1, 2, 3, 1]))