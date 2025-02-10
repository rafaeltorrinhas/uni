def hollowPyramid(n):
    return 1 if n == 1 else 4*(n-1) + hollowPyramid(n-1)


def permutacoes_recursivas(string):
    if len(string) == 1:
        return {string}
    perm = set()
    for i in range(len(string)):
        for p in permutacoes_recursivas(string[:i] + string[i+1:]):
            perm.add(string[i] + p)
    return perm


print(permutacoes_recursivas("abc"))
