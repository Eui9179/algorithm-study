# 올바른 괄호

'''
<괄호 짝이 맞는지 물어보는 문제>
[parameter] 괄호로 이루어진 문자열
[return] 짝이 맞으면 True, 맞지 않으면 False

[풀이방법]
balance를 0으로 두고 
'('를 만나면 + 1 
')'를 만나면 -1

결과가 0이면 True
다른 값이면 False
'''

def solution(s):
    if s[0] == ')' or s[-1] == '(':
        return False
    
    balance = 0
    
    for bracket in s:
        if bracket == '(':
            balance += 1
        else:
            balance -= 1
            if balance < 0:
                return False
            
    if balance == 0:
        return True
    
    return False

print(solution('()))((()'))