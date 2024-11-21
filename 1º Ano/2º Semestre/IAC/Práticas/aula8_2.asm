	.data
lista: 	.space 24
str: 	.asciiz "Insira 6 numeros: \n"
str2: 	.asciiz " - "
	.text
main:

	la $a0, str
	li $v0, 4	
	syscall				# print_str("Insira 6 numeros: ")
	
	la $t1, lista
	li $t0, 0			# i = 0
	
for:
	bge $t0, 6, endfor 		# for (i = 0; i < 6; i++)
	
	sll $t4, $t0 ,2			# t4 = 4 * i
	add $t4, $t1, $t4		# t4 = lista + 4 * i = &lista[i]
	
	li $v0, 5
	syscall				# read_int
	
	sw $v0, 0($t4) 			# t2 = read_int


	addi $t0, $t0, 1		# i++
	j for
endfor:
	
	li $t2, 0 		# i = 0	
			
for2:	
	bge $t2,6, endfor2	# for (i=0; i < 6; i++)
	sll $t3, $t2 ,2		# t3 = 4 * i
	add $t3, $t1, $t3	# t3 = lista + 4 * i = &lista[i]
	
	lw  $a0, 0($t3)		# a0 = cópia lista[i]
	li  $v0, 1
	syscall			# print_int10(lista[i])
	
	la $a0, str2
	li $v0, 4
	syscall 		# print_str(" - ")
	
	addi $t2, $t2, 1	# i++
	j for2 
	
endfor2:
	li $v0, 10
	syscall
	
