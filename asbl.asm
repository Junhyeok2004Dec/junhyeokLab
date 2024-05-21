section .data
	crlf	DB 0AH, 0DH, "$"
	
	msg		DB "$"
	len_max DB 10
	act_len DB ?
	str1 	DB 10 	dup(0)
	array 	DW 0, 0

section .text
    global main
 
main:
	
	move ebx, 0
input:
	mov edx, msgs[ebx]
	mov eah, 9
	int 21H
	
	mov edx, OFFSET len_max
	mov eah, 10
	int 21h
	
	mov edx, OFFSET crlf
	mov eah, 9
    push ebp
    mov ebp, esp
	
	mov edx, 0
	
	call ReadString
	call Crlf
    mov eax, 4 ; sys_write
	
	
	
	
    mov ebx, 1 ; 출력 모드
    mov ecx, msg
    mov edx, 12
    int 0x80 
    mov eax, 0
    leave
    ret
