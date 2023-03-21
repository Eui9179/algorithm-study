#폰켓몬

def solution(nums):
    set_nums_len = len(set(nums))
    nums_half_len = int(len(nums) / 2)

    return min(set_nums_len, nums_half_len)

nums = [3,1,2,3]
print(solution(nums))
