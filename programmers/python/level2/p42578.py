# 위장

from itertools import combinations
'''
itertools.combinations: 
    n개 중 m개를 제너레이터 타입으로 리턴(list함수로 변환)
'''
def solution(clothes):
    answer = 0
    
    # dict_c: 옷 개수를 map으로 만듬
    dict_c = {c[1] : 0 for c in clothes}
    
    # 종류 30개일때 최대값
    if len(dict_c) == 30:
        return 1073741823;
    
    # 각 key에 옷 개수 저장
    for c in clothes:
        dict_c[c[1]]+=1
        
    # 옷 종류(key)
    dic_keys = list(dict_c.keys())
    
    # 한가지만 입을 때 개수
    answer = sum(list(dict_c.values()))
    
    # 두개 이상 옷을 입을 때 조합 개수
    for i in range(1, len(dic_keys)):
        
        # dic_keys 리스트에서 i+1만큼 조합을 만듬(1~개부터 최대 len(dic_keys)까지)
        selected_list = list(combinations(dic_keys, i+1)) 
        
        for selected in selected_list:
            tmp = 1
            for s in selected:
                tmp *= dict_c[s] # 각 자리에 들어갈 수 있는 개수
            answer += tmp
    return answer

print(solution([["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]))