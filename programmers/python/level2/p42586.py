# 기능 개발
'''
<각각의 기능이 100이 되면 빌드, 이전 기능이 완료돼야 다음 기능 빌드 가능>
[parameter] progresses 리스트, 각 speeds 리스트
[return] 하루에 빌드되는 기능 개수 리스트

[풀이방법]
전부 speeds 만큼 더함

100이 넘은 첫번째 기능과 속도를 삭제
100보다 작은 기능을 만날때까지 반복
빌드 개수 + 1

반복하다가 기능리스트가 빈리스트가 되면 빌드 리스트 반환
'''
def solution(progresses, speeds):
    answer = []
    build_count = 0
    
    while progresses:
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