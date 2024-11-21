	.data
lista: 	.word 4, 3, -2, 1, 4, 5
str: 	.asciiz "O conteúdo do Array é: "
str2: 	.asciiz " - "

	.text
main:
	la $a0, str
	li $v0, 4
	syscall		# print_str()
	
	la $t1, lista
	li $t0, 0	# i = 0
	
for:	
	bge $t0,6, endfor	# for (i=0; i < 6; i++)
	sll $t2,$t0,2		# t2 = 4 * i
	add $t2, $t1, $t2	# t2 = lista + 4 * i = &lista[i]
	
	lw  $a0, 0($t2)		# a0 = cópia lista[i]
	li  $v0, 1
	syscall			# print_int10(lista[i])
	
	la $a0, str2
	li $v0, 4
	syscall 		# print_str(" - ")
	
	addi $t0, $t0, 1	# i++
	j for 
	
endfor:
	li $v0, 10
	syscall
	