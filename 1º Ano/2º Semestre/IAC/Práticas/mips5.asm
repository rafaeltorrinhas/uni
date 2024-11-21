	.data
s1: 	.asciiz "Introdiza dois números: "
s2: 	.asciiz "A soma dos números é: "

	.text
main: 	la $a0, s1
	li $v0, 4
	syscall
	
	li $v0, 5
	syscall
	
	move $t0, $v0
	
	li $v0, 5
	syscall
	
	move $t1, $v0
	
	la $a0, s2
	li $v0, 4
	syscall
	
	add $t2, $t1, $t0
	
	la $a0, $t2
	li $v0, 4
	syscall
	
	
