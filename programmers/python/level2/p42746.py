# 정렬 - 가장 큰수
# 다시 풀어야됨

def solution(numbers):# "1 11 110 1110"
    answer = ''
    
    num_map = {str(key):[] for key in range(9, -1, -1) }
    for number in numbers:
        s_number = str(number)
        num_map[s_number[0]].append(s_number)
    
    # 232 23
    for num_key in num_map:
        if len(num_map[num_key]) > 1:
            tmp = [num_map[num_key].pop(0)]
            
            for num in num_map[num_key]:
                is_append = False
                
                for i in range(len(tmp)):
                    if is_append:
                        break
                    
                    t = tmp[i]
                    
                    if len(num) < len(t):    
                        for j in range(1, len(num)):
                            numj = int(num[j])
                            tj = int(t[j])
                            
                            if numj > tj: # 들어온 값이 클때
                                tmp.insert(i, num)
                                is_append = True
                                break
                        if is_append:
                            pass
                        
                        elif int(t[len(num)]) < int(t[0]) and  int(t[len(num)]) < t[1]:
                            tmp.insert(i, num)
                            is_append = True
                        # 끝자리가 같을때 어떻게 처리?
                        
                            
                    elif  len(t) < len(num):
                        for j in range(1, len(t)):
                            numj = int(num[j])
                            tj = int(t[j])
                            
                            if numj > tj: # 들어올 값이 클때
                                tmp.insert(i, num)
                                is_append = True
                                break
                            
                        if not is_append and int(num[len(t)]) > int(t[0]): # 들어올 값이 클때
                                tmp.insert(i, num)
                                is_append = True
                                
                        if not is_append and t[len(num)] == t[0]:
                            tmp.insert(i, num)
                            is_append = True
                        
                    elif len(t) == len(num):
                        # t: 979, 978
                        if int(t) == int(num):
                            tmp.insert(i, num)
                            is_append = True
                            
                        else:
                            for j in range(1, len(t)):
                                numj = int(num[j])
                                tj = int(t[j])
                                
                                if numj > tj:
                                    tmp.insert(i, num)
                                    is_append = True
                                    break
                                
                    if not is_append: # 아무데도 못들어갔다면
                        tmp.append(num)
                        is_append = True
                        
                print(tmp)
                    
            for t in tmp:
                answer += t + ' '
        else:
            for num in num_map[num_key]:
                answer += num + ' '
        
    return answer
    
# [6, 10, 2]

# 맨 앞자리가 9일때 가장 큼

# if 앞자리가 같은데 다음 자리가 다르다면?
# 다음수가 맨 앞자리보다 크고 그중 가장 큰수를 가져온다
'''
[232,23] : 23/232 : (23232)
[212,21] : 212/21 : (21221)
[70,0,0,0,0] : 70/0/0/0/0 : (700000)
'''
print(solution([232,23]))

# 979 97 978 818 81 817

a = ['1','2']

atmp = a.insert(0,'2')
btmp = a.insert(0,'3')
