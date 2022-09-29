'''
<[4, 1, 2, 1] 배열의 자리를 바꾸지 않고 더하고 빼서 target 숫자로 만들기>
[parameter] 숫자 배열, 목표 숫자
[return] 숫자 조합개수

[풀이 방법]
깊이 우선탐색 이용
+4
  +1
    +2
      +1
      -1
    -2
      +1
      -1
  -1
    +2
      +1
      -1
    -2
      +1
      -1
      
-4
  +1
    ...
  -1
    ...
''' 

count = 0

def solution(numbers, target):
    global count
    
    dfs(numbers,target, 0, 0, '+')
    dfs(numbers,target, 0, 0, '-')
    
    return count
    
def dfs(numbers, target, index, sum_nums, sign):
    global count
    
    if index == len(numbers) - 1:
        sum_nums += int(sign + str(numbers[index]))
        
        if sum_nums == target:
            count += 1
            
        return 
    
    sum_nums += int(sign + str(numbers[index]))
    
    dfs(numbers, target, index + 1, sum_nums, '-')
    dfs(numbers, target, index + 1, sum_nums, '+')
    
    
solution([1,1,1,1,1], 3)