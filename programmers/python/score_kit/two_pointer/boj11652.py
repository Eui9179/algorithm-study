n = int(input())
cards = []
for _ in range(n):
    cards.append(int(input()))

cards.sort()

right = 0
count = 0

for left in range(n):
    while right < n and cards[right] == cards[left]:
        right += 1

    if right - left > count:
        answer = cards[left]
        count = right - left
        left = right

print(answer)
