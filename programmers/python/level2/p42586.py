def solution(progresses, speeds):
    answer = []
    build_count = 0
    
    while progresses:
        print(progresses)
        for i in range(len(progresses)):
            if progresses[i] < 100:
                progresses[i] += speeds[i]
                
        while progresses[0] >= 100:
            progresses.pop(0)
            speeds.pop(0)
            build_count += 1
            
            if not progresses:
                break
            
        if build_count != 0:
            answer.append(build_count)
            build_count = 0
            
    return answer
	
p = [40, 93, 30, 55, 60, 65]
s = [60, 1, 30, 5, 10, 7]
# [2, 1]
print(solution(p, s))