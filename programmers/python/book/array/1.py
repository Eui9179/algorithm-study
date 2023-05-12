def solution(line):
    point_x = []
    point_y = []
    n = len(line)

    for i in range(n - 1):
        A = line[i][0]
        B = line[i][1]
        E = line[i][2]

        for j in range(i + 1, n):
            C = line[j][0]
            D = line[j][1]
            F = line[j][2]

            if ((A * D) - (B * C)) == 0:
                continue

            x = ((B * F) - (E * D)) / ((A * D) - (B * C))
            y = ((E * C) - (A * F)) / ((A * D) - (B * C))

            if x > int(x) or y > int(y) or x < int(x) or y < int(y):
                continue

            point_x.append(int(x))
            point_y.append(int(y))

    max_x = max(point_x)
    min_x = min(point_x)
    max_y = max(point_y)
    min_y = min(point_y)

    width = abs(max_x - min_x)
    height = abs(max_y - min_y)

    star = ["." * (width + 1) for _ in range(height + 1)]

    for i in range(len(point_x)):
        point_x[i] += abs(min_x)
        point_y[i] -= abs(max_y)

        s = star[abs(point_y[i])]
        star[abs(point_y[i])] = s[:point_x[i]] + "*" + s[point_x[i] + 1:]

    return star


solution([[2, -1, 4], [-2, -1, 4], [0, -1, 1], [5, -8, -12], [5, 8, 12]])