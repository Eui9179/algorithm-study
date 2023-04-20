def binary_search(A, x):
    result = -1
    left = 0
    right = len(A) - 1

    while left <= right:
        mid = (left + right) // 2

        if A[mid] < x:
            left = mid + 1

        elif A[mid] > x:
            right = mid - 1
        else:
            right = mid - 1
            result = mid

    return result


def upper_bound(A, left, right, x):
    result = len(A)

    while left <= right:
        mid = (left + right) // 2

        if A[mid] < x:
            left = mid + 1
        else:
            right = mid - 1
            result = mid

    return result


n = int(input())
my_cards = sorted(list(map(int, input().split())))

m = int(input())
cards = list(map(int, input().split()))

answer = []

for card in cards:
    left = 0
    right = n - 1

    result_start = binary_search(my_cards, card)
    result_end = upper_bound(my_cards, result_start, right, card + 1)

    if result_start == -1:
        answer.append(0)
        continue

    answer.append(result_end - result_start)

for a in answer:
    print(a, end=" ")
