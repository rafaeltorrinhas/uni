# 4

	.data
	
frase1: .space 20
frase2: .space 20
frase3: .space 20
prompt: .asciiz "\nInsira a frase1: "
prompt1:.asciiz "\nInsira a frase2: "
	.text
	.globl main
	
main: 
	la $a0, prompt
	li $v0, 4
	syscall
	
	la $v0, 8
	syscall
	
	la $a0, prompt1
	li $v0, 4
	syscall
	
	la $v0, 8
	syscall
	
	