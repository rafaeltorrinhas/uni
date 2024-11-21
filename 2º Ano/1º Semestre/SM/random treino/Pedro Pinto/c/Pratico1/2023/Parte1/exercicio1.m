%% Alinea b)

Ta = 0.01;      % Periodo de amostragem, em segundos
T = 2;
f0 = 1/2;         % Frequencia do sinal composto, em Hz
Np = 2;         % Numero de periodos a considerar para o sinal resultante
K = 50;   

len_c = K*2 + 1;

ck = zeros(1,len_c);

if (rem(K,2)) == 0
    impares = (2:2:len_c);
else
    impares = (1:2:len_c);
end


% Impares
if (rem(K,2)) == 0
    k_val = -K + 1;
else
    k_val = -K;
end

for idx = impares
    ck(idx) = 4/(j*pi*k_val);
    k_val = k_val + 2;
end

% Pares = 0 (ja definido)

% c_0

ck(floor(K/2)) = 0;

[x, t] = fourierFuncExp(Ta, f0, Np, ck);

plot(t,x),xlabel("segundos"),title("k="+K);
grid on