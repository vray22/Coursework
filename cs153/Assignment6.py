#Assignment
#Date: 3/9/17
#Assignment6.py
#Victor Lozoya 

import math

#Question one
#create a function to calculate the x using quadratic formula

def quad(a, b, c):
    d = b**2 -(4*a*c)
    if d == 0:
        return "Error a can't be zero"
    if d < 0:
        return "Roots are complex"

    posNum = str((-b + math.sqrt(d)) / (2*a))
    negNum = str((-b - math.sqrt(d)) / (2*a))
    return "Answer is " + posNum + " or " + negNum


#Question one part b
#create function to calculate x using quadratic formula
#excepts complex roots 

def quadCom(a, b, c):
    d = b**2 -(4*a*c)
    if d == 0:
        return "Error a can't be zero"

    posNum = str((-b + math.sqrt(d)) / (2*a))
    negNum = str((-b - math.sqrt(d)) / (2*a))
    return "Answer is " + posNum + " or " + negNum

print("Question one part a: ")
print(quad(1, 5, 3))

print("Question one part b: ")
print(quadCom(1, -2, -3))


#Question 2
#function to determine total using polynomail equation 
def evalPoly(x, cof):
    total = 0
    cof.reverse()
    for i in range(len(cof)):
        total += cof[i]*(x**i)
    return total
print("Question two: ")
print(evalPoly(1, [1, 2, 3]))


#Question three
#function to do sumation of s = 1/(1*2)+1/(2*3)+1/(3*4)...1/(98*99)+1/(99*100)
def sumation():
    s = 0
    i = 1
    k = 2
    for i in range(1, 100):
        s += 1 / (i*k)
        i+=1
        k+=1
    return s
print("Question three: ")
print(sumation())






    
