%% b)
[s, Fa] = exame(118,1);
Fa_dado = Fa; % Numero de amostras em 1 segundo

% Periodo = 0.5s
Fa = Fa/2; % Numero de amostras por periodo
Ta = 1 / Fa;

T = 1; % em segundos
Np = 2; % Numero de periodos

N = round(Np * T/Ta); % 400 amostras

t = (0:N-1)*(1/Fa_dado);

f = (0:N-1)*Fa_dado/N - Fa_dado/2; 

%% c)
figure;

subplot(2,1,1);
plot(t,s), xlabel("segundos");
grid on

subplot(2,1,2);
X = fftshift(fft(s)) .* (1/N);
stem(f,X), xlabel("Hertz"), ylim([0 0.5]);
grid on

%% f)
figure;

x1_filtrada = zeros(length(f),1);
f1_filtrada = zeros(length(f),1);

for i=1:length(f)
    if abs(f(i)) == 12
        f1_filtrada(i,1) = f(1,i);
        x1_filtrada(i,1) = X(1,i);
    end
end

fa = max(f1_filtrada)*2;
ta = 1/fa;
% Calculando a Inverse Fast Fourier Transformer do sinal
x = ifft(ifftshift(x1_filtrada))*N;
    % t = (0:N-2)*ta; 

plot(t,x), xlabel("segundos");
grid on;


