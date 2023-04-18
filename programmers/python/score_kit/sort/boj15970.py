def to_left(colors, idx):
    if idx == 0:
        return int(1e9)
    return colors[idx] - colors[idx - 1]


def to_right(colors, idx):
    if idx == len(colors) - 1:
        return int(1e9)
    return colors[idx + 1] - colors[idx]


points = {}
answer = 0

# --입력--
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
        cur_length += min(to_left(colors, i), to_right(colors, i))

    answer += cur_length

print(answer)
