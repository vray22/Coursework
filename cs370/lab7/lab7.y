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
#include <stdlib.h>
#include <ctype.h>
//#include "lex.yy.c"
#include "symtable.h"
#include "ast.h"
int yylex();

extern int count; 
 int level=0; 
 int goff;
 int off; 

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
			  if(Search($2,level,0) == NULL){//if symbol not used insert into symbol table 
				$$=ASTCreateNode(VARDEC); 
				$$->operator=$1; 
				$$->istype=$1;
				$$->symbol=Insert($2,$1,0,level,1,off,NULL);
				$$->name=$2;
				off+=1;
			  }
			  else{
				//yyerror($2);
				yyerror("Symbol already used ");
				exit(1);
			  }
		      } 
		|	typespec ID '[' NUM ']' ';' {
				
			   if(Search($2,level,0) == NULL){//if array not in symbol table insert 
				$$=ASTCreateNode(VARDEC);
				$$->operator=$1;
				$$->istype=$1; 
		                $$->name=$2; /* this changes to symbol table*/
		                $$->value=$4; /* remember dimension*/
				$$->symbol=Insert($2,$1,2,level,$4,off,NULL);
				off+=$4;
		                printf("found an array declaration \n");
                  	  }
			  else{
				//yyerror($2);
				yyerror("Symbol already used ");
				exit(1);
			 }
		      }
		;

typespec	:	INT {$$=INTTYPE;}
		|	VOID{$$=VOIDTYPE;}
		;

FUNDEC		:	typespec ID '('{
				 if (Search($2,level,0)==NULL){
					Insert($2,$1,1,level,0,0,NULL);
					goff=off;//store current offset
					off=0;
				}
				else{
					//yyerror($2);
					yyerror("Symbol already used ");
					exit(1);
				}
			}
		      	params{
				(Search($2,0,0))->fparms = $5;//pointer to params
			}


			')' compoundstmt{

				$$=ASTCreateNode(FUNCTIONDEC);
				$$->operator=$1; 
				$$->istype=$1;
                            	$$->name=$2; /* this changes to symbol table*/
				$$->left=$5;
                            	$$->right = $8; /* compound statement */
				$$->symbol = Search($2,0,0);

				off-=Delete(1);//decide how much to decrement of stack pointer 
				level=0;
				off=goff;//back to normal offset 				
				
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
			if(mydebug) Display();
			   if(Search($2,level+1,0)==NULL){//insert param to symbol table if it isn't already 
				$$=ASTCreateNode(PARAM);
				$$->operator=$1;
				$$->istype=$1;
				$$->name=$2;
				$$->symbol=Insert($2,$1,0,level+1,1,off,NULL);
				mydebug && printf("in param insert %s %d\n",$2,level+1);
			   	if(mydebug) Display();
			   	$$->value = 0;
			   	off+=1;
			   }
		           else{
				//yyerror($2);
				yyerror("Symbol already used ");
				exit(1);
			   }
			}
		|	typespec ID '['  ']'{
				if(Search($2,level+1,0) == NULL){		
					$$=ASTCreateNode(PARAM);
					$$->operator=$1;
					$$->istype=$1; 
					$$->name=$2;
					$$->symbol=Insert($2,$1,2,level+1,1,off,NULL);
					$$->value=-1;
					off+=1;
				}
				else{
					//yyerror($2);
					yyerror("Symbol already used ");
					exit(1);
				}
			}
		;

compoundstmt	:	'{' { level++; mydebug && printf("Block level is %d\n", level);}  
			      localdec statementlist '}'{ 
				
				$$=ASTCreateNode(BLOCK);
                         	if ($3==NULL){ /* no local declarations */
                                	$$->right=$4;}
                        	else{ /* we had some declarations, put them together */
					$$->left=$3;                             		
					$$->right=$4;}//ASTattachleft($3,$4);
                           	
				Display();  /* display symbol table as per requirement */
                        	off-=Delete(level);  /* decrease the offset count by the size of values allocated at level */
                        	level--;  /* down one level */
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
                                  $$->right=$1;
				  $$->istype=$1->istype;}
		|	';' { $$=NULL; }
		;

