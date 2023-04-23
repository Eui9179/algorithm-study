n = int(input())
strings = input()

answer = 0

m = len(strings)
slot = set()

alpha = {}
alphabets = set(strings)
for al in alphabets:
    alpha[al] = 0

right = 0

for left in range(m):
    while right < m and (len(slot) < n or strings[right] in slot):
        alpha[strings[right]] += 1
        slot.add(strings[right])
        right += 1

    answer = max(answer, right - left)

    if alpha[strings[left]] > 0:
        alpha[strings[left]] -= 1
        if alpha[strings[left]] == 0:
            slot.remove(strings[left])

print(answer)