n = int(input())
numbers = sorted(list(map(int, input().split())))
numbers.insert(0, 0)

m = int(input())
tests = list(map(int, input().split()))

for test in tests:
    left = 1
    right = n
    result = 0
    while left <= right:
        mid = (left + right) // 2

        if numbers[mid] < test:
            left = mid + 1
        elif numbers[mid] > test:
            right = mid - 1
        else:
            result = 1
            break

    print(result)
