def lower_bound(A, person):
    left = 0
    right = len(A) - 1
    while left <= right:
        mid = (left + right) // 2

        if A[mid] < person:
            left = mid + 1

        elif A[mid] > person:
            right = mid - 1

        else:
            return True

    return False


answer = []

n, m = map(int, input().split())
not_listen = []
not_see = []

for _ in range(n):
    not_listen.append(input())

for _ in range(m):
    not_see.append(input())

not_see.sort()

for nl in not_listen:
    if lower_bound(m, not_see, nl):
        answer.append(nl)

answer.sort()
print(len(answer))

for a in answer:
    print(a)
