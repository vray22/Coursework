#ifndef AST_H
#define AST_H 


#include<stdio.h>
#include<malloc.h>
int mydebug;

/* define the enumerated types for the AST.  THis is used to tell us what 
sort of production rule we came across */

/* this is a partial list of NODE types for the ASTNode */

enum ASTtype {
   PROGRAM,
   VARDEC,
   IDENT,
   //.... stuff is missing
   //added stuff
   FUNCTIONDEC,
   PARAM,
   BLOCK,
   EXPRSTMT,
   ASSIGN,
   IFSTMT,
   WHILESTMT,
   RETURNSTMT,
   READSTMT,
   WRITESTMT,
   EXPR,
   NUMBER,
   CALL,
   ARGLIST,
   
};


enum OPERATORS {
   PLUS,
   MINUS,
   TIMES,
   DIVIDE,
   INTTYPE,
   VOIDTYPE,
   LESSTHANEQUAL,
   LESSTHAN,
   GREATERTHAN,
   GREATERTHANEQUAL,
   EQUAL,
   NOTEQUAL,
   
};

/* define a type AST node which will hold pointers to AST structs that will
   allow us to represent the parsed code 
*/
typedef struct ASTnodetype
{
     enum ASTtype type;
     enum OPERATORS operator; 
     enum OPERATORS istype;
     char * name;
     int value;
     struct ASTnodetype *next,*left,*right; /* left is usually the connector for statements, added symbol to for pointer to symbol table  */
     struct SymbTab *symbol; 
     struct ASTnodetype *s1,*s2 ; /* used for holding IF and WHILE components -- not very descriptive */
} ASTnode;


ASTnode *ASTCreateNode(enum ASTtype mytype);


void ASTattachleft(ASTnode *p,ASTnode *q);

ASTnode *program;
#include "symtable.h"

void ASTprint(int level,ASTnode *p); 



#endif
