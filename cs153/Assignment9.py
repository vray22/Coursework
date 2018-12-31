#Assignment 9
#Victor Lozoya
#will create different classes with their own methods

#Question one
#will take a string as input from user and print it in caps 
class printGet:
    def __init__(self):
        self.string = ''
    def get_String(self):
        self.string = input("Enter string: ")
    def print_String(self):
        print(self.string.upper())




s = printGet()
s.get_String()
print("Question one: ")
s.print_String()

#Questoin two
#create car object class with three methods
#initialize attributes
#method to getprice as user input
#method to print all info 
class Car(object):
    
    def __init__(self, w, mil, mak, mod, yr, soldOn) :
        self.wheels = w
        self.miles = mil
        self.make = mak
        self.model = mod
        self.year = yr
        self.sold_on = soldOn
    def get_Price(self):
        self.price = input("Enter price of car: ")
    def print_Info(self):
        print("Number of wheels: " + str (self.wheels))
        print("Number of miles: " + str (self.miles))
        print("Make of car: " + self.make)
        print("Model of car: " + self.model)
        print("Year manufactured: " + str (self.year))
        print("Sold on: " + self.sold_on)
        print("Price: $" + self.price)
        

print("Question two: ")
car1 = Car(4, 0, 'ford', 'mustang', 2018, '4/10/2018')
car1.get_Price()
car1.print_Info()


#Question three
#create class circle with one param r which is radius
#two methods to computer area and perimeter 
class Circle(object):
    
    
    def __init__(self, r):
        self.radius = r
        
    def computeArea(self):
        return 3.14 * (self.radius * self.radius)
    def computePer(self):
        return 2 * 3.14 * self.radius
  
circle1 = Circle(4)
print("Question 3: ")
print("Area: " + str (circle1.computeArea()))
print("Perimeter: " + str (circle1.computePer()))
