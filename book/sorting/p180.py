'''
[python solted lambda]

solted key에 튜플이나 배열의 인덱스를 넘겨줘서 정렬 기준을 넣을 수 있다.
sorted(배열, key=lambda 배열:배열 기준)
'''

def solution(arr):
    stu = []
    
    for i in range(1, len(arr)):
        stu_info = arr[i].split(' ')
        stu.append(
            [stu_info[0], int(stu_info[1])]
        )
        
    # result = sorted(stu, setting)
    result = sorted(stu, key=lambda stu: stu[1])
    
    return result
        
# def setting(data):
#     return data[1]
        
arr = [4, '이의찬 99', '이지원 100', '김지원 65', '호영훈 80']
print(solution(arr))
