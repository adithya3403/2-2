# Given key and value pairs, 'key' is the name of the college and
# 'value' is the list of every-year placements done in last few years(in hundreds).

# Help the placement officer in finding the year of max placements done in colleges.
# (year start from zero)


# Input
# 3              ------> number of colleges
# kmit 5 3 6 2  //key=college-name, value=list of placements(in hundreds) every year.
# ngit 1 8 5 3    //
# kmec 9 1 3 5  //
# Expected output
# kmit 2   ----> in kmit max placements done in the year 2 (index of 6)
# ngit 1   ---> in ngit  max placements done in the year 1 (index of 8)
# kmec 0   ---> in kmec  max placements done in the year 0 (index of 9)
# ----------------
# Input
# 4
# ksjc 2 6 8 5 1 3 4
# ngit 4 9 7 6
# kmit 7 4 1 9 2
# kmec 5 3 2 1
# Expected output
# ksjc 2
# ngit 1
# kmit 3
# kmec 0


n = int(input())
l = []
for i in range(n):
    d = {}
    str = input().split()
    d["key"]=str[0]
    d["pl"]=str[1:]
    l.append(d)
print(*[i for i in l], sep='\n')