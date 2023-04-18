def solution(prices):
    answer = [0] * len(prices)
    prices_len = len(prices)
    for i in range(prices_len - 1):
        for j in range(i + 1, prices_len):
            answer[i] += 1
            if prices[i] > prices[j]:
                break
    return answer

solution([1,2,3,2,3])