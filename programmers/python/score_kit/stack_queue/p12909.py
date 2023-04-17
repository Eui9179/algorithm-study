def solution(s):
    zero_line = 0

    if s[0] == ')' or s[-1] == '(':
        return False

    for bracket in s:
        if bracket == '(':
            zero_line += 1
        else:
            zero_line -= 1

        if zero_line < 0:
            return False

    if zero_line > 0:
        return False

    return True