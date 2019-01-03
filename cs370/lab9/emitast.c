/*
Victor Lozoya
Lab9
cs370
in this lab we will create nasm code from our AST tree structure 
we will mainly work with rax and rbx to store contents of registers
will create an activation record for each function and adjust the sp and base 
pointer accordingly 

*/






#include "emitast.h" 
#include "ast.h"
#include "symtable.h"
#define wsize 8 // this is for the word size for the stack each block is 8 words 



/*
goal is to traverse tree and print all global variables
param: ASTnode pointer, File pointer
precondition: *p must be pointing to the AST root node , *f must piont to file 
to write to 
return: no return value
postcondition:all the global variables will be printed along with size
*/
void printglob(ASTnode *p, FILE *fp){
	char s[100];
	if(p==NULL) return;
	if(p->type == VARDEC){
		if(p->symbol->level == 0){
			fprintf(fp,"	common %s %d ;global string\n", p->name, p->symbol->mysize * wsize);
		}
	}
	
	printglob(p->next, fp);
}

/*  Print out the abstract syntax tree
print out header for nasm code follwed by global variables 
data section followed by all the strings and finally the main program 
param: ASTnode pointer and file pointer 
precondition: p must be pointing the the root of an AST *f must point to file to piont to
return:void
postcondition: nasm assembly code will be outputed to file which can then be run on nasm enviroment
 */
void emitast(ASTnode *p, FILE *fp)
{
   fprintf(fp,"%%include \"io64.inc\";for standard output\n");//for standard output 
   printglob(p,fp);   
   fprintf(fp,"section .data\n"); 
   emitStrings(p,fp);
   fprintf(fp,"section .text\n");
   fprintf(fp,"	global main\n");
   emitText(p,fp);
}



/*
pre condition: p must point to identifier node fp must point to file
param:ASTnode *p, FILE *fp
goal:store the value of p->right into rax
post condition: rax will hold the value of p->right
*/
void emitIdent(ASTnode *p, FILE *fp){
    
   if(p->right != NULL){//check if p is an array 
	switch(p->right->type) {

         case NUMBER:    fprintf(fp,"	mov rbx, %d ;exppression is number store in rbx\n", p->right->value*wsize);
                         break;
	 case IDENT:	emitIdent(p->right,fp);//expression is an identifier go fetch it from memory 
			fprintf(fp,"	mov rbx, [rax]; store contents of rax which is expression value in array to rbx\n");
			fprintf(fp,"	shl rbx, 3        ; ARRAy reference needs WSIZE differencing\n");
			break;
	 case EXPR:	emitExpr(p->right,fp);//expression is exprstatement
			fprintf(fp,"	mov rbx, [rsp + %d]; store sp + offset of p->right in rbx\n",p->right->symbol->offset*wsize);
			fprintf(fp,"	shl rbx, 3        ; ARRAy reference needs WSIZE differencing\n");
			break;
	 case CALL:	emitFunc(p->right,fp);
			fprintf(fp,"	mov rbx, rax;\n");
			break;
         default: fprintf(fp,"CRAPP!!!! \n");

      } // of switch
  	


   }//end if 
   //check if global variable if so store name into rax
   if(p->symbol->level == 0){
	fprintf(fp,"\n	mov	rax, %s ;name of identifier\n", p->symbol->name);
   }

   else{//not global 
	fprintf(fp,"\n	mov 	rax,%d ;get the offset of identifier\n", p->symbol->offset*wsize);
	fprintf(fp,"	add	rax, rsp ; add offset to sp\n");
   }   

   
   if(p->right != NULL){//check if array 
		fprintf(fp,"	add	rax, rbx ;add values for array reference\n");
			
   }	
	
    
}//end emitIdent


/*
pre condition: p must point to root node fp must point to file
param:ASTnode *p, FILE *fp
goal:traverse tree and print out all the strings
post condition: all strings along with label will be in the data section 
*/
void emitStrings(ASTnode *p, FILE *fp){
    //printf("test test test \n ");
    if(p == NULL) return; 
    if(p->type == WRITESTMT){
	if(p->name != NULL){	
		fprintf(fp,"%s: db %s, 0 ;global string\n",p->stringVal,p->name);
        }
    }
    
    emitStrings(p->next,fp);
    emitStrings(p->right,fp);
    emitStrings(p->s1,fp);
    emitStrings(p->s2,fp);
}//end emitStrings 



/*
pre condition: p must point to expression node fp must point to file
param:ASTnode *p, FILE *fp
goal:evaluate expression and store final result in memory 
post condition: sp + offset will hold final result 
*/

