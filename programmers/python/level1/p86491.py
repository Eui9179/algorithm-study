# 최소 직사각형

def solution(sizes):
    w = 0
    h = 0
    
    for size in sizes:
        max_w = max(size)
        min_h = min(size)
        
        w = max(w, max_w)
        h = max(h, min_h)
        
    return w * h
    # return max_w * min_h

solution([[60, 50], [30, 70], [60, 30], [80, 40]])

