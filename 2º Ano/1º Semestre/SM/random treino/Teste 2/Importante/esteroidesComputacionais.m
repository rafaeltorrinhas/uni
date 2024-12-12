%% Carregar os dados
% Carregar os dados do arquivo Guitar03.mat 
% x - amostras
% fa - frequencia de amostragem
load('Guitar03.mat');
Ta = 1 / fa;

figure;
Espetro(x,Ta);
xlim([-fa/2 fa/2])
xlabel('Frequency (Hz)')
ylabel('Magnitude')
grid on;

%% Modulo da Resposta em Frequencia
figure;
R=0.9;
teta=2*pi*(5000/fa);
num=[1 -2*cos(teta) 1];
den=[1 -2*R*cos(teta) R^2];

[H, f] = respFreq(num,den,fa);
plot(f, H);
xlim([-fa/2 fa/2])
xlabel('Frequency (Hz)')
ylabel('|Resposta em Frequencia|')
grid on;

%soundsc(H,fa)

%% Aplicar um filtro 
figure;

teta=2*pi*(5000/fa);
xr=x + 0.6*cos(teta*(0:length(x)-1)'+0.1*pi);

R=0.9;
teta=2*pi*(5000/fa);
num=[1 -2*cos(teta) 1];
den=[1 -2*R*cos(teta) R^2];

% Apply the filter to xr
[y] = filter(num, den, xr);
Espetro(y,Ta);
xlim([-fa/2 fa/2])
xlabel('Frequency (Hz)')
ylabel('Magnitude')
grid on;

soundsc(y,fa);

%% Gerador de Ecos a uma parede com 17m de distancia

[x,fa] = audioread('vozportugues.wav');
Ta = 1/fa;

figure;

total_distance = 17*2;
velocity = 340;
t_total = 34/340;

a = 0.9;
D = t_total/Ta;

num=[1 zeros(1,D-1) a];
den=1;

% Apply the filter to x
[y] = filter(num, den, x);
Espetro(y,Ta);
xlim([-fa/2 fa/2])
xlabel('Frequency (Hz)')
ylabel('Magnitude')
grid on;


%% Reverbancia
figure;

[x,fa] = audioread('vozportugues.wav');
Ta = 1/fa;

Delay = 0.01; 
Gain = 0.9; % a

% Apply the filter to x
y = Reverb(x,fa,Delay,Gain);
Espetro(y,Ta);
xlim([-fa/2 fa/2])
xlabel('Frequency (Hz)')
ylabel('Magnitude')
grid on;

%soundsc(x,fa)
soundsc(y,fa);

%% Numero medio de bits e Entropia

[Simbolos,Frequencias] = FreqOcurrencia(Mensagem);

% n_bits = ceil(log2(length(Simbolos)));
A = "00";
B = "01";
C = "10";

n_total_bits = length(Mensagem) * 2 % 40 bits

% + bits do que o necessario!
numero_medio = n_total_bits / length(Mensagem)

H = Entropia(Mensagem);

fprintf("Entropia: %d\n",H); % H ~= 1.49