void emitExpr(ASTnode *p, FILE *fp){

    	//do left hand side 
	switch(p->left->type) {

         case NUMBER:    fprintf(fp,"	mov rax, %d ;left hand side a number store to rax\n", p->left->value);
                         break;
	 case IDENT:	 emitIdent(p->left,fp);
			 fprintf(fp,"	mov rax, [rax]; store identifier to rax\n");
			 break;
	 case EXPR:	emitExpr(p->left,fp);
			fprintf(fp,"	mov rax, [rsp + %d]; store sp + offset of expression in rax\n",p->left->symbol->offset*wsize);
			break;
	 case CALL:	printf("*****2\n");
			emitFunc(p->left,fp);
			fprintf(fp,"	mov rax, rax; ");
			break;

         default: fprintf(fp,"CRAPP!!!! \n");

      } // of switch
 
   	fprintf(fp,"	MOV [RSP + %d], RAX; store LHS \n", p->symbol->offset*wsize);
    
     /// do the RHS
     
       switch(p->right->type) {

         case NUMBER:    fprintf(fp,"	mov rbx, %d ;rhs num store to rbx\n", p->right->value);
                         break;
	 case IDENT:	emitIdent(p->right,fp);
			fprintf(fp,"	mov rbx, [rax]; rhs is ident after fetched from mem store in rbx \n");
			break;
	 case EXPR:	emitExpr(p->right,fp);
			fprintf(fp,"	mov rbx, [rsp + %d]; store sp + offset of expression in rbx\n",p->right->symbol->offset*wsize);
			break;
	 case CALL:	emitFunc(p->right,fp);
			//fprintf(fp,"	mov rbx, rax;\n");
			break;
         default: fprintf(fp,"CRAPP!!!! \n");

      } // of switch
  
    	fprintf(fp,"	MOV rax, [RSP + %d]; fetch LHS\n", p->symbol->offset*wsize);
    
    // do the operation

    switch (p->operator ) {
        case PLUS:   fprintf(fp,"	ADD RAX, RBX ;add values\n");
                     break;
	case MINUS:  fprintf(fp,"	SUB RAX, RBX ;sub values\n");
		     break; 
	case DIVIDE:  fprintf(fp,"	xor rdx, rdx ; rdx needs to be zero\n");
		      fprintf(fp,"	idiv rbx \n ; divide values"); 
	              break;
	case TIMES:   fprintf(fp,"	imul rax, rbx ; multiply values \n");
		       break;
	case EQUAL:   fprintf(fp,"	cmp rax, rbx ; equal  \n");
		      fprintf(fp,"	sete al ; set if equal\n");
		      fprintf(fp,"	mov rbx, 1; rbx to 1 to filter rax\n");
		      fprintf(fp,"	and rax, rbx; filter rax \n");
		      break;
	case NOTEQUAL: fprintf(fp,"	cmp rax, rbx ; expr not equal \n");
		      fprintf(fp,"	setne al ; set if not equal\n");
		      fprintf(fp,"	mov rbx, 1; rbx to 1 to filter rax\n");
		      fprintf(fp,"	and rax, rbx; filter rax \n");
		      break;
	case LESSTHAN: fprintf(fp,"	cmp rax, rbx ;expr less than \n");
		      fprintf(fp,"	setl al ; expr less than\n");
		      fprintf(fp,"	mov rbx, 1; rbx to 1 to filter rax\n");
		      fprintf(fp,"	and rax, rbx; filter rax \n");
		      break;
	case LESSTHANEQUAL: fprintf(fp,"	cmp rax, rbx ;expr less than equal \n");
		      fprintf(fp,"	setle al ; expr less than equal\n");
		      fprintf(fp,"	mov rbx, 1; rbx to 1 to filter rax\n");
		      fprintf(fp,"	and rax, rbx; filter rax \n");
		      break;
	case GREATERTHANEQUAL:	fprintf(fp,"	cmp rax, rbx ;expr greater than equal \n");
		      fprintf(fp,"	setge al ; expr greater than equal\n");
		      fprintf(fp,"	mov rbx, 1; rbx to 1 to filter rax\n");
		      fprintf(fp,"	and rax, rbx; filter rax \n");
		      break;
	case GREATERTHAN: fprintf(fp,"	cmp rax, rbx ;expr greater than \n");
		      fprintf(fp,"	setg al ; expr greater than\n");
		      fprintf(fp,"	mov rbx, 1; rbx to 1 to filter rax\n");
		      fprintf(fp,"	and rax, rbx; filter rax \n");
		      break;
        default:  fprintf(fp,"Extra heavy crap \n");


   } //end switch 

    fprintf(fp,"	MOV [RSP + %d], RAX ;store final result\n", p->symbol->offset*wsize);
   /// store the result 
}



