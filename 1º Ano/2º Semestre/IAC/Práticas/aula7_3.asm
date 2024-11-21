	.data
maius: 	.asciiz "TEXTO EM MAIUSCULAS"		# maius[] = "TEXTO EM MAIUSCULAS"
minus:	.space 20				# minus[20]


	.text
	.globl main
	
main: 
	la $t0, maius				# t0 = maius
	li $t1, 0				# int i = 0   t1 = i
	la $t6, minus				# t6 = minus
wh:	
	add $t2, $t0, $t1			# t2 = &maius[i]	/////	array + i * tamanho(1)
	lb $t3, 0($t2)				# t3 = copia maius[i]
	li $t4, '\0'				# t4 = "\0"
	
	beq $t3,$t4,done			# while maius[i] != "\0"
	add $t7, $t6, $t1			# t7 = &minus[i]
	lb $t8, 0($t7)				# t8 = copia minus[i]
	addi $t5, $0, 'a'			# t5 = "a"
	subi $t5, $t5, 'A'			# t5 = "a"-"A"

	blt $t3, 'A', else			# if (maius[i]>='A')
	bgt $t3, 'Z', else			# if (maius[i]<='Z')
	
	add $t8, $t3, $t5			# minus[i] = maius[i] + 'A' - 'a'
	sb $t8, 0($t7)	
	j endif
else:						
	move $t8, $t3				# else
	sb $t8, 0($t7)				#   minus[i] = maius[i]
endif:
	addi $t1, $t1, 1			# i++	
	j wh
  	
done: 
	move $a0, $t6
	li $v0, 4
	syscall
	
	li $v0, 10
	syscall
