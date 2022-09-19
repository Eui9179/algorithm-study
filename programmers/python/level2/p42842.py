# 카펫
'''
<네모난 카펫이 있고 안은 노란색, 바깥 타일은 갈색으로 채워야 할 때, 가로 세로 길이>
[parameter] 갈색 타일 개수, 노란색 타일 개수
[return] 카펫의 가로 세로 길이

[풀이방법]
사각형을 만들 수 있는 가로길이 타일과 세로길이를 모두 구한다.
둘레 타일의 개수(갈색타일의 개수) == (2 * (w + h - 2)) + 8
[가로 + 2, 세로 + 2] 반환 (모서리개수 2)
'''

def solution(brown, yellow):
    answer = []
    if yellow == 1:
        return [3, 3]
    
    for w in range(yellow, 0, -1):
        if yellow % w == 0:
            h = yellow / w
            if (2*(w + h -2) + 8) == brown:
                return [w + 2, int(h) + 2]
        
    return answer

print(solution(24,24))