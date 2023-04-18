def solution(citations: list):
    answer = 0

    citations.sort()
    max_c = citations[-1]
    last_j = 0

    for i in range(max_c):
        for j in range(last_j, len(citations)):
            if citations[j] >= i:
                right = len(citations[j:])
                left = len(citations[:j])

                if left <= i <= right:
                    answer = i
                    last_j = j
                break
    return answer