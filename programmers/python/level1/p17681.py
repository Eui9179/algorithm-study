def solution(n, arr1, arr2):
    answer = []
    
    for i in range(n):
        bin1_b = bin(arr1[i])
        bin2_b = bin(arr2[i])
        
        bin1_b = bin1_b.replace('0b', '')
        bin2_b = bin2_b.replace('0b', '')
        
        if len(bin1_b) < n:
            bin1_b = '0' * (n - len(bin1_b)) + bin1_b
        if len(bin2_b) < n:
            bin2_b = '0' * (n - len(bin2_b)) + bin2_b
            
        tmp = ''
        for j in range(n):
            if bin1_b[j] == '1' or bin2_b[j] == '1':
                tmp += '#'
            else:
                tmp += ' '
        answer.append(tmp)
     
    return answer

print(solution(5, [9, 20, 28, 18, 11], [30, 1, 21, 17, 28]))

