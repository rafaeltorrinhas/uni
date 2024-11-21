	.data
nums:	.word -2, 3, 6, 4, 8, 126, -131, 17
comma: 	.asciiz ","
	.text
	.globl main
	
main:	
	
	li $t0, 0 		# t0 = i = 0	
	la $t1, nums		# t1 = nums
	
for:		
	bge $t0, 8, endfor	# for(i = 0; i < 8; i++)
	sll $t2, $t0, 2		# t2 = 4 * i
	add $t2, $t1, $t2	# t2 = nums + 4 * i = &nums[i]
	
	lw $a0, 0($t2)		# a0 = cópia lista[i]
	div $t3, $a0, 2		# t3 = lista[i] / 2
	mfhi $t4		# t4 = lista[i] % 2
if:		
	bne $t4, 0, endif	# if val%2 == 0
	
	li $v0, 1		# print_int10(val)
	syscall
	
	la $a0, comma		# print_char(',')
	li $v0, 4
	syscall

endif:	
	addi $t0, $t0, 1	# i++
	j for
endfor:
	
	la $v0, 10	#exit()
	syscall
