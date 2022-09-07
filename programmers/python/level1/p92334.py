# 신고 결과 받기
def solution(id_list, report, k):

    answer = [0 for i in range(len(id_list))]
    noti = {name : [] for name in id_list}

    report = list(set(report))
    
    for r in report:
        splited_report = r.split(' ')
        noti[splited_report[1]].append(splited_report[0]) 

    for n in noti:
        if len(noti[n]) >= k:
            for reporter in noti[n]:
                answer[id_list.index(reporter)] += 1
    
    return answer


id_list = ["muzi", "frodo", "apeach", "neo"]
report = ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]

print(solution(id_list, report, 2))