/*
pre condition: p must point to assingment node fp must point to file
param:ASTnode *p, FILE *fp
goal:evaluate assignment statement store result to memory  
post condition: sp + offset will hold final result 
*/
void emitAssign(ASTnode *p, FILE *fp){

	emitES(p->s1,fp);//s1 is the expression 
	emitIdent(p->right,fp);//right is identifier 
        
	fprintf(fp,"	mov rbx, [rsp + %d]  ;fetch value from memory\n",p->s1->symbol->offset*wsize);
	fprintf(fp,"	mov [rax], rbx; store assignment\n");	

}

/*
pre condition: p must point to expression statment node fp must point to file
param:ASTnode *p, FILE *fp
goal:evaluate expression depending on type store temp value in rbx then final store  
post condition: sp + offset will hold final result 
*/
void emitES(ASTnode *p, FILE *fp){

	switch(p->right->type){

	  case NUMBER:    fprintf(fp,"	mov rbx, %d \n", p->right->value);
                         break;
	 case IDENT:	emitIdent(p->right,fp);
			fprintf(fp,"	mov rbx, [rax]; store contents of rax to rbx\n");
			break;
	 case EXPR:	emitExpr(p->right,fp);
			fprintf(fp,"	mov rbx, [rsp + %d]; store sp + offset of p->right in rbx\n",p->right->symbol->offset*wsize);
			break;
	 case CALL:	printf("*****3\n");
			emitFunc(p->right,fp);
			//fprintf(fp,"	mov rbx, rax;\n");
			break;
         default: fprintf(fp,"CRAPP!!!! \n");

	}//end switch 
	
	fprintf(fp,"	mov [rsp + %d], rbx ;store value in memory \n",p->symbol->offset*wsize);
}//end emitES






/*
pre condition: p must point to if node fp must point to file
param:ASTnode *p, FILE *fp
goal:create two temporary labels which will act like the if and else eval the condition and based 
on that result than create nasm code to jump to the else or continue with the first statement  
post condition: both statements are printed out depending on condition and result in rax will determine jmp  
*/
void emitIf(ASTnode *p, FILE *fp){
	//create labels 
	char *LL1 = CreateTempL();
	char *LL2 = CreateTempL();
	
		//determine the conddition inside if which can be any of the following cases
		//result will be in rax 
		switch(p->right->type){
			case NUMBER:    fprintf(fp,"	mov rax, %d \n", p->right->value);
                         		break;
	 		case IDENT:	emitIdent(p->right,fp);
					fprintf(fp,"	mov rax, [rax]; store contents of rax to rbx\n");
					break;
	 		case EXPR:	emitExpr(p->right,fp);
					fprintf(fp,"	mov rax, [rsp + %d]; store sp + offset of p->right in rbx\n",p->right->symbol->offset*wsize);
					break;
	 		case CALL:	emitFunc(p->right,fp);
					//fprintf(fp,"	mov rbx, rax;\n");
					break;
         		default: fprintf(fp,"CRAPP!!!! \n");

		}
		fprintf(fp,"	cmp rax, 0\n");
		fprintf(fp,"	je %s \n",LL1);
		emitText(p->s1,fp);
		fprintf(fp,"	jmp %s \n", LL2);
		fprintf(fp,"%s: \n", LL1);
		emitText(p->s2,fp);
		fprintf(fp,"%s: \n", LL2);


}//end emitif 

/*
pre condition: p must point to while statment node fp must point to file
param:ASTnode *p, FILE *fp
goal:will create labels and based on condition will jump back to loop or jump out of loop   
post condition: rax will hold the result of the condition 
*/
void emitWhile(ASTnode *p, FILE *fp){
	//create labels 
	char *LL1 = CreateTempL();
	char *LL2 = CreateTempL();

	fprintf(fp,"%s: \n", LL1);
	switch(p->right->type){//determine condition 
			case NUMBER:    fprintf(fp,"	mov rax, %d \n", p->right->value);
                         		break;
	 		case IDENT:	emitIdent(p->right,fp);
					fprintf(fp,"	mov rax, [rax]; store contents of rax to rbx\n");
					break;
	 		case EXPR:	emitExpr(p->right,fp);
					fprintf(fp,"	mov rax, [rsp + %d]; store sp + offset of p->right in rbx\n",p->right->symbol->offset*wsize);
					break;
	 		case CALL:	emitFunc(p->right,fp);
					//fprintf(fp,"	mov rbx, rax;\n");
					break;
         		default: fprintf(fp,"CRAPP!!!! \n");

	}
	fprintf(fp,"	cmp rax, 0\n");
	fprintf(fp,"	je %s \n",LL2);
	emitText(p->s1, fp);
	fprintf(fp,"	jmp %s \n", LL1);
	fprintf(fp,"%s: \n", LL2);

}//end while 

