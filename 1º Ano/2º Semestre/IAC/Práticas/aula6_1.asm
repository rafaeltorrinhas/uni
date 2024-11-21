	.data
prompt1:.asciiz "Introduza um numero\n"
strpar: .asciiz "O número é par\n"
strimp:	.asciiz "O numero é ímpar\n"

	.text

	la $a0, prompt1
	li $v0, 4
	syscall
	
	la $v0, 5
	syscall
	
	move $t0, $v0
	
	and $t1, $t0, 1
	
	#seq $t2, $t1, 0
	#beq $t2, $0, Else
	bne $t1, $0, Else
	la $a0, strpar
	li $v0, 4
	syscall 
	j Endif
Else:	
	la $a0, strimp
	li $v0, 4
	syscall
Endif:
	li $v0, 10
	syscall
	
	
	
	