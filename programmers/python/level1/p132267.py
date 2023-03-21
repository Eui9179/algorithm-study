def solution(a, b, n):
    answer = 0
    while n >= a:
        left = (n % a)
        n = int(n / a) * b
        answer += n
        n += left
    return answer

print(solution(2, 1, 20))

