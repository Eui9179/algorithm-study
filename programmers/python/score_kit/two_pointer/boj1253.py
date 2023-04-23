n = int(input())
nums = sorted(list(map(int, input().split())))

answer = 0

for i in range(n):
    left = 0
    right = n - 1
    while left < right:
        S = nums[left] + nums[right]
        if left == i or S < nums[i]:
            left += 1
        elif right == i or S > nums[i]:
            right -= 1
        else:
            answer += 1
            break

print(answer)
