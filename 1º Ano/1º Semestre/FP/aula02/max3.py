# coding: utf-8
# This program finds the maximum of two numbers.
# It uses the built-in max function.
# Can you do it with a conditional statement (if / if-else) instead?

x1 = float(input("number? "))
x2 = float(input("number? "))
x3 = float(input("number? "))
x4 = float(input("number? "))

# Use a conditional statement instead of max function!

# mx = max(x1, x2)
# print("Maximum:", mx)

if x1 > (x2 and x3 and x4):
    print("Maximum: ", x1)
elif x2 > (x1 and x3 and x4): print("Maximum: ", x2)
elif x3 > (x1 and x2 and x4): print("Maximum: ", x3)
else: print("Maximum:", x4)



