all: lab9.y lab9.l ast.c symtable.c emitast.c
	yacc -d lab9.y
	lex lab9.l
	gcc ast.c symtable.c emitast.c lex.yy.c y.tab.c -o lab9 
