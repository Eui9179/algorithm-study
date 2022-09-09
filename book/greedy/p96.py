# 숫자 카드 게임

arr1 = '''3 1 2
4 1 4
2 2 2'''

arr2 = '''7 3 1 8
3 3 3 4'''

def solution(arr: str):
    result = 0
    arr_row = arr.split('\n')
    for arr in arr_row:
        arr_col = arr.split(' ')
        arr_int_col = [int(num) for num in arr_col]
        min_num = min(arr_int_col)
        result = max(result, min_num)
    
    print(result)
    
solution(arr2)
    