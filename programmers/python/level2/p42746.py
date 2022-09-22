# 정렬 - 가장 큰수
# 다시 풀어야됨

def solution(numbers):
    answer = ''
    
    num_map = {str(key):[] for key in range(9, -1, -1) }
    
    for number in numbers:
        s_number = str(number)
        num_map[s_number[0]].append(number)
        
    for num_key in num_map:
        if len(num_map[num_key]) > 1:
            tmp = []
            
            for num in num_map[num_key]:
                s_num = str(num)
                tmp.append([int(n) for n in s_num])
            
                        
        for num in num_map[num_key]:
            answer += str(num)
        
    # print(num_map)
    
    return answer
    
# [6, 10, 2]

# 맨 앞자리가 9일때 가장 큼

# if 앞자리가 같은데 다음 자리가 다르다면?
# 다음수가 맨 앞자리보다 크고 그중 가장 큰수를 가져온다
'''
1 [3, 3, 3, 5, 9]
2 [4, 0, 4, x, x]
3 [2, x, x, x, x]
4 [x, x, x, x, x]
'''

'''
1. 9 부터 싹 가져옴
2. 2번째 자리가 같다면 정렬
3. 3번째 자리가 같다면 정렬
4. 4번째 자리가 같다면 정렬
'''
print(solution([3, 30, 34, 345, 9, 5]))

