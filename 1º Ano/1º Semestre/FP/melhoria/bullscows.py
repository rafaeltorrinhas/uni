
def score(guess, secret):
    assert len(guess) == len(secret)

    n = len(guess)
    bulls = []
    cows = []
    idxs = []
    idxsc = []
    for i in range(n):
        if guess[i] == secret[i]:
            bulls.append(guess[i])
            idxs.append(i)

    for i in range(n):
        if i in idxs:
            continue
        for j in range(n):
            if j in idxs or j in idxsc:
                continue
            if guess[i] == secret[j]:
                cows.append(guess[i])
                idxsc.append(j)
                break

    return str(len(bulls))+"A"+str(len(cows))+"B"


print(score('0111', '1123'))
print(score('1234', '1235'))
print(score('1004', '4001'))
