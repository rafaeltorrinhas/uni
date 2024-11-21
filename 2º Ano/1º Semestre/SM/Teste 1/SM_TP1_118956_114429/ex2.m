
clear
clc
close all

fprintf("2.\n")
[s,Fa] = exame(118,2);
fprintf("a)\n")
T = 0.25;

fprintf("  1) Período: %.1f segundos.\n", T)
fprintf("  2) Foram registados 4 segundos de sinal.\n")
fprintf("  3) Soma de 4 sinusoides, com frequências 0, 12, 24, 40.\n\n")

fprintf("b)")
Ta = 1/Fa;
N = 4/Ta;
% N = length(s);

fprintf("%.0f amostras.\n",N)
[X,f] = Espetro(s,Ta);
t = (0:N-1) / Fa;                % eixo do tempo
%f = (0:N-1) * (Fa / N) - Fa/2;  % eixo das frequências

fprintf("\nc) Gráfico \n\n")

figure("Name","c) ")
subplot(2,1,1)
plot(t,s)
xlabel("Tempo (s)")
ylabel("Amplitude")

subplot(2,1,2)
plot(f,X)
ylim([0,2.5])
xlabel("Frequencia (Hz)")
ylabel("Magnitude")

fprintf("d) ")

figure("Name", "d)")
subplot(2,1,1)
s1 = 2*s - 2;
plot(t,s)
xlabel("Tempo")
ylabel("s - Amplitude")
subplot(2,1,2)
plot(t,s1)
xlabel("Tempo")
ylabel("s1- Amplitude")
fprintf("Ao multiplicarmos s1 por 2 e retirando 2 estamos a dobrar a amplitude do sinal e a fazer com que a componente DC seja igual a -2, isto é, move a sinusoide 2 unidades para baixo.\n")


fprintf("\ne) ")
fprintf("Ao retirarmos uma das componentes sinusoidais, a amplitude irá diminuir, a forma da onda poderá variar e, devido à frequência ser o máximo divisor comum entre a frequência de cada uma das suas componentes, a mesma também poderá ser alterada.\n")


fprintf("\nf) Gráfico\n")

figure("Name", "f)")
filtro = zeros(1, length(f));
filtro(abs(f)>23) = 1;          %tira as últimas 2 frequências (frequências 24 e 40)
Y = X.*filtro;
subplot(1,1,1)
Reconstroi(X,f);
hold on
Reconstroi(Y,f);
legend("Sinal Original", "Sinal Filtrado")
xlim([0,4])