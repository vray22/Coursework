%include "io64.inc";for standard output
section .data
_L0: db "it worked", 0 ;global string
_L1: db "it didn't work", 0 ;global string
section .text
	global main



 main:	; start of function
	mov rbp, rsp	;SPECIAL RSP to RSB for MAIN only
	mov    r8, rsp		;FUNC header RSP has to be at most RBP
	add    r8, -200,		;adjust Stack Pointer for Activation record
	mov    [r8], rbp		;FUNC header store old BP
	mov [r8+8],rsp		;FUNC header store old SP
	mov    rsp, r8		;FUNC header new SP

	mov rbx, 5 
	mov [rsp + 112], rbx ;store value in memory 

	mov 	rax,96 ;get the offset of identifier
	add	rax, rsp ; add offset to sp
	mov rbx, [rsp + 112]  ;fetch value from memory
	mov [rax], rbx; store assignment
	mov rbx, 5 
	mov [rsp + 120], rbx ;store value in memory 
	mov rbx, 24 ;exppression is number store in rbx

	mov 	rax,16 ;get the offset of identifier
	add	rax, rsp ; add offset to sp
	add	rax, rbx ;add values for array reference
	mov rbx, [rsp + 120]  ;fetch value from memory
	mov [rax], rbx; store assignment
	mov rbx, 2 
	mov [rsp + 128], rbx ;store value in memory 
	mov rbx, 16 ;exppression is number store in rbx

	mov 	rax,16 ;get the offset of identifier
	add	rax, rsp ; add offset to sp
	add	rax, rbx ;add values for array reference
	mov rbx, [rsp + 128]  ;fetch value from memory
	mov [rax], rbx; store assignment

	mov 	rax,96 ;get the offset of identifier
	add	rax, rsp ; add offset to sp
	mov rbx, [rax]; store contents of rax to rbx
	mov [rsp + 136], rbx ;store value in memory 
	mov rbx, 40 ;exppression is number store in rbx

	mov 	rax,16 ;get the offset of identifier
	add	rax, rsp ; add offset to sp
	add	rax, rbx ;add values for array reference
	mov rbx, [rsp + 136]  ;fetch value from memory
	mov [rax], rbx; store assignment
_L2: 
	mov rbx, 40 ;exppression is number store in rbx

	mov 	rax,16 ;get the offset of identifier
	add	rax, rsp ; add offset to sp
	add	rax, rbx ;add values for array reference
	mov rax, [rax]; store identifier to rax
	MOV [RSP + 144], RAX; store LHS 
	mov rbx, 0 ;rhs num store to rbx
	MOV rax, [RSP + 144]; fetch LHS
	cmp rax, rbx ;expr greater than 
	setg al ; expr greater than
	mov rbx, 1; rbx to 1 to filter rax
	and rax, rbx; filter rax 
	MOV [RSP + 144], RAX ;store final result
	mov rax, [rsp + 144]; store sp + offset of p->right in rbx
	cmp rax, 0
	je _L3 
	mov rax, 3 ;left hand side a number store to rax
	MOV [RSP + 152], RAX; store LHS 
	mov rbx, 1 ;rhs num store to rbx
	MOV rax, [RSP + 152]; fetch LHS
	imul rax, rbx ; multiply values 
	MOV [RSP + 152], RAX ;store final result
	mov rbx, [rsp + 152]; store sp + offset of p->right in rbx
	shl rbx, 3        ; ARRAy reference needs WSIZE differencing

	mov 	rax,16 ;get the offset of identifier
	add	rax, rsp ; add offset to sp
	add	rax, rbx ;add values for array reference
	mov rax, [rax]; store identifier to rax
	MOV [RSP + 168], RAX; store LHS 
	mov rax, 1 ;left hand side a number store to rax
	MOV [RSP + 160], RAX; store LHS 
	mov rbx, 2 ;rhs num store to rbx
	MOV rax, [RSP + 160]; fetch LHS
	imul rax, rbx ; multiply values 
	MOV [RSP + 160], RAX ;store final result
	mov rbx, [rsp + 160]; store sp + offset of p->right in rbx
	shl rbx, 3        ; ARRAy reference needs WSIZE differencing

	mov 	rax,16 ;get the offset of identifier
	add	rax, rsp ; add offset to sp
	add	rax, rbx ;add values for array reference
	mov rbx, [rax]; rhs is ident after fetched from mem store in rbx 
	MOV rax, [RSP + 168]; fetch LHS
	cmp rax, rbx ;expr greater than 
	setg al ; expr greater than
	mov rbx, 1; rbx to 1 to filter rax
	and rax, rbx; filter rax 
	MOV [RSP + 168], RAX ;store final result
	mov rax, [rsp + 168]; store sp + offset of p->right in rbx
	cmp rax, 0
	je _L4 
	PRINT_STRING _L0 ;print a string 
	NEWLINE ;standard write a newline
	jmp _L5 
_L4: 
	PRINT_STRING _L1 ;print a string 
	NEWLINE ;standard write a newline
_L5: 

	mov 	rax,96 ;get the offset of identifier
	add	rax, rsp ; add offset to sp
	mov rax, [rax]; store identifier to rax
	MOV [RSP + 176], RAX; store LHS 
	mov rbx, 1 ;rhs num store to rbx
	MOV rax, [RSP + 176]; fetch LHS
	SUB RAX, RBX ;sub values
	MOV [RSP + 176], RAX ;store final result
	mov rbx, [rsp + 176]; store sp + offset of p->right in rbx
	mov [rsp + 184], rbx ;store value in memory 

	mov 	rax,96 ;get the offset of identifier
	add	rax, rsp ; add offset to sp
	mov rbx, [rsp + 184]  ;fetch value from memory
	mov [rax], rbx; store assignment

	mov 	rax,96 ;get the offset of identifier
	add	rax, rsp ; add offset to sp
	mov rbx, [rax]; store contents of rax to rbx
	mov [rsp + 192], rbx ;store value in memory 
	mov rbx, 40 ;exppression is number store in rbx

	mov 	rax,16 ;get the offset of identifier
	add	rax, rsp ; add offset to sp
	add	rax, rbx ;add values for array reference
	mov rbx, [rsp + 192]  ;fetch value from memory
	mov [rax], rbx; store assignment
	jmp _L2 
_L3: 
	MOV rsi, 270 ;load immediate val
	PRINT_DEC 8, rsi ;standard Write a value
	NEWLINE	;standard Write a NEWLINE

	mov 	rax,96 ;get the offset of identifier
	add	rax, rsp ; add offset to sp
	MOV rsi, [rax] ;load immediate val
	PRINT_DEC 8, rsi ;standard Write a value
	NEWLINE	;standard Write a NEWLINE

	mov 	rax,104 ;get the offset of identifier
	add	rax, rsp ; add offset to sp
	GET_DEC 8, [rax]

	mov 	rax,104 ;get the offset of identifier
	add	rax, rsp ; add offset to sp
	MOV rsi, [rax] ;load immediate val
	PRINT_DEC 8, rsi ;standard Write a value
	NEWLINE	;standard Write a NEWLINE
	mov    rbp,[rsp] 		;FUNC end restore old BP
	mov rsp,[rsp+8]		;FUNC end restore old SP
	mov    rsp,rbp 		;stack and BP need to be same on exit for main
	ret

