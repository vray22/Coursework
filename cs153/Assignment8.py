#Assignment 8
#Victor Lozoya
#April 9, 2017

#Question one
print("Question 1: ") 
d = {1: 10,2: 20,3: 30,4: 40,5: 50, 6: 60}

def is_key_present(n):
    if n in d:
        return "Key is present in dictionary "
    else:
        return "Key is not present in dictionary "
#test if 5 and 9 is present in dictionary
print("This is the dictionary: " + str (d))
print("Key 5: " + str (is_key_present(5)))
print("Key 9: " + str (is_key_present(9)))


#Question two
print("Question 2: ")
nums = [10, 22, 52, 80]
#function that accepts any list of numbers and finds sum
def findSum(n):
    answer = 0; 
    for i in range(len(n)):
        answer += n[i]
    return answer
print("This is the list: " + str (nums)) 
print("Sum: " + str (findSum(nums)))

#Question three
print("Question 3: ")
#create two list 
list1 = [1, 2, 3, 0]
list2 = ['Red', 'Green', 'Black']
#function to append first list to second list 
def appendList(list1, list2):
    finalList = list2 + list1
    return finalList
print("First list: " + str (list1))
print("Second list: " + str (list2)) 
print("Final list: " + str (appendList(list1, list2))) 

#Question four
print("Question 4: ")
setx = set([5, 10, 3, 15, 2, 20])
#use built in functions min and max to find in set passed in as paramater 
def findMaxMin(set1):
    maxNum = max(set1)
    minNum = min(set1)
    return "Max is " + str (maxNum) + " min is " + str (minNum)
print("This is the set: " + str (setx))
print(findMaxMin(setx))
