	.data
minus: 	.asciiz "texto em minusculas"		# minus[] = "texto em minusculas"
maius:	.space 20				# maius[20]


	.text
	.globl main
	
main: 
	la $t0, minus				# t0 = minus
	li $t1, 0				# int i = 0   t1 = i
	la $t6, maius				# t6 = maius
wh:	
	add $t2, $t0, $t1			# t2 = &minus[i]	////////	array + i * tamanho(1)
	lb $t3, 0($t2)				# t3 = copia minus[i]
	li $t4, '\0'				# t4 = "\0"
	
	beq $t3,$t4,done			# while minus[i] != "\0"
	add $t7, $t6, $t1			# t7 = &maius[i]
	lb $t8, 0($t7)				# t8 = copia maius[i]
	addi $t5, $0, 'A'			# t5 = "A"
	subi $t5, $t5, 'a'			# t5 = "A"-"a"

	blt $t3, 'a', else			# if (minus[i]>='a')
	bgt $t3, 'z', else			# if (minus[i]<='z')
	
	add $t8, $t3, $t5			# maius[i] = minus[i] + 'A' - 'a'
	sb $t8, 0($t7)	
	j endif
else:						
	move $t8, $t3				# else
	sb $t8, 0($t7)				#   maius[i] = minus[i]
endif:
	addi $t1, $t1, 1			# i++	
	j wh
  	
done: 
	move $a0, $t6
	li $v0, 4
	syscall
	
	li $v0, 10
	syscall