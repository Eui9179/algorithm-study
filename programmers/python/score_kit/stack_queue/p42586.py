def solution(progresses, speeds):
    answer = []

    while progresses:
        count = 0
        day = 1
        while progresses[0] + (speeds[0] * day) < 100:
            day += 1

        for i in range(len(progresses)):
            progresses[i] += (speeds[i] * day)

        while progresses and progresses[0] >= 100:
            progresses.pop(0)
            speeds.pop(0)
            count += 1

        if count > 0:
            answer.append(count)

    return answer