/*
void emitFunc(ASTnode *p, FILE *fp){
			printf("test in func \n");
	emitArgs(p->right,fp);
	emitParams(p,p->right,p->symbol->fparms,fp);
	fprintf(fp,"	call %s\n", p->name);
			printf("test out func \n");
}


void emitArgs(ASTnode *p, FILE *fp){
		printf("test in args \n");
	if(p->left == NULL) return; 
	
	switch(p->left->type){

	  case NUMBER:    fprintf(fp,"	mov rax, %d \n", p->left->value);
                         break;
	 case IDENT:	emitIdent(p->left,fp);
			fprintf(fp,"	mov rax, [rax]; store contents of rax to rbx\n");
			break;
	 case EXPR:	emitExpr(p->left,fp);
			fprintf(fp,"	mov rax, [rsp + %d]; store sp + offset of p->right in rbx\n",p->left->symbol->offset*wsize);
			break;
	 case CALL:	emitFunc(p->right,fp);
			//fprintf(fp,"	mov rbx, rax;\n");
			break;
         default: fprintf(fp,"CRAPP!!!! \n");

	}

			printf("test out args \n");
	fprintf(fp,"	mov [rsp + %d], rax \n",p->symbol->offset*wsize);
	emitArgs(p->next,fp);
}




void emitParams(ASTnode *p, ASTnode *p1, ASTnode *p2, FILE *fp){
		printf("test in params \n");	
	fprintf(fp,"	mov rcx, rsp    ; store sp + offset of p->right in rbx\n");
	fprintf(fp,"	sub [rcx + %d], rax ; store sp + offset of p->right in rbx\n",(p->value + 1)*wsize);
	
	while(p2 != NULL){
					fprintf(fp,"	mov rax, [rsp + %d]; store sp + offset of p->right in rbx\n",p1->symbol->offset*wsize);
					fprintf(fp,"	mov [rcx + %d], rax; store sp + offset of p->right in rbx\n",p2->symbol->offset*wsize);
					p1 = p1->next;
					p2 = p2->next;
	}//end while

			printf("test end params \n");
}*/

/*
pre condition: p must point to return statment node fp must point to file
param:ASTnode *p, FILE *fp
goal: to return the sp after the function has been completed   
post condition: sp + offset will hold final result 
*/
void emitReturn(ASTnode *p, FILE *fp){

	if(p == NULL && p->right != NULL){
		printf("test in return \n");
		switch(p->right->type){
			case NUMBER:    fprintf(fp,"	mov rax, %d \n", p->right->value);
                         		break;
	 		case IDENT:	emitIdent(p->right,fp);
					fprintf(fp,"	mov rax, [rax]; store contents of rax to rbx\n");
					break;
	 		case EXPR:	emitExpr(p->right,fp);
					fprintf(fp,"	mov rax, [rsp + %d]; store sp + offset of p->right in rbx\n",p->right->symbol->offset*wsize);
					break;
	 		case CALL:	emitFunc(p->right,fp);
					//fprintf(fp,"	mov rbx, rax;\n");
					break;
         		default: fprintf(fp,"CRAPP!!!! \n");

		}
	}//end if


			printf("test out return \n");
	fprintf(fp,"	mov    rbp,[rsp] 		;FUNC end restore old BP\n");
	fprintf(fp,"	mov rsp,[rsp+8]		;FUNC end restore old SP\n");
	if(strcmp("main",p->name) == 0 )
		fprintf(fp,"	mov    rsp,rbp 		;stack and BP need to be same on exit for main\n"); 
	fprintf(fp,"	ret\n\n"); 

			printf("test out return 1 \n");
}//end return 



