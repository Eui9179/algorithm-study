spec_char = '~!@#$%^&*()=+[{]}:?,<>/'

def solution(new_id): 
    # 1
    new_id = new_id.lower()
    
    # 2
    new_id = except_spec_char(new_id)
    
    # 3
    while '..' in new_id:
        new_id = new_id.replace('..', '.')
    
    # 4
    new_id = remove_dot(new_id)
    
    # 5
    if not new_id:
        new_id += 'a'
    
    # 6
    if len(new_id) > 15:
        new_id = new_id[:15]
        if new_id[-1] == '.':
            new_id = new_id[:-1]
            
    # 7
    if len(new_id) < 3:
        while len(new_id) < 3:
            new_id += new_id[-1]
    return new_id

def remove_dot(string:str):
    if string == '.' or not string:
        return ''
    if string[0] == '.':
        string = string[1:]
    if string[-1] == '.':
        string = string[:-1]
    return string
    

def except_spec_char(string):
    new_string = ''
    
    for s in string:
        if not s in spec_char:
            new_string += s
    return new_string

#"...!@BaT#*..y.abcdefghijklm"	"bat.y.abcdefghi"
#"z-+.^."	"z--"
#"=.="	"aaa"
#"123_.defv"	"123_.def"

print(solution("z-+.^."))