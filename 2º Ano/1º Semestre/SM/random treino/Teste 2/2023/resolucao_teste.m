%% 1.

figure(1);

[x, t, num, den] = exame2(2999,1);
a = diff(t);

fprintf("1. \n A variável a possui dimensão 1x399 e contém os valores das diferenças entre as amostras temporais consecutivas, ou seja, cada elemento de a representa a diferença entre uma amostra e a anterior ([X(n) - X(n-1)]). Dessa forma, cada valor em a corresponde ao tempo de amostragem (Ta), que é o intervalo de tempo entre duas amostras consecutivas.\n")

Ta = a(1);
fa = 1/Ta;


Espetro(x,Ta);
title("Espetro de x antes do filtro");
xlim([-fa/2 fa/2])
xlabel('Frequencia (Hz)')
grid on;

%% 2.

figure(2);

[y] = filter(num, den, x); 
Espetro(y,Ta);
title("Espetro de x depois do filtro");
xlim([-fa/2 fa/2])
xlabel('Frequencia (Hz)')
grid on;

fprintf("\n2. \n y e o conteudo de frequencia do sinal de saida")


%% 3.

figure(3);

fprintf("\n3. \n Aplicando o filtro a 'x', a frequência é atenuada quando a resposta do filtro é menor que 1, com maior atenuação próxima de 0. Frequências como 40Hz são bastante atenuadas e 10Hz quase eliminadas, enquanto 110Hz e 130Hz sofrem alterações mínimas. Os gráficos confirmam essas observações.\n");

[H, f] = respFreq(num,den,fa);
plot(f, H);
title("Modulo da resposta em frequencia do filtro");
xlabel('Frequencia (Hz)')
xlim([-fa/2 fa/2])

grid on;

%% 4.

figure(4)
a = diff(t);

Ta = a(1);
fa = 1/Ta;

subplot(1,3,1);
Espetro(x,Ta);
title("Espetro de x antes do filtro");
xlabel('Frequencia (Hz)')
xlim([-fa/2 fa/2])

grid on;

%% Resposta em Frequencia do filtro

f_elim = 110; 
R=0.9;
teta=2*pi*(f_elim/fa);

num=[1 -2*cos(teta) 1];
den=[1 -2*R*cos(teta) R^2];

[H, f] = respFreq(num,den,fa);
subplot(1,3,2);

plot(f, H);
title("Modulo da resposta em frequencia do filtro");
xlabel('Frequencia (Hz)')
xlim([-fa/2 fa/2])

grid on;

%% Aplicar filtro a x

[y] = filter(num, den, x);
subplot(1,3,3);

Espetro(y,Ta);
title("Espetro de x depois do filtro");
xlabel('Frequencia (Hz)')
xlim([-fa/2 fa/2])

grid on;