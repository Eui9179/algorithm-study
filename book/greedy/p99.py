# 1이 될 때까지

import math

def solution(n, k):
    return int(math.log(n, k)) + (n % k)

print(solution(18, 4))