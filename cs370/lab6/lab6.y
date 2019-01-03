/*
Victor Lozoya
lab5
create yacc rules to determine what is syntax correct
create tokens to match with lex
allow for variable names, func declarations, assignment statements, etc 
added semantic action to create nodes and attach them in an AST. 
*/


%{
/* begin specs */
#include <stdio.h>
#include <ctype.h>
//#include "lex.yy.c"
#include "ast.h"

extern int count; 

void yyerror (s)  /* Called by yyparse on error */
     char *s;
{
  printf ("%s on line:%d \n", s, count);
}


%}

%start program

%union {
	int value; 
	char *string;
	ASTnode * node;  /* so we can build an AST */
      	enum OPERATORS operator; 
}
//added more nodes and operator type 
%token <string> ID
%token <value> NUM INT VOID IF ELSE WHILE FOR RETURN READ WRITE LE L GE G EQ NE
%type <node> program DL DEC VARDEC FUNDEC params paramlist param compoundstmt
%type <node> localdec statementlist statement exprstmt assistmt selectstmt iterstmt 
%type <node> returnstmt readstmt writestmt expression var simpleexpr additiveexpr  
%type <node> term factor call args arglist 
%type <operator> typespec relop addop multop 

%% /* end spec begin rules */

program		:	DL
			{program=$1;}
		;

DL		:	DEC { $$=$1;}
		|	 DEC DL {$1->next=$2; $$= $1; /*left connect declarations */
                       // if (mydebug)  ASTprint(0,$1);
                        //if (mydebug) ASTprint(0,$2);
                       }
		;

DEC		:	VARDEC {$$=$1;}  
		|	FUNDEC {$$=$1;} 
		;

VARDEC		:	typespec ID ';' {
				$$=ASTCreateNode(VARDEC);
				$$->name=$2;
			} 
		|	typespec ID '[' NUM ']' ';' {
				$$=ASTCreateNode(VARDEC); 
		                $$->name=$2; /* this changes to symbol table*/
		                $$->value=$4; /* remember dimension*/
		                printf("found an array declaration \n");
                  	}
		;

typespec	:	INT {$$=INTTYPE;}
		|	VOID{$$=VOIDTYPE;}
		;

FUNDEC		:	typespec ID '(' params ')' compoundstmt{
				$$=ASTCreateNode(FUNCTIONDEC);
				$$->operator=$1; 
                            	$$->name=$2; /* this changes to symbol table*/
				$$->left=$4;
                            	$$->right = $6; /* compound statement */
				
				
                        } 
		;

params		:	VOID {$$=NULL;}
		|	paramlist{$$=$1;}
		;

paramlist	:	param {$$=$1;}
		|	param ',' paramlist {$1->next=$3;
				$$=$1;
			}
		;

param		:	typespec ID {
				$$=ASTCreateNode(PARAM);
				$$->operator=$1;
				$$->name=$2;
			}
		|	typespec ID '['  ']'{
				$$=ASTCreateNode(PARAM);
				$$->operator=$1;
				$$->name=$2;
				$$->value=-1;
			}
		;

compoundstmt	:	'{' localdec statementlist '}'{  
				$$=ASTCreateNode(BLOCK);
                         	if ($2==NULL) /* no local declarations */
                                	$$->right=$3;
                        	else{ /* we had some declarations, put them together */
					$$->left=$2;                             		
					$$->right=$3;
					
					//ASTattachleft($2,$3);
                           	}
                       }
		;

localdec	:	/*empty*/{ $$=NULL;}
		| 	VARDEC localdec  {
				
					$1->next=$2; 
					$$=$1;
				}
			
		;

statementlist	:	/*empty*/{ $$=NULL;}
		|	statement statementlist{$$=$1; $1->next=$2; }//next is statementlist
		;

statement	:	exprstmt {$$=$1;} 
		|	compoundstmt {$$=$1;} 
		|	selectstmt {$$=$1;} 
		|	iterstmt {$$=$1;} 
		|	assistmt {$$=$1;} 
		|	returnstmt {$$=$1;} 
		|	readstmt {$$=$1;} 
		|	writestmt {$$=$1;} 
		;

exprstmt	:	expression ';' { $$=ASTCreateNode(EXPRSTMT);
                                  $$->right=$1;}
		|	';' { $$=NULL; }
		;

