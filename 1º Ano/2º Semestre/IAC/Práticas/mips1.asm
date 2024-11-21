	.data
numero: .word 0x12345678
frase: 	.asciiz "Ola Mundo"
	.text
main:	addi 	$v0, $0, 4 	#$v0 = 0 + 4
	la	$a0, frase
	syscall			#printstring("Ola Mundo")
	
	addi 	$v0, $0, 10
	syscall			# exit()