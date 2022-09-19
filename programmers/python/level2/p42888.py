# 오픈 채팅방

'''
<방의 로그가 보여질 때 중간에 이름을 바꾸면 바꾼이름으로 로그가 보이게>
[parameter] 기록 리스트
[return] 최종 보여질 리스트

[풀이방법]
기록에 uid(바뀌지 않는 값), nickname(변경 가능), behavior(행동)
nicknames = {uid : nickname} 형식으로 저장해놓고
닉네임이 변할 수 있는 행동에서 닉네임을 업데이트 해줌
마지막 결과 리스트를 출력할 때 nicknames[uid]로 변환해서 로그 반환
'''

def solution(record):
    answer = []
    logs = []
    
    nicknames = {}
    
    for r in record:
        split_r = r.split(' ')
        
        behavior = split_r[0]
        uid = split_r[1]
        
        if behavior != 'Leave':
            nicknames[uid] = split_r[2]
        
        if behavior != 'Change':
            logs.append(behavior_to_kor(uid, behavior))
    
    for l in logs:
        answer.append(nicknames[l[0]]+l[1])
        
    return answer

def behavior_to_kor(uid, behavior):
    if behavior == 'Enter':
        return  [uid, '님이 들어왔습니다.']
    elif behavior == 'Leave':
        return  [uid, '님이 나갔습니다.']

print(solution())
        
    