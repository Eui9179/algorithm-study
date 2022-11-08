def solution(users:list):
    answer = 0
    n = len(users)
    
    while True:
        max_num = max(users)
        
        if n - max_num < 0:
            break
        
        users.remove(max_num)        
        n -= max_num
        answer += 1
        
    print(answer)

solution([2,3,1,2,2])