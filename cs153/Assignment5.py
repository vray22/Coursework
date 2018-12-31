#Name: Victor Lozoya

#Date: 3/3/17

# Assignment5.py

#Question one
print("Question 1: \n")
condition = 1
while condition < 10:
    print(condition)
    condition += 1
#This code sets codition equal to one
#while condition is less than 10 then the condition will be printed
#Condition is incremented by one each iteration


#Question two
#will print every students name in student list using for loop 
print("Question 2: \n")
studentList = ['Vic', 'Mel', 'Al', 'Frank', 'Tom', 'John', 'Steve', 'Hec', 'Jesse',
               'Jasmine', 'Amparo', 'Greg', 'Alex', 'Aria', 'Olga']
for y in studentList:
    print(y)


#Question three
#will print multiplication table using user input and a while loop 
print("Question 3: \n")
size = input("Enter a number")
count = 1
while count <= 10:
   sum = int (size) * count
   print(size + ' x ' + str (count) + ' = ' + str (sum))
   count += 1

#Question four
#will print pattern of numbers 1 through 9 each value printed as much as its value
#using a nested for loop 
print("Question 4: \n")
num = 1
for i in range(1, 10):
    for y in range(num):
        print(str (i), end="")
    num += 1
    print()
    
    



