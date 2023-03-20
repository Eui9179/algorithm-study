def solution(array, commands):
    answer = []
    for comm in commands:
        answer.append(sorted(array[comm[0] - 1: comm[1]])[comm[2] - 1])
    return answer

solution([1, 5, 2, 6, 3, 7, 4], [[2, 5, 3], [4, 4, 1], [1, 7, 3]])