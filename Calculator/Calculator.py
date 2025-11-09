def sum(a: float, b: float) -> float:
    return a + b

def sub(a: float, b: float) -> float:
    return a - b

def mul(a: float, b: float) -> float:
    return a * b

def div(a: float, b: float) -> float:
    if b == 0:
        raise ZeroDivisionError("Can't divide by zero")
    return a / b

print("Hello! Calculator is running!")

while True:
    try:
        operation = input("Enter operation (+, -, *, /, (q to quit)): ")

        if operation == "q":
            break

        a = float(input("Enter first number: "))
        b = float(input("Enter second number: "))

        if operation == "+":
            print("Result: ", sum(a, b))
        elif operation == "-":
            print("Result: ", sub(a, b))
        elif operation == "*":
            print("Result: ", mul(a, b))
        elif operation == "/":
            print("Result: ", div(a, b))
        else:
            print("Invalid operation")
    except ValueError:
        print("Invalid input")
    except ZeroDivisionError as e:
        print(e)
