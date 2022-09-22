# 미해결

def solution(numbers):
    answer = ''
    
    num_map = {str(key):[] for key in range(9, -1, -1) }
    for number in numbers:
        s_number = str(number)
        num_map[s_number[0]].append(s_number)
    
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
                        
                        last_digit = int(t[len(num)])
                          
                        if is_append:
                            pass
                        
                        elif last_digit < int(num[0]):
                            tmp.insert(i, num)
                            is_append = True
                        
                        elif last_digit == int(num[0]):
                            for n in num:
                                if last_digit < int(n):
                                    tmp.insert(i, num)
                                    is_append = True
                                    break
                    
                    elif  len(t) < len(num):
                        for j in range(1, len(t)):
                            numj = int(num[j])
                            tj = int(t[j])
                            
                            if numj > tj: # 들어올 값이 클때
                                tmp.insert(i, num)
                                is_append = True
                                break
                            
                        last_digit = int(num[len(t)])
                        if is_append:
                            pass
                            
                        elif last_digit > int(t[0]): # 들어올 값이 클때
                            tmp.insert(i, num)
                            is_append = True
                                
                        elif last_digit == int(t[0]):
                            for t_num in t:
                                if last_digit > int(t_num):
                                    tmp.insert(i, num)
                                    is_append = True
                                    break
                            
                    elif len(t) == len(num):
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
                                
                if not is_append:
                    tmp.append(num)
                    is_append = True
                    
            for t in tmp:
                answer += t
        else:
            for num in num_map[num_key]:
                answer += num
        
    i = 0
    count = 0
    while i < len(answer)-1:
        if answer[i] != '0':
            break
        else:
            count += 1
        i += 1
        
    return answer[count:len(answer)]

'''
[232,23] : 23/232 : (23232)
[212,21] : 212/21 : (21221)
[70,0,0,0,0] : 70/0/0/0/0 : (700000)
23, 232, 21, 212
'''

print(solution([23, 232, 21, 212]))