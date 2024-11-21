%% 1. Resposta: A variavel 'a' tem dimensao 1x399 e todos os valores
% correspondem as diferencas entre as amostras temporais (ex: [X(2)-X(1)
% X(3)-X(2) ... X(n)-X(n-1)] ), o que significa que cada valor de 'a' 
% corresponde ao tempo de amostragem (Ta), tempo entre cada amostra
figure;

[x, t, num, den] = exame2(2023,1);
a = diff(t); % [Ta, Ta, ..., Ta] 

Ta = a(1);
fa = 1/Ta;

% Sem filtro
Espetro(x,Ta);
title("Espetro de x antes do filtro");
xlim([-fa/2 fa/2])
xlabel('Frequencia (Hz)')
grid on;

%% 2. 
figure;

% Aplicamos o filtro as amplitudes x
[y] = filter(num, den, x); 
Espetro(y,Ta);
title("Espetro de x depois do filtro");
xlim([-fa/2 fa/2])
xlabel('Frequencia (Hz)')
grid on;

% y e o conteudo de frequencia do sinal de saida do filtro

%% 3. Resposta: Aplicando o filtro a 'x', a frequencia e atenuada
% quando a resposta em frequencia do filtro e
% menor que 1, e quanto mais proximo de 0 mais atenuaçao
% se ve na frequencia. No nosso caso, para a frequencia
% 40Hz e bastante atenuada, e para a frequencia 10Hz fica
% quase nula.
% Por outro lado, quando a resposta em frequencia do filtro
% esta proximo de 1, a frequencia nao sofre alteracoes significantes. 
% No nosso caso, para as frequencias 110Hz e 130Hz apenas sofrem
% ligueiras alteracoes.
% Observando os 3 graficos conseguimos verificar estas afirmacoes.
figure;

[H, f] = respFreq(num,den,fa);
plot(f, H);
title("|Resposta em Frequencia| do filtro");
xlim([-fa/2 fa/2])
xlabel('Frequencia (Hz)')
grid on;



