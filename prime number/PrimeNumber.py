import math

def isPrimeNumber(number : int) -> bool:
    if number <= 1:
        return False

    for i in range(2, int(math.sqrt(number)) + 1):
        if number % i == 0:
            return False

    return True

for i in range(1, 10):
    if isPrimeNumber(i):
        print(i)
