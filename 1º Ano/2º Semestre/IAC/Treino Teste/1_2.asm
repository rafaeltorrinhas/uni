	.data
	.eqv SIZE, 8
nums:	.word -2,3,6,4,8,126,-131,17
	.text
	
	li $t0, 0 		# i = 0
	la $t1, nums
for:	bge $t0, SIZE, endfor	# for( i=0; i< SIZE; i++ )
	
	sll $t2, $t0, 2 	# t2 = 4*i
	addu $t3, $t2, $t1	# t3 = &nums[i]
	lw $t4, 0($t3)		# t4 = copia &nums[i]
	
	div $t5, $t4, 2		# val/2
	mfhi $t6		# val%2
	
if:	bnez $t6, endif		# if val%2 === 0
	
	move $a0, $t4
	li $v0, 1
	syscall
	
	la $a0, ','
	li $v0, 11
	syscall
	
endif:
	addu $t0, $t0, 1
	j for

endfor: 
	li $v0, 10
	syscall
	
	
	
	
	
	
