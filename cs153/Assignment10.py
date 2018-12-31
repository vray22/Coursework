#Victor lozoya
#HW10
#will read from file using python functions
#will also create my own function to read file using open()

import csv


#Question 1

examplefile = open('/Users/Victor/Documents/pythonpractice/unemployment-1.csv')
exampleReader = csv.reader(examplefile, delimiter=' ', quotechar='|')
for row in exampleReader:
    print(','.join(row))

x = exampleReader.line_num
print("line count: " , x)


#Question 2
def file_read(filename):
    file_object = open(filename, 'w')
    print(file_object)



file_read('gradedDiscussion2')

