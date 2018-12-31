#Assignment 7
#Victor Lozoya
#3/20/17
#Working with strings

from string import*

#Question one

def find_key(target, key):
    x = 0
    answer = key in target
    #use while loop to go through string using in function 
    while answer:
        if target.find(key) != -1:
            num = target.find(key)
            x += 1#increment count 
            target = target[num+1:]#create new string starting after first occurance 
            answer = key in target #use in function to see if loop continues
        
            

    return x

target = "PythonPy"
key = "Py"
print(find_key(target, key))


#Question two
look = "Look at me!"
now = "NOW"

(look[:4]) #value is: Look
(look[-1])#value is: !
(look*2)#value is: Look at me!Look at me!
(look[:-1] + now + look[-1])#value is: Look at meNOW!
(now[1])#value is: O
(now[:4])#value is: NOW
(look*2+look[:-1]+now+look[-1])#value is: Look at me!Look at me!Look at meNOW!


