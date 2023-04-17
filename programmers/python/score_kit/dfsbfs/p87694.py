def solution(rectangle, characterX, characterY, itemX, itemY):
    answer = 0

    height = -1
    width = -1

    for rec in rectangle:
        height = max(height, rec[3])
        width = max(width, rec[2])

    map = []

    for i in range(height + 1):
        map.append([0] * (width + 1))


    print_map(map)


    return answer

def print_map(map):
    for m in map:
        print(m)

a = [1,2,3,4]
solution([[1, 1, 7, 4], [3, 2, 5, 5], [4, 3, 6, 9], [2, 6, 8, 8]], 1, 3, 7, 8)
