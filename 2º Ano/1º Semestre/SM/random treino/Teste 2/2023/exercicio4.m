%% 4.
[x, t, ~, ~] = exame2(2999,1);
a = diff(t); % [Ta, Ta, ..., Ta] 

Ta = a(1);
fa = 1/Ta;

% Sem filtro
subplot(1,3,1);
Espetro(x,Ta);
title("Espetro de x antes do filtro");
xlim([-fa/2 fa/2])
xlabel('Frequencia (Hz)')
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
title("|Resposta em Frequencia| do filtro");
xlim([-fa/2 fa/2])
xlabel('Frequencia (Hz)')
grid on;

%% Aplicar filtro a x

[y] = filter(num, den, x);
subplot(1,3,3);
Espetro(y,Ta);
title("Espetro de x depois do filtro");
xlim([-fa/2 fa/2])
xlabel('Frequencia (Hz)')
grid on;
