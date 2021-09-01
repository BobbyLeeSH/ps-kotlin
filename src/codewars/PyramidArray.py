def pyramid(n):
    ret = []
    for i in range(n):
        temp = []
        for j in range(i + 1):
            temp.append(1)
        ret.append(temp)
    return ret