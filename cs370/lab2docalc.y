%{

/*
 *			**** CALC ****
 *
 * This routine will function like a desk calculator
 * There are 26 integer registers, named 'a' thru 'z'
 *
 */

/* This calc will incorporate the sym table structure to store variables identified by 
lex. It won't allow duplicates and will assign a particular address allows for variables with long names to be declared
also allows variables to be used as expressions.  
*/


	/* begin specs */
#include <stdio.h>
#include <ctype.h>
#include "lex.yy.c"
#include "symtable.c" 
//#include "lab4goodtest.c"


int STACKP = 0;//help keep track of variables 
int MAXSTACK = 26; 

int regs[26];
int base, debugsw;

void yyerror (s)  /* Called by yyparse on error */
     char *s;
{
  printf ("%s\n", s);
}


%}
/*  defines the start symbol, what values come back from LEX and how the operators are associated  */

%start p
//allow type to be value or string 
%union {
	int value; 
	char *string; 
}


//%start list

%token <value> INTEGER
%token <string> VARIABLE
%token INT
%type <value> expr stat 

%left '|'
%left '&'
%left '+' '-'
%left '*' '/' '%'
%left UMINUS


%%	/* end specs, begin rules */

p	:	decls list
	; 

decls	:	/*empty */
	| 	dec decls
	;

dec	:	INT VARIABLE
		{

			if(Search($2))
			{//present in symboltable
				fprintf(stderr, "Error line: Symbol %s already defined \n", $2); 
			}
			else 
			{//not present check if we reached max size
				if(STACKP >= MAXSTACK)
				{fprintf(stderr, "ERROR line no more register space \n");
				}
				else
				{ Insert($2, VARIABLE);
			  	  STACKP++;
				}
			}
		}
	';' '\n'




list	:	/* empty */
	|	list stat '\n'
	|	list error '\n'
			{ yyerrok; }
	;


stat	:	expr
			{ fprintf(stderr,"the anwser is %d\n", $1); }
	|	VARIABLE '=' expr
		    { regs[FetchAddr($1)] = $3; }
	;

expr	:	'(' expr ')'
			{ $$ = $2; }
	|	expr '-' expr
			{ $$ = $1 - $3; }
	|	expr '+' expr
			{ $$ = $1 + $3; }
	|	expr '/' expr
			{ $$ = $1 / $3; }
	|	expr '*' expr
			{ $$ = $1 * $3; }//added multiplication rule similiar as division 
	|	expr '%' expr
			{ $$ = $1 % $3; }
	|	expr '&' expr
			{ $$ = $1 & $3; }
	|	expr '|' expr
			{ $$ = $1 | $3; }
	|	'-' expr	%prec UMINUS
			{ $$ = -$2; }//here i just deleted the extra expression 
	|	VARIABLE
			{ 

			if(Search($1)){
				$$ = regs[FetchAddr($1)]; fprintf(stderr,"found a variable value addr = %s\n", $1); 
			}
			else{
				$$ = 0;
				fprintf(stderr, "Undefined variable %s\n", $1);  
			}
		}
	|	INTEGER {$$=$1; fprintf(stderr,"found an integer\n");}
	;



%%	/* end of rules, start of program */

main()
{ yyparse();
}
