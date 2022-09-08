'''
python 집합

교집합: s1 & s2
합집합: s1 | s2
차집합: s1 - s2
'''
#완주하지 못한 선수
def solution(participant, completion):
    participant.sort()
    completion.sort()
    
    for i in range(len(completion)):
        if (participant[i] != completion[i]):
            return participant[i]
    return participant[-1]
        
    

p = ["marina", "josipa", "nikola", "vinko", "filipa"]
c =["josipa", "filipa", "marina", "nikola"]
print(solution(p,c))
