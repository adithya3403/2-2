'''
Amit's mother given him 500 Rs. and tell him to purchase goods like soap, shampoo, oil, sugar and salt. Amit completes his shopping in a supermarket. If bill is less than 500 then he will pay. But if finds that bill is crossing 500, then he decides to remove items from the list.

Sample Output:

Enter name and price of the goods purchased('s' to stop):
enter item name
rice
enter price
200
enter item name
oil
enter price
300
enter item name
shampoo
enter price
400
enter item name
s
Bill generated is as follows:
rice 200
oil 300
shampoo 400
Total Bill is Rs.900
Total Bill 900 is more than 500, enter name of an item to remove from list
shamp
enter item shamp is not in the list
Total Bill 900 is more than 500, enter name of an item to remove from list
shampoo
shampoo is removed from the bill
Congratulations:
you final bill:
item	price
rice	200
oil	300
Bill amount is Rs.500
'''


print("Enter name and price of the goods purchased('s' to stop):")
total=0
items=[]
prices=[]
while True:
    item=input("enter item name:")
    if item=='s':
        break
    price=int(input("enter price:"))
    total+=price
    items.append(item)
    prices.append(price)
print('Bill generated is as follows:')
for i in range(len(items)):
    print(items[i], prices[i])
print(f'Total Bill is Rs.{total}')
while total>500:
    print(f"Total Bill {total} is more than 500, enter name of an item to remove from list")
    item=input()
    flag=0
    for i in range(len(items)):
        if item==items[i]:
            print(f'{item} is removed from the bill')
            total-=prices[i]
            items.pop(i)
            prices.pop(i)
            flag=1
            break
    if flag==0:
        print(f"enter item {item} is not in the list")
if flag==1:
    print("Congratulations:")
    print("you final bill:")
    print("item\tprice")
    for i in range(len(items)):
        print(f'{items[i]}\t{prices[i]}')
print(f'Bill amount is Rs.{total}')