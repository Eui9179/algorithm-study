n, k = map(int, input().split())
characters = list(map(int, input().split()))

answer = int(1e9)
right = 0
cur_k = 0

for left in range(n):
    while right < n and cur_k < k:
        if characters[right] == 1:
            cur_k += 1
        right += 1

    if cur_k == k:
        answer = min(answer, right - left)

    if characters[left] == 1:
        cur_k -= 1

if answer == int(1e9):
    print(-1)
else:
    print(answer)