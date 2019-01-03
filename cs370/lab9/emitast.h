#ifndef EMITAST_H
#define EMITAST_H 


#include<stdio.h>
#include<malloc.h>
#include "ast.h"
int mydebug;


void emitast(ASTnode *p, FILE *fp); 
void printglob(ASTnode *p, FILE *fp);
void emitIdent(ASTnode *p, FILE *fp);
void emitText(ASTnode *p, FILE *fp);
void emitStrings(ASTnode *p, FILE *fp);
void emitAssign(ASTnode *p, FILE *fp);
void emitExpr(ASTnode *p, FILE *fp);
void emitES(ASTnode *p, FILE *fp);
void emitIf(ASTnode *p, FILE *fp);
void emitWhile(ASTnode *p, FILE *fp);
void emitFunc(ASTnode *p, FILE *fp);
void emitArgs(ASTnode *p, FILE *fp);
void emitParams(ASTnode *p, ASTnode *p1, ASTnode *p2, FILE *fp);
void emitReturn(ASTnode *p, FILE *fp);
#endif
