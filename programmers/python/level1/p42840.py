# 모의고사

def solution(answers):
    answer = []
    
    a_list = [1, 2, 3, 4, 5]
    b_list = [2, 1, 2, 3, 2, 4, 2, 5]
    c_list = [3, 3, 1, 1, 2, 2, 4 ,4 ,5, 5] 
    
    count = [0, 0, 0]
    index = [0, 0, 0]
    
    for i in range(len(answers)):
        if answers[i] == a_list[index[0]]:
            count[0] += 1 
        
        if answers[i] == b_list[index[1]]:
            count[1] += 1
            
        if answers[i] == c_list[index[2]]:
            count[2] += 1
        
        index[0] += 1
        index[1] += 1
        index[2] += 1
        
        if index[0] == len(a_list):
            index[0] = 0
        if index[1] == len(b_list):
            index[1] = 0
        if index[2] == len(c_list):
            index[2] = 0
    
    max_count = max(count)
    
    if count[0] == max_count:
        answer.append(1)
    if count[1] == max_count:
        answer.append(2)
    if count[2] == max_count:
        answer.append(3)
    
    return answer

solution([1,2,3,4,5,12,3,4,1,2,4,2,3,4,2,1,2,3,4,1,2,3,4,1,4,5,5,3,4,1,2,3,4,5,1,3,4,5])