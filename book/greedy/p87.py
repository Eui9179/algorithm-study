# 거스름돈

def solution(money):
    count = 0
    
    coin_types = [500, 100, 50, 10]
    
    for coin in coin_types:
        if money > 0:
            coin_count = money//coin # //: 몫
            money = money - ( coin_count * coin)
            count += coin_count
            
    print(count)
        
solution(1260)