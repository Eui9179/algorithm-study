def solution(word):
    answer = 1

    cur_word = ['A']
    next_words = {
        'A': 'E',
        'E': 'I',
        'I': 'O',
        'O': 'U',
        'U': ''
    }

    while ''.join(cur_word) != word:
        answer += 1
        print(cur_word)
        cur_word_len = len(cur_word)

        if cur_word_len == 5:
            while cur_word[-1] == 'U':
                cur_word.pop(-1)
            cur_word.append(next_words[cur_word.pop(-1)])

        else:
            cur_word.append('A')

    return answer


print(solution("I"))