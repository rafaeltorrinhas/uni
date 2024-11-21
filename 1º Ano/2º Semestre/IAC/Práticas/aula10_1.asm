    	.data
dst: 	.asciiz "abc"
lixo: 	.asciiz "ZZZZZZZZZZZZZZZ"		# usado para testar como funciona o programa
src: 	.asciiz "def"

    	.text
    	.globl main

main:
    	la $a0, dst		# a0 = dst
    	la $a1, src		# a1 = src
    	
	jal strcat
	
	move $a0,$v0
	li $v0, 4
	syscall
	
	li $v0, 10
	syscall
	
strcopy: 

	li $t0, 0          	# i = 0
	
while:
	add $t1, $a1, $t0		# t1 = src + 4 * i = &src[i]
	lb $t2, 0($t1)			# t2 = copia &src[i]
	
   	beq $t2, '\0', endwhile 	# while src[i] != "\0"
   	
	add $t3, $a0, $t0		# t3 = &dst[i]
	sb $t2, 0($t3)			# dst[i] = src[i]
	
	addi $t0, $t0, 1		#i++
   	j while        			

endwhile:
	
	li $t4, '\0'
	add $t3, $a0, $t0
	sb $t4, 0($t3)			# dst[i] = '\0'
	move $v0, $a0
   	
   	jr $ra
   	
strcat:					# char * strcat(char *dst, char *src)
	subi $sp, $sp, 8			
	sw $ra, 0($sp)		
	sw $s0, 4($sp)			#salvaguarda $ra e $s0
					#dst -> $a0, src -> $a1, aux -> $s0
	move $s0, $a0			#char * aux = dst;
	
strcatwh: 
	lb $t0 , 0($a0)
	beq $t0, '\0', endstrcatwh	
	addi $a0, $a0, 1
	
	j strcatwh
	
endstrcatwh:
	jal strcopy
	move $v0, $s0
	
	lw $ra, 0($sp)
	lw $s0, 4($sp)
	addi $sp, $sp, 8
	jr $ra
	
	
	
	
