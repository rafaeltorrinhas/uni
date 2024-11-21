
def intersection(a, b, c, d):
    #"Return the intersection of intervals [a, b[ and [c, d[.
    assert a <= b
    assert c <= d

    if  a <= c < b:
        e = c
    else:
        e = a
 
    if c < b < d:
        f = b
    else:
        f = d

    if c >= b or d <= a:
        e = 0
        f = 0
       

    return (e, f)


def testIntersection(a, b, c, d, x, y):
    #Call intersection, print result and check against expected result
    print(f"intersection({a}, {b}, {c}, {d})", end=" ")
    (e, f) = intersection(a, b, c, d)
    if (e, f) == (x, y):
        check = "OK"
    else:
        check = "FAIL"
    print(f"--> ({e}, {f})", check)



def main():
    testIntersection(1, 6, 4, 8,  4, 6)
    testIntersection(1, 6, 3, 5,  3, 5)
    # Acrescente mais casos de teste...
    testIntersection(3, 6, 7, 12, 0, 0)
    testIntersection(-3, 6, 0, 7, 0, 6)
    testIntersection(2, 4, 1, 8, 2, 4)


if __name__ == '__main__':
    main()

