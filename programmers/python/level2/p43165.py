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


'''  stack = []

  4 1 2 1

  4
    -1
      -2
        -1
        +1
      +2
        -1
        +1
    +1
      -2
        -1
        +1
      +2
        -1
        +1

  -4
    -1
      -2
        -1
        +1
      +2
        -1
        +1
    +1
      -2
        -1
        +1
      +2
        -1
        +1

  -4 -1 -2 -1
  +4 +1 +2 +1

'''
