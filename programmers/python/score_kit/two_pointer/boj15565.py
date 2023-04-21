# 라이언 1 어피치 2
# k개 이상 있는 가장 작은 연속된 인형들의 집합의 크기
# 1 222 1 2 1 22 1
#       >        < = 6
# 미완료

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


print(answer)