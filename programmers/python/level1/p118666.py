# 성격 유형 테스트

def solution(survey, choices):
    answer = ''
    
    personalities = {
        'R':0,
        'T':0,
        'C':0,
        'F':0,
        'J':0,
        'M':0,
        'A':0,
        'N':0
    }
    
    for i in range(len(survey)):
        if choices[i] < 4:
            selected_personality = survey[i][0]
            personalities[selected_personality] += 4 - choices[i]
        elif choices[i] > 4:
            selected_personality = survey[i][1]
            personalities[selected_personality] += choices[i] - 4
    
    if personalities['R'] < personalities['T']:
        answer += 'T'
    else:
        answer += 'R'
    if personalities['C'] < personalities['F']:
        answer += 'F'
    else:
        answer += 'C'
    if personalities['J'] < personalities['M']:
        answer += 'M'
    else:
        answer += 'J'
    if personalities['A'] < personalities['N']:
        answer += 'N'
    else:
        answer += 'A'    
            
    return answer

survey = ["AN", "CF", "MJ", "RT", "NA"]
choices = [5, 3, 2, 7, 5]

print(solution(survey=survey, choices=choices)) # Result: "TCMA"
