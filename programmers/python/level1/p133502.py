def solution(ingredient:list):
    q = []
    answer = 0
    
    for i in ingredient:
        q.append(i)
        print(q)
        if len(q) > 3:
            print(q[-4:])
            if q[-4:] == [1,2,3,1]:
                answer += 1
                q.pop(-1)
                q.pop(-2)
                q.pop(-3)
                q.pop(-4)
        
        
    answer = 0
    return answer

print(solution([2, 1, 1, 2, 3, 1, 2, 3, 1]))