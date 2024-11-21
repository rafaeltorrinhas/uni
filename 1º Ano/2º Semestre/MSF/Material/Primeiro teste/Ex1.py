import numpy as np
import matplotlib.pyplot as plt


# 1. a)
x = t = np.array([0,1,2,3,4,5,6,7])
y = num = np.array([11,20,33,54,83,134,244,425])

N = len(x)
sum_x = np.sum(x)
sum_y = np.sum(y)
sum_xy = np.sum(x*y)
sum_xx = np.sum(x ** 2)
sum_yy = np.sum(y ** 2)

r2 = (N * sum_xy - sum_x * sum_y)**2 / ((N * sum_xx - sum_x**2) * (N * sum_yy - sum_y**2))
m = ((N * sum_xy - sum_x * sum_y)/(N*(sum_xx)-((sum_x)**2)))
b = (((sum_xx * sum_y)-sum_x * sum_xy)/(N*sum_xx-((sum_x)**2)))

print(f"Coeficiente de determinação = {r2}")
plt.plot(x,y, "o", color = "red")
plt.plot(x, m * x + b)
plt.xlabel("Tempo (h)")
plt.ylabel("Número de bactérias")
plt.show()
print("\nConsoante o aumento do tempo, o número de bactérias também aumenta. Logo, como não há diminuição de valores em nenhum dos valores conhecidos, conclui-se que a relação entre o número se bactérias e o tempo é linear")

# 1. b)
y = np.log10(y)

sum_x = np.sum(x)
sum_y = np.sum(y)
sum_xy = np.sum(x*y)
sum_xx = np.sum(x ** 2)
sum_yy = np.sum(y ** 2)

r2 = (N * sum_xy - sum_x * sum_y)**2 / ((N * sum_xx - sum_x**2) * (N * sum_yy - sum_y**2))
m = ((N * sum_xy - sum_x * sum_y)/(N*(sum_xx)-((sum_x)**2)))
b = (((sum_xx * sum_y)-sum_x * sum_xy)/(N*sum_xx-((sum_x)**2)))
dm = np.abs(m) * np.sqrt(((1/r2)-1)/(N-2)) 

plt.plot(x,y, "o", color="red")
plt.plot(x,m*x+b)
plt.xlabel("Tempo (h)")
plt.ylabel("log(Número de bactérias)")
plt.show()
print(f"Declive = {m}\nErro = {dm}\nCoeficiente de determinação = {r2}")

# 1. c)




