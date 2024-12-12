%% Tratamento de dados inicial
[x, t, num, den] = exame2(2023,1);

%% 1

fprintf("1.\n")
Ta_array = diff(t);
Ta = Ta_array(1);
Fa = 1/Ta;

fprintf(" O periodo de amostragem e %.4f s e a frequencia de amostragem e %d Hz\n",Ta,Fa)

%% 2
fprintf("2.\n")

figure(1)

subplot(2,1,1)

N = length(x);
Fa = 1/Ta;
X = fftshift(fft(x)) .* (1/N);
f = (0:N-1)*Fa/N - Fa/2; 
    
stem(f,abs(X));
xlim([-Fa/2 Fa/2]);
title("Sinal original");
xlabel("Frequencia (Hz)");
grid on;

subplot(2,1,2)

[y] = filter(num, den, x); 
X = fftshift(fft(y)) .* (1/N);
stem(f,abs(X));
xlim([-Fa/2 Fa/2]);
title("Sinal filtrado");
xlabel("Frequencia (Hz)");
grid on;


fprintf(" O conteudo de frequencia do sinal do filtro e a variavel y\n")

%% 3

fprintf("3.\n")

figure(2);

M = 1024;

[H, ~]=freqz(num,den,M,Fa,'whole');
H = abs(fftshift(H)); 
f = (0:M-1)*Fa/M - Fa/2; 

plot(f, H);

title("Modulo da resposta em frequencia do filtro");
xlabel('Frequencia (Hz)')
xlim([-Fa/2 Fa/2])

fprintf(" Aplicando o filtro a 'x', a frequência perde intensidade quando a resposta do filtro é menor que 1.\n Frequências como 70Hz,50Hz,30Hz são bastante reduzidas e , para valores mais baixos, quase eliminadas por completo,\n enquanto de 100 a 130Hz sofrem alterações pouco significativas.\n Estas observaçoes podem ser verificadas atraves da analise dos graficos.\n");

grid on;

%% 4

figure(3)
a = diff(t);

Ta = a(1);
Fa = 1/Ta;

subplot(3,1,1);
X = fftshift(fft(x)) .* (1/N);
f = (0:N-1)*Fa/N - Fa/2; 

stem(f,abs(X));
title("Espetro de x antes do filtro");
xlabel('Frequencia (Hz)')
xlim([-Fa/2 Fa/2])

grid on;

% Resposta em Frequencia do filtro

f_elim = 10;

R=0.9;
teta=2*pi*(f_elim/Fa);

num=[1 -2*cos(teta) 1];
den=[1 -2*R*cos(teta) R^2];


[H, ~]=freqz(num,den,M,Fa,'whole');
H = abs(fftshift(H)); 
f = (0:M-1)*Fa/M - Fa/2; 


subplot(3,1,2);

plot(f, H);
title("Modulo da resposta em frequencia do filtro");
xlabel('Frequencia (Hz)')
xlim([-Fa/2 Fa/2])

grid on;

% Aplicaçao do filtro
[y] = filter(num, den, x);


X = fftshift(fft(y)) .* (1/N);
f = (0:N-1)*Fa/N - Fa/2; 


subplot(3,1,3);

stem(f,abs(X))
title("Espetro de x depois do filtro");
xlabel('Frequencia (Hz)')
xlim([-Fa/2 Fa/2])

grid on;
