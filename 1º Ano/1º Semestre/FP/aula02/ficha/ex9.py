# Pedir as notas CTP e CP
# Calcular a nota final
# Se alguma componente for inferior á nota mínima, a nota final deve ser 66
# Se o aluno reprovar por nota mínima ou nota inferior a 10 o programa deve pedirr as notas de recurso ATPR e APR 
# Depois calcular a nota final

# 1. Pedir as notas

CTP = float(input("Nota CTP? "))
CP = float(input("Nota CP? "))

# 2. Calcular a nota final

if CTP > 6.5 and CP > 6.5:
    NF = 0.3*CTP + 0.7*CP 
    print("Nota final: ", NF) 
else:
    print("Reprovado por nota mínima")
    ATPR = float(input("Nota ATPR? "))
    APR = float(input("Nota APR? "))
    if ATPR > 6.5 and APR > 6.5:
        NF = .3*max(CTP, ATPR) + .7*max(CP, APR)
        print ("Nota final: ", NF)
    else:
        NF = 66
        print("Reprovado por nota mínima")



    

