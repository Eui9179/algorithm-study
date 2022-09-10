'''
python 문자열 자르기
"string"[0:3]
'''

def solution(number: str, k: int):
    num_list = [int(num) for num in number]
    index = 0
    
    while k > 0:
        if index + k + 1 > len(num_list):
            break
        
        comp_list = num_list[index: index + k + 1]
        
        max_num = 0
        
        for comp in comp_list:
            if comp == 9:
                max_num = 9
                break
            
            if max_num < comp:
                max_num = comp
        
        if max_num != comp_list[0]:
            max_num_index = comp_list.index(max_num)
            del(num_list[index : index + max_num_index])
            k -= max_num_index
            
        index += 1
            
    if k > 0:
        return number[:-k]
    
    return ''.join([str(num) for num in num_list])


print(solution("12312334123",5))