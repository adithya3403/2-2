'''
Input: num = 58, k = 9
Output: 2
Explanation:
One valid set is [9,49], as the sum is 58 and each integer has a units digit of 9.
Another valid set is [19,39].
It can be shown that 2 is the minimum possible size of a valid set.
'''

num = 37
k = 2


# class Solution:
#     def minimumNumbers(self, num: int, k: int) -> int:
l = [i for i in range(1, num + 1)]
l2 = []
for i in l:
    i = str(i)
    if int(i[-1]) == k:
        l2.append(i)
count = 0
# print(l2)
if len(l2) == 0:
    count = -1
else:
    for i in range(int(len(l2) / 2)):
        if int(l2[i]) + int(l2[-i - 1]) == num:
            count += 1
print(count)