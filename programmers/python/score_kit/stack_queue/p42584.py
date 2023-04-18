def solution(prices):
    answer = []
    prices_len = len(prices)
    for i in range(prices_len - 1):
        count = 0
        for j in range(i + 1, prices_len):
            count += 1
            if prices[i] > prices[j]:
                break
        answer.append(count)

    answer.append(0)
    return answer

solution([1,2,3,2,3])