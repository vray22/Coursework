#include "ast.h" 



/* uses malloc to create an ASTnode and passes back the heap address of the newly created node */
ASTnode *ASTCreateNode(enum ASTtype mytype)
{
    ASTnode *p;
    //if (mydebug) fprintf(stderr,"Creating AST Node \n");
    p=(ASTnode *)malloc(sizeof(ASTnode));
    p->type=mytype;
    p->next=NULL; //added next
    p->symbol=NULL;
    //p->istype=NULL;  
    p->left=NULL;
    p->right=NULL;
    p->s1=NULL;
    p->s2=NULL;
    p->value=0;
    return(p);
}



/* attach q to the left most part of p */
void ASTattachleft(ASTnode *p,ASTnode *q)
{
//... missing
}


/*  Print out the abstract syntax tree */
void ASTprint(int level,ASTnode *p)
{
   int i;
   if (p == NULL ) return;
   else
     { 
     for (i=0;i<level;i++) printf(" "); /* print tabbing blanks */
      
       switch (p->type) {
        case VARDEC :  printf("Variable declaration with name %s ",p->name);
                     if (p->value > 0)
                        printf("[%d]\n",p->value);
                     printf("\n");
	             ASTprint(level,p->next);
                     break;
//....missing
	case FUNCTIONDEC :  printf("Function declaration with name %s \n",p->name);
                        ASTprint(level+1,p->left);
			ASTprint(level+1,p->right);
             
                        ASTprint(level,p->next);
                    

                      break;
	case PARAM : if(p->operator == 5) 
			printf("Param VOID %s \n",p->name);
		     
		     else 
			printf("Param INT %s \n",p->name);

		     ASTprint(level, p->next);

		      break;
	case BLOCK: printf("BLOCK \n");
		    ASTprint(level+1, p->left);
		    ASTprint(level+1, p->right);
		      break;
	case READSTMT: printf("READ STATEMENT \n");
			ASTprint(level+1, p->right);
		      break;
	case IDENT:  printf("IDENTIFIER %s \n", p->name);
		      break;
	case WRITESTMT: printf("WRITE STATEMENT \n");
			ASTprint(level+1, p->right);
		      break;
	case EXPRSTMT: printf("EXPRSTMT \n "); 
			ASTprint(level+1, p->right);
		      break;
 	
	case ASSIGN:   printf("ASSIGNMENT STATMENT \n ");
			ASTprint(level+1, p->right);
			ASTprint(level+1, p->s1);
			break; 
	case IFSTMT:   printf("IF STATEMENT \n");
		       if(p->s2 != NULL){
				ASTprint(level+1, p->right);
				ASTprint(level+1, p->s1);
				ASTprint(level+1, p->s2);
			}
			else{
				ASTprint(level+1, p->right);
				ASTprint(level+1, p->s1);
			}
			break;
	case WHILESTMT: printf("WHILE STATEMENT \n");
			ASTprint(level+1, p->right);
			ASTprint(level+1, p->s1);
			break;
	case RETURNSTMT: printf("RETURN STATEMENT \n");
			 if(p->right == NULL){}
			 else{
				ASTprint(level+1, p->right);
			}
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
		   break; 
	case NUMBER: printf("NUMBER with value %d \n ", p->value);
		   break;
	case CALL:printf("CALL to %s \n ", p->name);
		  ASTprint(level+1, p->right);
		   break;
	case ARGLIST: if(p->next == NULL){
				ASTprint(level+1, p->left);
		      }
		      else{
				ASTprint(level+1, p->left);
				ASTprint(level, p->next);
		      }
		    break; 
        default: printf("unknown type in ASTprint\n");


       }
     }

}
