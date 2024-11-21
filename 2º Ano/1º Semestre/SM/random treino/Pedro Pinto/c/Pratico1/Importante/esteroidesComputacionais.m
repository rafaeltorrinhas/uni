%% Grafico 3D

figure;
Ta = 0.1;

% 3D
t1 = 0:Ta:5;
t2 = 0:Ta:5;
[xx, yy] = meshgrid(t1,t2);

q = 2*sin(2*pi*(2*xx+yy));

% vista 3d
surf(xx,yy,q) % ou mesh(xx,yy,q)
shading interp

% vista de cima
figure;
pcolor(xx,yy,q);
shading interp

%% 𝑧(𝑡) – onda quadrada entre 0 e 1, de frequência 1 Hz, registada durante 5 seg.

Ta = 0.001;
Np = 1;
T = 5;
N = round(Np*T/Ta);

t = (0:N-1)*Ta;
f = 1;
% Translaçao: plot(t,(square(2*pi*1*t + pi)+1) / 2)
x = square(2*pi*f*t);

%plot(t,x), axis([0,5 -0.5,1.5]);
%figure;
[X,f] = Espetro(x, Ta);
xlim([-10 10])


%ReconstroiFreq(X,f);

%% 𝑧(𝑡) – onda triangular entre 0 e 1, de frequência 1 Hz, registada durante 5 seg.

Ta = 0.001;
Np = 5;
T = 1;
N = round(Np*T/Ta);

t = (0:N-1)*Ta;
f = 1;
%x = (sawtooth(2*pi*f*t, 1) + 1) / 2;
x = sawtooth(2*pi*f*t + pi/2, 1/2);
%plot(t,x), axis([0,5 -1.5,1.5]);
%figure;

%subplot(2,1,1);
[X,f] = Espetro(x, Ta);
xlim([-10 10])
%subplot(2,1,2);
%[x,t] = ReconstroiFreq(X,f);


%% Exemplo ( amostrado -> f -> (alteramos f) -> t )

% Carregar os dados do arquivo Guitar03.mat 
% x - amostras
% fa - frequencia de amostragem
load('Guitar03.mat')
sound(x,fa)

Ta = 1 / fa;
subplot(2,3,[1,2,3]);
[X, f] = Espetro(x,Ta);
xlim([-2000 2000])
xlabel('Frequency (Hz)')
ylabel('Magnitude')
grid on;

% f < 100 || f > 400
% Consideramos tabem as freq negativas! abs(f(i))

x1_filtrada = zeros(length(f),1);
f1_filtrada = zeros(length(f),1);

for i=1:length(f)
    if abs(f(i)) > 400 || abs(f(i)) < 100
        f1_filtrada(i,1) = f(i);
        x1_filtrada(i,1) = X(i,1);
    end
end

%[Y, t] 
subplot(2,3,4);
[x1_fil, t1] = ReconstroiFreq(x1_filtrada, f1_filtrada);

sound(real(x1_fil),fa)

%% Quantização de 4 bits

T_a = 0.002;
Np = 5;
T = 1;
N = round(Np*T/T_a);

t = (0:N-1)*T_a;
x = sin(2*pi*t);

max_x = max(x);
min_x = abs(min(x));

Amp = max_x + min_x;

% Quantização com 4 bits
n_bits = 4;

Npal = (2.^n_bits);
delta = Amp / Npal;
    
% Particoes
partion = -min_x+delta:delta:max_x-delta; % len Npal - 1;
% Entre as particoes
codebook = -min_x+delta/2:delta:max_x-delta/2; % len Npal;

[index,quants] = quantiz(x, partion, codebook);

subplot(2,2,[1 2]);
plot(0:length(quants)-1, quants, "r"),title("n_b="+n_bits);

subplot(2,2,3);
[Y, t_new] = ReconstroiSinal(quants, T_a);
plot(t,x,"b",t_new,Y, "r");

subplot(2,2,4);
[f, t] = Espetro(quants, T_a);


%% 𝑏𝑖𝑡 = 2, 3, 4 e 5 bits de quantização

T_a = 0.002;
Np = 5;
T = 1;
N = round(Np*T/T_a);

t = (0:N-1)*T_a;
x = sin(2*pi*t);


max_x = max(x);
min_x = abs(min(x));

Amp = max_x + min_x;

% Quantização com n bits
n_bits = [2, 3, 4, 5];
   
i = 1;
for n_bit = n_bits
    Npal = (2.^n_bit);
    delta = Amp / Npal;
    
    % Particoes
    partion = -min_x+delta:delta:max_x-delta; % len Npal - 1;
    % Entre as particoes
    codebook = -min_x+delta/2:delta:max_x-delta/2; % len Npal;
    
    [index,quants] = quantiz(x, partion, codebook);
    
    subplot(3,4,i);
    plot(0:length(quants)-1, quants, "r"),title("n_b="+n_bit);
    
    subplot(3,4,4+i);
    [Y, t_new] = ReconstroiSinal(quants, T_a);
    plot(t,x,"b",t_new,Y, "r");

    subplot(3,4,8+i);
    Espetro(quants, T_a);
    
    i = i + 1;
end

