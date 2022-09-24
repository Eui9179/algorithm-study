def solution(k, a:list, b:list):
    
    a.sort()
    b.sort(reverse=True)
    
    for i in range(k):
        if a[i] < b[i]:
            a[i], b[i] = b[i], a[i]
        else:
            break
    
    return sum(a)
        
print(solution(3, [1,2,5,4,3],[5,5,6,6,5]))
