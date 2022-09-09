# 큰 수의 법칙

def solution(nums:list, m, k):
    result = 0
    
    max1 = max(nums)
    nums.remove(max1)
    
    max2 = max(nums)
    nums.remove(max2)
    
    result = (max1 * ((m//k)*k)) + (max2 * (m%k) )
    print(result)
    
solution([3,4,3,4,3],8,2)