/*
pre condition: p must point to node in the AST structure  fp must point to file
param:ASTnode *p, FILE *fp
goal:deals with the different types of nodes that may occur in our tree   
post condition: all nodes have been evaluated and the corresponding nasm code will be outputed to the file  
*/
void emitText(ASTnode *p, FILE *fp){
   int level = 0;
   if (p == NULL ) return;
   else
     { 
    
      //different cases that will deal with the particular node 
       switch (p->type) {
        case VARDEC : //emitIdent(p);
		break;
//....missing
	case FUNCTIONDEC :  //printf("Function declaration with name %s \n",p->name);
                       // ASTprint(level+1,p->left);
			fprintf(fp,"\n\n\n %s:	; start of function\n", p->name);
			if(strcmp("main",p->name) == 0 )
				fprintf(fp,"	mov rbp, rsp	;SPECIAL RSP to RSB for MAIN only\n");
			fprintf(fp,"	mov    r8, rsp		;FUNC header RSP has to be at most RBP\n");
			fprintf(fp,"	add    r8, -%d,		;adjust Stack Pointer for Activation record\n",p->value*wsize);
			fprintf(fp,"	mov    [r8], rbp		;FUNC header store old BP\n");
			fprintf(fp,"	mov [r8+8],rsp		;FUNC header store old SP\n");
			fprintf(fp,"	mov    rsp, r8		;FUNC header new SP\n\n");

			emitText(p->right,fp);
             
                        emitText(p->next,fp);
				
		
                        
			fprintf(fp,"	mov    rbp,[rsp] 		;FUNC end restore old BP\n");
			fprintf(fp,"	mov rsp,[rsp+8]		;FUNC end restore old SP\n");
			if(strcmp("main",p->name) == 0 )
				fprintf(fp,"	mov    rsp,rbp 		;stack and BP need to be same on exit for main\n"); 
			fprintf(fp,"	ret\n\n"); 

                      break;
	case PARAM : if(p->operator == 5) 
			printf("Param VOID %s \n",p->name);
		     
		     else 
			printf("Param INT %s \n",p->name);

		     ASTprint(level, p->next);

		      break;
	case BLOCK: //printf("BLOCK \n");
		    //ASTprint(level+1, p->left);
		    printf(" test block\n");
		    emitText(p->right,fp);
		      break;
	case READSTMT: emitIdent(p->right,fp);
		       fprintf(fp,"	GET_DEC 8, [rax]\n");
		      break;
	case IDENT:  printf("IDENTIFIER %s \n", p->name);
		      break;
	case WRITESTMT: if(p->right != NULL){
			switch (p->right->type){
				case NUMBER: fprintf(fp,"	MOV rsi, %d ;load immediate val\n", p->right->value);
				break;
				
				case IDENT: emitIdent(p->right,fp);
					    fprintf(fp,"	MOV rsi, [rax] ;load immediate val\n");
				break;
			
				case EXPR:
					  printf("*****1\n");
					  emitExpr(p->right,fp);
					   fprintf(fp,"	MOV rsi, [rsp + %d] ;load immediate val\n", p->right->symbol->offset*wsize);
				break;
				default: break;
              		  }
				fprintf(fp,"	PRINT_DEC 8, rsi ;standard Write a value\n"); 
				fprintf(fp,"	NEWLINE	;standard Write a NEWLINE\n");
			}//end if 
			else{
				if(p->name != NULL){
					fprintf(fp,"	PRINT_STRING %s ;print a string \n",p->stringVal);
					fprintf(fp,"	NEWLINE ;standard write a newline\n");
				}
			}
		      break;
	case EXPRSTMT: emitExpr(p->right,fp);
		      break;
 	
	case ASSIGN:   emitAssign(p,fp);
			break; 
	case IFSTMT:   emitIf(p,fp);
			break;
	case WHILESTMT: emitWhile(p,fp);
			break;
	case RETURNSTMT: emitReturn(p,fp);
			break; 
	case EXPR: if(p->operator == PLUS){
			printf("EXPR + \n");
		   }
		   else if(p->operator == MINUS){
			printf("EXPR - \n");
		   }
		   else if(p->operator == TIMES){
			printf("EXPR * \n");
		   }
		   else if(p->operator == DIVIDE){
		 	printf("EXPR / \n");
		   }
		   else if(p->operator == LESSTHANEQUAL){
			printf("EXPR <= \n");
		   }
		   else if(p->operator == LESSTHAN){
			printf("EXPR < \n");
		   }
		   else if(p->operator == GREATERTHAN){
			printf("EXPR > \n");
		   }
		   else if(p->operator == GREATERTHANEQUAL){
			printf("EXPR >= \n");
		   }
		   else if(p->operator == EQUAL){
			printf("EXPR == \n");
		   }
		   else if(p->operator == NOTEQUAL){
			printf("EXPR != \n");
		   }
		   ASTprint(level+1, p->left);
		   ASTprint(level+1, p->right);
		   break; ; 
	case NUMBER: printf("NUMBER with value %d \n ", p->value);
		   break;
	case CALL: //emitFunc(
		   break;
	case ARGLIST: 
		    break; 
        default: printf("unknown type in ASTprint\n");


       }

      emitText(p->next,fp);//call function for next node in tree 
     }

}//end emitText


