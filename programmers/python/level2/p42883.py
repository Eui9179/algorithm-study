# 큰 수 만들기

'''
<자리를 바꾸지 않고 k 자리만큼 숫자를 빼서 가장 큰 수 만들기>
[parameter] 큰 숫자(string),몇자리를 빼야하는지
[return] 숫자 string

[풀이방법]
숫자 string을 한 숫자씩 배열로 맵핑
index ~ k+1 까지 숫자배열 추출
추출한 배열 중 가장 큰 수 기준으로 앞 숫자들을 다 없앰
없앤 만큼 k에서 빼줌
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


print(solution("293",2))