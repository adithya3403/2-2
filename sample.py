'''
input : 
2
1 2 3
output:
(1, 2), (1, 3), (2, 3)
explanation:
input is 1 2 3
divide them into pairs of 2
1, 2
1, 3
2, 3
'''

n=int(input())
l=list(map(int,input().split()))
arr=[]
for i in range(0,len(l)-1):
    for j in range(i+1,len(l)):
        arr.append((l[i],l[j]))
# print(arr)

'''
if and of each pair is greater than or equal to or of each pair
print the count
'''

count=0
for i in range(0,len(arr)-1):
    for j in range(i+1,len(arr)):
        if arr[i][0]>=arr[i][1] and arr[j][0]>=arr[j][1]:
            count+=1
print(count)