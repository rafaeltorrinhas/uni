	.data
lista: 	.space 24
str: 	.asciiz "Insira 6 numeros: \n"

	.text
main:

	la $a0, str
	li $v0, 4	
	syscall				# print_str("Insira 6 numeros: ")
	
	la $t1, lista
	li $t0, 0			# i = 0
	
for:
	bge $t0, 6, endfor 		# for (i = 0; i < 6; i++)
	
	sll $t3, $t0 ,2			# t3 = 4 * i
	add $t3, $t1, $t3		# t3 = lista + 4 * i = &lista[i]
	
	li $v0, 5
	syscall				# read_int
	
	sw $v0, 0($t3) 			# t2 = read_int


	addi $t0, $t0, 1		# i++
	j for
endfor:
	
	
	li $t2, 0 		# i = 0	
do:
	
	li $t6, 0		# t6 = houveTroca = FALSE
	
for2: 	bge $t2, 5, endfor2	# for (i = 0; i < SIZE-1; i++)

	lw $t4, 0($t3)		# t4 = copia lista[i]
	lw $t5, 4($t3)		# t5 = copia lista[i + 1]
	
if:	ble $t4, $t5, endif	# if (lista[i] > lista[i + 1]
	sw $t4, 4($t3)		# lista[i+1] = cópia lista[i]
	sw $t5, 0($t3)		# lista[i] = cópia
	li $t6, 1		# houveTroca = TRUE
	
	
endif:	
	addi $t2, $t2, 1	# i++
	j for

endfor2:

while: 	beq $t6, 1, do

	li $v0, 10
	syscall
	
	