assistmt	:	var '=' exprstmt {$$=ASTCreateNode(ASSIGN);
                          /* Assignment statement  we leave left alone so that
                             it can be strung with other statements	*/ 
                              $$->right=$1;//right var
                              $$->s1=$3;//s1 exprstmt
                      }
		;

selectstmt	:	IF '(' expression ')' statement { $$=ASTCreateNode(IFSTMT);
                                                  $$->right=$3;
                                                  $$->s1=$5;
                                                  $$->s2=NULL;
                                                }
		|	IF '(' expression ')' statement ELSE statement { $$=ASTCreateNode(IFSTMT);
						  $$->right=$3;
						  $$->s1=$5;
						  $$->s2=$7;
						}
		;

iterstmt	:	WHILE '(' expression ')' statement {$$=ASTCreateNode(WHILESTMT);
						    $$->right=$3;
						    $$->s1=$5;
						   
				}
		;

returnstmt	:	RETURN ';' { $$=ASTCreateNode(RETURNSTMT); $$->right=NULL;}
		|	RETURN expression ';' { $$=ASTCreateNode(RETURNSTMT);
				            $$->right=$2;  
				}
		;

readstmt	:	READ var ';' { /* make sure variable is in symbol table */
                          /*  Create a ASTnode for this statement on the right */
                            $$=ASTCreateNode(READSTMT);
                          /* this will be pointer to symbol table */
                            $$->right=$2;
                        }
		;

writestmt	:	WRITE expression ';' { $$=ASTCreateNode(WRITESTMT);
					$$->right=$2;
			}
		;

expression	:	simpleexpr {$$=$1;}
		;

var		:	ID {$$=ASTCreateNode(IDENT);
			    $$->name=$1;
			}
		|	ID '[' expression ']'{$$=ASTCreateNode(IDENT);
					$$->name=$1;
					$$->right=$3;
                        }
		;

simpleexpr	:	additiveexpr {$$=$1;}
		|	simpleexpr relop additiveexpr{$$=ASTCreateNode(EXPR);
                        $$->left=$1;
			$$->operator=$2;
                        $$->right=$3;
                       }
		;

relop		: 	LE {$$=LESSTHANEQUAL;} 
		|       L  {$$=LESSTHAN;}
		|       G  {$$=GREATERTHAN;}
	        |       GE {$$=GREATERTHANEQUAL;}
		|       EQ {$$=EQUAL;}
                |       NE {$$=NOTEQUAL;} 
		;

additiveexpr	:	term{$$=$1;}
		|	additiveexpr addop term {$$=ASTCreateNode(EXPR);
                        $$->left=$1;
			$$->operator=$2;
                        $$->right=$3;
                        }
		;

addop		:	'+' {$$=PLUS;}
		|       '-' {$$=MINUS;}
		;

term		:	factor {$$=$1;}
		|	term multop factor{$$=ASTCreateNode(EXPR);
                        $$->left=$1;
			$$->operator=$2;
                        $$->right=$3;
                        }
		;

multop		:	'*'{$$=TIMES;}
		|       '/'{$$=DIVIDE;}
		;

factor		:	'(' expression ')' {$$=$2;}
		| NUM { $$=ASTCreateNode(NUMBER);
                        $$->value=$1;
		  } 
		| var {$$=$1;}
 		| call {$$=$1;}
		;

call		:	ID '(' args ')'
                         { $$=ASTCreateNode(CALL);
                            $$->name=$1;
			    $$->right=$3;
                             /*symbol table check */
                         }
		;

args		:	arglist {$$ = $1;}
		|       {$$=NULL;}/*empty*/
		;

arglist		:	expression {$$=ASTCreateNode(ARGLIST);
            			   $$->left=$1;
				   $$->next=NULL;
			}
		|	expression ',' arglist{
            			$$=ASTCreateNode(ARGLIST);
            			$$->left=$1;
            			$$->next=$3;
           		}
		;





%% /*end rules */

int main(int argv, char argc[])
{ if (argv > 2) mydebug=1;
  yyparse();
  fprintf(stderr,"the input has been syntactically checked\n");
  ASTprint(0,program);  /* this is where we can do things with the AST like print it or process it */
}
		
