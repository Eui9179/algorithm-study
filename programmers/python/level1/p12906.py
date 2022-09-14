def solution(arr):
    answer = []
    for i in range(len(arr)-1):
        if arr[i] != arr[i+1]:
            answer.append(arr[i])
            
    answer.append(arr[-1])
        
    return answer

a = [1,1,3,3,0,1,1]	
# [1,3,0,1]

solution([])