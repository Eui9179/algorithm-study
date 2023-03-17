def solution(s:str):
    result = []    
    splited = s.split(" ")
    
    for sp in splited:
        string_list = list(sp)
        for i in range(len(string_list)):
            if i == 0 or i % 2 == 0:
                string_list[i] = string_list[i].upper()
            else:
                string_list[i] = string_list[i].lower()
        result.append(''.join(string_list))
        
    return ' '.join(result)