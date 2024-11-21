
price = {"olive": 2.15,"pineapple": 0.85,"pear": 1.49,"orange": 1.25}
print(len(price))

item = "pear"
if item in price:
    p = str(price[item]) + "EUR"
else:
    p = "NA"
    
print(item + ":" + p)

price["oliveoil"] = 3.59

item = "olive"
p = ""
for f in sorted(price.keys()):
    if item in f:
        p += "<{}:{}EUR>".format(f,price[f])
        
print(p)

item="oil"
p = price.get(item, "NA")
print("{}:{}".format(item,p))