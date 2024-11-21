# Sair de casa 6:52h
# Andar 1km em 10min
# Correr 3km a 6min/km
# voltar ao ritmo de 1km por 10min
# A que horas chega

# horas de partida
horasp = 6
minutosp = 52

# converter as horas em decimal

horaspd = horasp + minutosp / 60

# tempo de ida e volta em minutos (1km + 3km) * 2

tempom = 10 + 3 * 6 + 10 * 4
tempoh = tempom / 60

# hora de chegada em decimal

horascd = horaspd + tempoh

# hora de chegada no formato hh:mm

horasc = int(horascd)
minutosc = int((horascd - int(horascd)) * 60)
# dar print da hora de chegada

print("Chego a casa às {:02d}:{:02d}h para o pequeno almoço".format(horasc, minutosc))




