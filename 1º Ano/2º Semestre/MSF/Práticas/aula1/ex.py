import numpy as np
import matplotlib.pyplot as plt

N = 10
X = np.random.normal(4.5,0.5,size=N)  
Xmedia = np.mean(X)           # Calcular média
Xerro = np.std(X)/np.sqrt(N)  

Y = np.random.normal(12.0,0.7,size=N)
Ymedia = np.mean(Y)
Yerro = np.std(Y)/np.sqrt(N)

Z = X+Y                   #soma de cada par de valores
Zmedia = np.mean(Z)       #melhor est. do valor de Z
Zerro = np.std(Z)/np.sqrt(N)
Zerro_frm = Xerro + Yerro

W = X*Y                   #produto de cada par de valores
Wmedia = np.mean(W)


print(Xmedia,Xerro,Ymedia,Yerro,Zmedia,Zerro,Zerro_frm,Wmedia)