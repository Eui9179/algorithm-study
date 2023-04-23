n = int(input())
nums = list(map(int, input().split()))

max_num = max(nums)

visited = [False] * (max_num + 1)
right = 0
answer = 0
count = 0

for left in range(n):
    while right < n and not visited[nums[right]]:
        visited[nums[right]] = True
        answer += 1
        right += 1

    if visited[nums[left]]:
        visited[nums[left]] = False
        answer += right - (left + 1)

print(answer)