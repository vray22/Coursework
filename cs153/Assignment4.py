#Name: Victor Lozoya

#Date: 2/25/17

#Assignment4.py

#Question one
print('question one\n')
x = 25
y = 30

if x > y:
    print('x is greater than y')

#Question two
print('question two')
if x < y:
    print('x is less than y\n')

#Question three
print('question three')
x = 15
y = 25

if x > 10:
    print('x is greater than 10')
else:
    print('x is less than 10')
#Part two to question three
print('part two question two')
x = 15
y = 25

if x < 10:
    print('x is less than 10')
else:
    print('x is greater than 10')
#Part three to question three using elif
print('part three question three')
x = 20
y = 25
z = 30
if x > y:
    print('x is greater than y')
elif x > z:
    print('x is greater than z')
else:
    print('if and elif never ran so x is not greater than y or z\n')

#Question four
print('Question 4 ')
userNum = input("Enter a number")
inputNum = int(userNum)
if not(inputNum % 2 == 0):
    print('The number is odd\n')
else:
    print('The number is even\n')

#Question five
print('Question 5')
y = input("Input a letter of the alphabet:")
if y in('a', 'e', 'i', 'o', 'u'):
    print('This letter is a vowel')
else:
    print('This letter is a constant')
