# preço fabrico 20€
# preço livro 29,45€
# taxa iva 23%
# + 0.20€
# 500 exemplares

PF = 20
PC = 24.95
IMP = .23
SPA = .20
EX = 500

# PC = (PF + Lucro) * (100% + IMP) + SPA
# PC = (PF + Lucro) * (1 + IMP) + SPA

lucro = (((PC - SPA) / (1 + IMP)) - PF) * EX
imposto = (( PC * IMP ) + SPA) * EX

print("Em 500 exemplares o lucro da livraria é {}€ e o total de impostos é {}.".format(lucro, imposto,))




