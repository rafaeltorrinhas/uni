	.data
input: 	.space 10
frase: 	.asciiz "Te3m In5tei1ros Mis8tura9dos"
msg:	.asciiz "\nO nr de Alfas e: "
	.text
	.globl main
	.globl n_alphas
	
main: 	
	la $t2, frase		# t2 = frase
	
	la $a0, msg
	li $v0, 4		# print_str(msg)
	syscall
	
	jal n_alphas		# n = n_alphas(frase)
	
	move $a0, $t1
	li $v0, 1		# print_int10(n)
	syscall
	
	j exit
	
n_alphas: 
	# la $a0, input
	# li $a1, 10
	# li $v0, 8		# read_string()
	# syscall	
	
				# move $t2, $a0		# t2 = str
	
	li $t0, 0		# t0 = i = 0
	li $t1, 0 		# t1 = alfas = 0
		
for: 	
	addu $t3, $t2, $t0	# t2 = str + i = &str[i]
	lb $s0, 0($t3)		# s0 = str[i]
	beq $s0, '\0', endfor	# for
	
	
if: 
	blt $s0, 'A', endif	# if1 
	bgt $s0, 'z', endif	# if2
	
	addi $t1, $t1, 1
	

endif:

	addi $t0,$t0,1
	j for


endfor:
	
	jr $ra
	
			
exit:
	li $v0, 10
	syscall
	
	

	
	
	
	

	
