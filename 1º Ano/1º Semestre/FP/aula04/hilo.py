# Complete the code to make the HiLo game.

import random


def playHiLo():
    # Pick a random number between 1 and 100, inclusive
    secret = random.randrange(1, 101)

    print("I picked a number between 1 and 100. Can you guess it?")
    # put your code here
    while guess != "Right":
       guess(secret)

def guess(secret):
    guess = float(input("Guess: "))
    if secret > guess:
      result = ("Higher")
      print(result)
    elif secret < guess:
      result = ("Lower")
      print(result)
    else:
      result = ("Right")
      print(result)
      exit(1)
    return(result) 


playHiLo()
