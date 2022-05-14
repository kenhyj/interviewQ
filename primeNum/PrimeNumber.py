import math;

def primeNumber(number):
    """ int -> boolean 
    """
    if number < 1 :
        raise Exception("Please use a positive number")
    if number == 1 :
        raise Exception("1 is divisible by only one but its quotient is one. Prime numbers are only divisible by one and its quotients are not one.")
    if number == 2:
        return True # is the only number that is a prime number.
    if number % 2 == 0 :
        return False
    for x in range (0, math.sqrt(number), 2) :
        if number % x == 0:
            return False

    return True


# def main():


# primeNumber

# todo support input using args[]

# to run 
# python3 primeNumber PRIME_NUMBER