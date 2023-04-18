points = {}
answer = 0

n = int(input())
for _ in range(n):
    p, c = map(int, input().split())
    if c in points.keys():
        points[c].append(p)
    else:
        points[c] = [p]

for key in points.keys():
    cur_length = 0
    points[key].sort()
    colors = points[key]
    for i in range(len(colors)):
        if i == 0:
            cur_length += (colors[i + 1] - colors[i])
        elif i == len(colors) - 1:
            cur_length += (colors[i] - colors[i - 1])
        else:
            cur_length += min((colors[i + 1] - colors[i]), (colors[i] - colors[i - 1]))

    answer += cur_length

print(answer)



