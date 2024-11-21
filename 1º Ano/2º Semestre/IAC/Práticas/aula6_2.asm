	.data
prompt1:.asciiz "Introduza um numero:\n"

	.text
	
	la $a0, prompt1
	li $v0, 4
	syscall
	
	
	li $v0, 5
	syscall
	
	move $t0, $v0 
	
	li $t1, 0		#fora do ciclo (inicialização)  #1
for:	bge $t1, $t0, endfor					#2 (se o incremento for 1 pode-se usar beq em vez de bge
	li $a0, '-'						#|	
	li $v0, 11						#|3
	syscall							#|
	addi $t1, $t1, 1	# i++				#4
	j for
endfor:
	li $v0, 10
	syscall
	