assistmt	:	var '=' exprstmt {
			//printf("%d \n",$1->istype);
			if(($1->istype != $3->istype) || ($1->type == VOIDTYPE)){//type checking and making sure not void 
				yyerror("error in assingment statement ");
				exit(1);
			}
			
				$$=ASTCreateNode(ASSIGN);
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

var		:	//use variables here 
			//p=Search($1, level,1)) != Null
			//struct Symtab *p 
			ID {
				struct SymbTab * p;
				if((p=Search($1,level,1)) != NULL){ 

					$$=ASTCreateNode(IDENT);
			    		$$->name=$1;
					$$->symbol=p;
					$$->istype=p->Type;
					if(p->IsAFunc == 1){
						//yyerror($1);
						yyerror("Variable not a function, syntax error ");
						exit(1);
					}//end if 
				}

				else{
					//yyerror($1);
					yyerror("Undeclared variables ");
					exit(1);
				}
						
			}
		|	ID '[' expression ']'{
				struct SymbTab * p;	
				if((p=Search($1,level,1)) != NULL){

					$$=ASTCreateNode(IDENT);
					$$->name=$1;
					$$->right=$3;

					$$->istype=p->Type; 
					if(p->IsAFunc == 2){//if array okay if not error
						$$->symbol = p;
						
					}
					else{
						yyerror("here3, syntax error ");
						exit(1);
					}	

				}

				else {
					//yyerror($1);
					yyerror("Undeclared variables here2 ");
					exit(1);
                                   }
                        }
		;

simpleexpr	:	additiveexpr {$$=$1;}
		|	simpleexpr relop additiveexpr{
			if(($1->istype) != ($3->istype)){

				yyerror("type relop mismatch");
				exit(1);
			}

			$$=ASTCreateNode(EXPR);
                        $$->left=$1;
			$$->operator=$2;
                        $$->right=$3;
			$$->istype = $1->istype;
			$$->name = CreateTemp();//create temp value 
			$$->symbol = Insert($$->name, $$->istype, 0, level, 1, off, NULL);//insert temp to symbol table 
			off+=1;
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
		|	additiveexpr addop term {
			if(($1->istype) != ($3->istype)){//type checking 

				yyerror("type mismatch");
				exit(1);
			}


			$$=ASTCreateNode(EXPR);
                        $$->left=$1;
			$$->operator=$2;
                        $$->right=$3;
			$$->istype = $1->istype;//inheritence 
			$$->name = CreateTemp();
     //printf("Here1\n");
			$$->symbol=Insert($$->name, $$->istype, 0, level, 1, off, NULL);
			off+=1;
                        }
		;

addop		:	'+' {$$=PLUS;}
		|       '-' {$$=MINUS;}
		;

term		:	factor {$$=$1;}
		|	term multop factor{
			if(($1->istype) != ($3->istype)){

				yyerror("type mismatch");
				exit(1);
			}


			$$=ASTCreateNode(EXPR);
                        $$->left=$1;
			$$->operator=$2;
                        $$->right=$3;
			$$->istype = $1->istype;
			$$->name = CreateTemp();
			$$->symbol=Insert($$->name, $$->istype, 0, level, 1, off, NULL);
			off+=1;
                        }
		;

multop		:	'*'{$$=TIMES;}
		|       '/'{$$=DIVIDE;}
		;

factor		:	'(' expression ')' {$$=$2;}
		| NUM { $$=ASTCreateNode(NUMBER);
                        $$->value=$1;
			$$->istype=INTTYPE;  //num is always type INT
		  } 
		| var {$$=$1;}
 		| call {$$=$1;}
		;

call		:	ID '(' args ')' //add CompareFormals to symTable to check if list of param is same of arg list 
                         { 
				struct SymbTab * p; 
int s;
				if((p=Search($1,0,0)) != NULL){

					if(p->IsAFunc != 1){//check if is function 
						
						yyerror("Not a function ");
						exit(1);
					}
                        s=(CompareFormals(p->fparms,$3));
//printf("CF restuls is %d\n",s);
					if(CompareFormals(p->fparms,$3)==0){//compare parameter list 
						
						yyerror("Param length not same or type mismatch ");
						exit(1);
					}
			    		$$=ASTCreateNode(CALL);
                            		$$->name=$1;
					$$->symbol=p;
					$$->istype=p->Type;
			    		$$->right=$3;
                             /*symbol table check */
				}

				else{
					
					yyerror("function name not defined!");
					exit(1);
				}
                         }
		;

args		:	arglist {$$ = $1;}
		|       {$$=NULL;}/*empty*/
		;

arglist		:	expression {$$=ASTCreateNode(ARGLIST);
            			   $$->left=$1;
				   $$->next=NULL;
			           $$->istype=$1->istype;//inheritence  
			}
		|	expression ',' arglist{
            			$$=ASTCreateNode(ARGLIST);
            			$$->left=$1;
            			$$->next=$3;
				$$->istype=$1->istype;//inheritence 
           		}
		;





%% /*end rules */

int main(int argv, char argc[])
{ if (argv > 2) mydebug=1;
  yyparse();
  fprintf(stderr,"the input has been syntactically checked\n");
  Display();
  //ASTprint(0,program);  /* this is where we can do things with the AST like print it or process it */
}
		
