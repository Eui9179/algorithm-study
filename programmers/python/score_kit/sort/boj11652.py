nums = []

n = int(input())

for _ in range(n):
    nums.append(int(input()))

nums.sort()

cur_mode = 1
mode = 0
answer = 0

for i in range(1, len(nums)):
    if nums[i] != nums[i - 1]:
        cur_mode = 1
    else:
        cur_mode += 1

    if cur_mode > mode:
        answer = nums[i]
        mode = cur_mode

print(answer)