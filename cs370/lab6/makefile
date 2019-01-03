all: lab6.y lab6.l ast.c
	yacc -d lab6.y
	lex lab6.l
	gcc ast.c lex.yy.c y.tab.c -o lab6 
	./lab6 # < lab6test.c 
