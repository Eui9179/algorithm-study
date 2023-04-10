def solution(clothes):
    answer = 1
    dic = {}

    for cloth in clothes:
        if not cloth[1] in dic.keys():
            dic[cloth[1]] = [cloth[0]]
        else:
            dic[cloth[1]].append(cloth[0])

    for key in dic.values():
        answer *= (len(key) + 1)

    return answer - 1

print(solution([["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]))