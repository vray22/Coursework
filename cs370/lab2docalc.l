/*             lex routine that now recognizes the token int and allows variables with long names
		copies the variable to yylval.string and any digits to yylval.value this helps yacc have a copy of 
		the value 
*/
%{

int mydebug=1;
#include "y.tab.h"
%}


%%

int 		{if (mydebug) fprintf(stderr, "Int found\n");
			/*reserved/keyword int */
			return(INT);}
[a-zA-Z][a-zA-Z0-9]*	{if (mydebug) fprintf(stderr,"Letter found\n"); 
                       yylval.string=strdup(yytext); return(VARIABLE);}//make duplicate of yytext to yylval.string for yacc
[0-9][0-9]*	{if (mydebug) fprintf(stderr,"Digit found\n"); 
                       yylval.value=atoi((const char *)yytext); return(INTEGER);}
[ \t]		{if (mydebug) fprintf(stderr,"Whitespace found\n");}
[=\-+*/%&|()] 	{ if (mydebug) fprintf(stderr,"return a token %c\n",*yytext); 
                       return (*yytext);}//added parenthesis to this rule 
\n 		{ if (mydebug) fprintf(stderr,"cariage return %c\n",*yytext); 
                       return (*yytext);}

%%

int yywrap(void)
{ return 1;}


