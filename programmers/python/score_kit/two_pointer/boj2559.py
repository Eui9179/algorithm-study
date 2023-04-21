n, k = map(int, input().split())
days = list(map(int, input().split()))

S = 0
right = 0

while right < k:
    S += days[right]
    right += 1

answer = S

for left in range(n - k):
    S -= days[left]

    S += days[right]
    right += 1

    answer = max(answer, S)

print(answer)

