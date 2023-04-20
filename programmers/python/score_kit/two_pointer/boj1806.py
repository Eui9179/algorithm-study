n, s = map(int, input().split())
numbers = list(map(int, input().split()))

answer = n + 1
cur_s = 0
right = 0

for left in range(n):
    while right < n and cur_s < s:
        cur_s += numbers[right]
        right += 1

    if cur_s >= s:
        answer = min(answer, right - left)
        cur_s -= numbers[left]

if answer == n + 1:
    print(0)
else:
    print(answer)

