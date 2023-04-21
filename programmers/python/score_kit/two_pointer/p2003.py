n, m = map(int, input().split())
nums = list(map(int, input().split()))

answer = 0
S = 0
right = 0

for left in range(n):
    while right < n and S < m:
        S += nums[right]
        right += 1

    if S >= m:
        if S == m:
            answer += 1
        S -= nums[left]

print(answer)