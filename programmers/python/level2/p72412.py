def search(score, scores):
    result = len(scores)

    left = 0
    right = result - 1

    while left <= right:
        mid = (left + right) // 2
        if scores[mid] < score:
            left = mid + 1
        else:
            right = mid - 1
            result = mid

    return result


def init_data(info):
    data = {}

    for i in info:
        i_split = i.split(" ")
        score = int(i_split[-1])

        lang_i = ["-", i_split[0]]
        job_i = ["-", i_split[1]]
        career_i = ["-", i_split[2]]
        food_i = ["-", i_split[3]]

        for li in lang_i:
            for ji in job_i:
                for ci in career_i:
                    for fi in food_i:
                        key = li + " " + ji + " " + ci + " " + fi
                        if key not in data:
                            data[key] = [score]
                        else:
                            data[key].append(score)
    for key in data.keys():
        data[key].sort()
    return data


def solution(info, query):
    answer = []

    data = init_data(info)
    for i in range(len(query)):
        q_split = query[i].split(" ")
        q_score = int(q_split[7])

        key = q_split[0] + " " + q_split[2] + " " + q_split[4] + " " + q_split[6]

        if key in data:
            scores = data[key]
            answer.append(len(scores) - search(q_score, scores))
        else:
            answer.append(0)

    return answer
