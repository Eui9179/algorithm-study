import math


def solution(s):
    answer = []
    s_list = list(s)
    d = dict()

    for i in range(len(s_list)):
        if s_list[i] in d:
            answer.append(i - d[s_list[i]])
        else:
            answer.append(-1)
        d[s_list[i]] = i
    return answer