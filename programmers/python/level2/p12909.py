# 올바른 괄호

def solution(s):
    if s[0] == ')' or s[-1] == '(':
        return False
    
    zero_line = 0
    
    for bracket in s:
        if bracket == '(':
            zero_line += 1
        else:
            zero_line -= 1
            if zero_line < 0:
                return False
            
    if zero_line == 0:
        return True
    
    return False

print(solution('()))((()'))