def solution(genres, plays):
    answer = []
    play_list = {}
    plays_index = []

    for i in range(len(plays)):
        plays_index.append((plays[i], i))

    for i in range(len(plays)):
        if genres[i] in play_list:
            play_list[genres[i]].append(plays_index[i])
        else:
            play_list[genres[i]] = [plays_index[i]]

    genres_index = []
    for key in play_list.keys():
        s = sum_data(play_list[key])
        play_list[key].sort(reverse=True, key=lambda x: (x[0], -x[1]))
        genres_index.append((s, key))
    genres_index.sort(reverse=True)

    for g in genres_index:
        tmp = play_list[g[1]]
        answer.append(tmp[0][1])
        if len(tmp) > 1:
            answer.append(tmp[1][1])
    return answer

def sum_data(arr):
    result = 0
    for a in arr:
        result += a[0]
    return result

