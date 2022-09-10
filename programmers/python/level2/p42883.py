'''
python 문자열 자르기
"string"[0:3]
'''

def solution2(number: str, k: int):
    answer = ''
    
    num_list = [int(num) for num in number]
    index = 0
    
    while k > 0:        
        if index + k + 1 > len(num_list):
            break
        
        comp_list = num_list[index: index + k + 1]
        
        max_num = max(comp_list)
        
        if max_num == comp_list[0]:
            index += 1
        else:
            del(num_list[index : index + comp_list.index(max_num)])
            k -= comp_list.index(max_num)
            
    if k > 0:
        for i in range(k):
            num_list.remove(min(num_list))
    
    return answer.join([str(num) for num in num_list])

print(solution2("123123",5))