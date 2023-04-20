answer = 0
n = int(input())
nums = sorted(list(map(int, input().split())))
x = int(input())

for i in range(len(nums)):
    a_j = x - nums[i]

    left = i + 1
    right = n - 1

    while left <= right:
        mid = (left + right) // 2

        if nums[mid] < a_j:
            left = mid + 1
        elif nums[mid] > a_j:
            right = mid - 1
        else:
            answer += 1
            break

print(answer)