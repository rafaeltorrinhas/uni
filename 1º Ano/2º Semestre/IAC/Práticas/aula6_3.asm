	.data
prompt1:.asciiz "Introduza um numero\n"
result:	.asciiz "O fatorial do numero inserido é: "

	.text
		
	la $a0, prompt1
	li $v0, 4
	syscall
	
	li $v0, 5
	syscall
	
	move $t0, $v0			# t0 = n
	
	li $t1, 1			# t1 = f
	
for: 	ble $t0, $0, endfor 		
	mul $t1, $t1, $t0	
	addi $t0, $t0, -1
	j for

endfor:	
	la $a0, result
	li $v0, 4
	syscall
	
	move $a0, $t1
	li $v0, 1
	syscall
	
	li $v0, 10
	syscall