/*
Victor Lozoya 
lab5
create rules in lex to read tokens and feed them to yacc
create key workds like int, void, if, else, etc
also keep count of line number for debugging purposes



*/


%{

int mydebug=1;
int count = 1;
#include "ast.h" 
#include "y.tab.h"
%}


%%

int 		{if (mydebug) fprintf(stderr, "Int found\n");
			/*reserved/keyword int */
			return(INT);}
void		{if (mydebug) fprintf(stderr, "Void found\n");
			/*reserved/key word void*/
			return(VOID);}
if		{if (mydebug) fprintf(stderr, "if found\n");
			/*reserved/key word void*/
			return(IF);}
else		{if (mydebug) fprintf(stderr, "else found\n");
			/*reserved/key word void*/
			return(ELSE);}
while		{if (mydebug) fprintf(stderr, "while found\n");
			/*reserved/key word void*/
			return(WHILE);}
for		{if (mydebug) fprintf(stderr, "for found\n");
			/*reserved/key word void*/
			return(FOR);}
return		{if (mydebug) fprintf(stderr, "return found\n");
			/*reserved/key word void*/
			return(RETURN);}
read		{if (mydebug) fprintf(stderr, "read found\n");
			/*reserved/key word void*/
			return(READ);}
write		{if (mydebug) fprintf(stderr, "write found\n");
			/*reserved/key word void*/
			return(WRITE);}
"<="		{if (mydebug) fprintf(stderr, "less than equal found\n");
			return(LE);}
">="		{if (mydebug) fprintf(stderr, "greater than equal found\n");
			return(GE);}
"=="		{if (mydebug) fprintf(stderr, "equal found\n");
			return(EQ);}
"!=" 		{if (mydebug) fprintf(stderr, "not equal found\n");
			return(NE);}
"<"		{return (L);}
">"		{return (G);} 

[a-zA-Z][a-zA-Z0-9]*	{if (mydebug) fprintf(stderr,"ID found\n"); 
                       		yylval.string=strdup(yytext); return(ID);}

[0-9][0-9]*	{if (mydebug) fprintf(stderr,"Digit found\n"); 
                       yylval.value=atoi((const char *)yytext); return(NUM);}

[<>=()\-+*/%&\[\]|;{},]  { if (mydebug) fprintf(stderr,"return a token %c\n",*yytext); 
                    		return(*yytext);}
[ \t]		{}
\n		{count++;}

%%

int yywrap(void)
{return 1;}

