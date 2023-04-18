import heapq

def check(scoville, k):
    for s in scoville:
        if s < k:
            return False
    return True

def solution(scoville, k):
    answer = 0
    scoville.sort()

    while not check(scoville, k):
        if len(scoville) == 1:
            return -1
        s1 = heapq.heappop(scoville)
        s2 = heapq.heappop(scoville)
        heapq.heappush(scoville, s1 + (s2 * 2))
        answer += 1

    return answer

solution([1,2,3,9,10,12], 7)