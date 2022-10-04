def solution(lottos, win_nums):
    count = 0
    zero_count = 0
    
    for l in lottos:
        if l == 0:
            zero_count += 1
        elif l in win_nums:
            count += 1
    
    good = 1 if (count == 0 and zero_count == 0) else count + zero_count
    bad = 1 if count == 0 else count
    
    return [7 - good, 7 - bad]

l, w = [0, 0, 0, 0, 0, 0], [38, 19, 20, 40, 15, 25]

print(solution(l, w))