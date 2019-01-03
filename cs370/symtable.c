/*
Victor Lozoya 
Feb 20
Removed a bunch of methods and also removed label from original code
this code's purpose is to store variables in a symbol table and assign a 
particular address. Yacc will use this class to compute operations 




*/








#include<stdio.h>
/* #include<conio.h> */
#include<malloc.h>
#include<string.h>
#include<stdlib.h>




int v1;
int v2;
int v3; 
int size=0;

void Insert(char *sym, int addy);
int Search(char lab[]); 
int FetchAddr(char *sym);


struct SymbTab
{
	char symbol[10];   
	int addr;
	struct SymbTab *next;};
	struct SymbTab *first,*last;

	void Insert(char *sym, int addy)
	{
		int n;
		n=Search(sym);
		if(n==1)
			printf("\n\tThe label exists already in the symbol table\n\tDuplicate can.t be inserted");
		else
		{
			struct SymbTab *p;
			p=malloc(sizeof(struct SymbTab));			
			strcpy(p->symbol,sym);
			p->addr = addy; 
			p->next=NULL;
			if(size==0)
			{
				first=p;
				last=p;
			}
			else
			{
				last->next=p;
				last=p;
			}
		size++;
		}
		printf("\n\tSymbol inserted\n");
	}

	int Search(char *s)
	{
		int i,flag=0;
		struct SymbTab *p;
		p=first;
		for(i=0;i<size;i++)
		{
			if(strcmp(p->symbol,s)==0)
				flag=1;
			p=p->next;
		}
		return flag;
	}

	//will search and find the address of a particular variable 
	int FetchAddr(char *s)
	{
		int i, flag; 
		int addy=-1; 
		struct SymbTab *p;
		p=first;
		for(i=0;i<size;i++)
		{
			if(strcmp(p->symbol,s)==0){
				flag=1;
				addy = i; 
				 
			}
			p=p->next;
			if(flag == 1){
				return addy;
               			printf("value was found at address: %d", addy);
			}
			else{
			    return addy; 
			}
		}
	
	}

//end struct
