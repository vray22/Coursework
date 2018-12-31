#Victor Lozoya
#Feb 17, 2017
#Assignment3.py

#Answer to question one
#will print list named ages and its elements
print("Question1: ")
ages = [24, 22, 22, 22, 21]
print(ages)

#Answer to question two
#adds 25 to end of ages list
print("Question2: ")
ages.append(25)
print(ages)

#Answer to question three
#inserts value 18 and index 0 of ages list
print("Question3: ")
ages.insert(0,18)
print(ages)

#Answer to question 4
#removes first instance of 22 from ages list 
print("Question4: ")
ages.remove(22)
print(ages)

#Answer to question 5
#prints value at index five of ages list
#counts instances of 22 in list returns value
#counts instances of 28 returns 0
print("Question5: ")
print(ages[5])
print(ages.index(22))
print(ages.count(28))

#Answer to question 6
#sorts ages list and prints it 
print("Question6: ")
ages.sort()
print(ages)

#Answer to question 7
#create list of names of friends
print("Question7: ")
fnames = ['Greg', 'Alex', 'Flex', 'Cisco', 'Garvey']
#sort in ascending order 
fnames.sort()
print(fnames)
#sort in descending order 
fnames.reverse()
print(fnames)

#Answer to question 8
#create unchangable list called tubles
print("Question8: ")
def money():
    return 15, 3, 25
#assign values in tubles money to v, i, and c
v, i, c = money()
print(v,i, c)
print("New list ")
#create new list
#print grades followed by grades at index 0 and 3
grades = [98, 99, 100, 77, 88]
print(grades)
print(grades[0], grades[3])
