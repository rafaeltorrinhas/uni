	.data
frase: 	.asciiz "Te3m In5tei1ros Mis8tura9dos"
msg:	.asciiz "\nO nr de Alfas e: "
	.text
	.globl n_alphas
	.globl main
	
main: 
	la $a0, msg
	li $v0, 4
	syscall	
	
	la $a0, frase
	
	jal n_alphas
	
	move $a0, $t1
	
	li $v0, 1
	syscall
	
	li $v0, 10
	syscall
		
		
n_alphas:

	li $t0, 0	# i = 0
	li $t1, 0	# alphas = 0	
	move $t2, $a0
for:	
	addu $t3, $t2, $t0
	lb $s0, 0($t3)
	
	beq $s0, '\0', endfor
	
if:	blt $s0, 'A', endif
	bgt $s0, 'z', endif
	
	addi $t1, $t1, 1
	
endif:	
	addi $t0, $t0, 1
	j for
endfor:
	jr $ra
