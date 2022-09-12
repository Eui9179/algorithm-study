# 오픈 채팅방

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
        
    