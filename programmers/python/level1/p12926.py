def solution(s, n):
    answer = ''
    s_list = list(s)
    z_ord = ord('z') - ord('a') + 1
    Z_ord = ord('Z') - ord('A') + 1
    
    for i in range(len(s_list)):
        if (s_list[i] == ' '):
            answer += ' '
        else:
            if ord(s_list[i]) + n > ord('z'):
                answer += chr(ord(s_list[i]) + n - z_ord)
            elif ord(s_list[i]) + n > ord('Z') and ord(s_list[i]) < ord('a'):
                answer += chr(ord(s_list[i]) + n - Z_ord)
            else:
                answer += chr(ord(s_list[i]) + n)
    return answer
    
print(solution("a B z", 4))