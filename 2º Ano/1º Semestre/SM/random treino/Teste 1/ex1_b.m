t = 2;                       % Periodo
f = 1/t;                     % Freq
ta = 0.001;                  % Periodo de Amostragem
tempo = -4:ta:t;             % Tempo
k=10000;
c = zeros(1, 2*k+1); % Ck = [0,0,0,0,...]
c(2:2:end) = 6./(1j*pi*(-k+1:2:k))

[t, xt] = fourier_func_ck(ta, f, 4, c);
plot(t,xt);
xlim([-4,4])
ylim([-4,4])
xlabel('Tempo');
ylabel('x(t)');