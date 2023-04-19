def solution(n, times):
    answer = 0
    times.sort()
    left = times[0]
    right = times[-1] * n  # 최대 시간

    while left <= right:
        mid = (left + right) // 2

        possible = 0
        for time in times:
            possible += (mid // time)  # 현재 시간으로 처리 가능한 사람 수를 계산

        if possible < n:
            left = mid + 1

        elif possible >= n:
            right = mid - 1
            answer = mid

    return answer
