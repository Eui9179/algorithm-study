noto = {}

for i in range(3):
    try:
        noto['a'] += 'bc'
    except:
        noto['a'] = 'a'
    
print(noto)