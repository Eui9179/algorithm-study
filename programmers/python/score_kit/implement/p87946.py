from itertools import permutations

def solution(k, dungeons):
    '''
    최소 피로도 - 던전에 들어갈 수 있는 피로도
    소모 피로도 - 던전에서 끝나면 소모되는 피로도
    
    최대한 많이 탐험해라
    '''

    '''
    permutations 모든 경우 고려
    '''

    perm = list(permutations(dungeons, len(dungeons)))
    answer = 0

    for case in perm:
        den = list(case)
        count = 0
        tmp_k = k

        for d in den:
            if tmp_k >= d[0]:
                tmp_k -= d[1]
                count += 1

        answer = max(answer, count)

    return answer
