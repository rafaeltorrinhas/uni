
f0 = 2.5;
f1 = 3.5;
F0 = gcd(10*f0, 10*f1)/10;
T = 1/F0;

Ta = 0.01;
Np = 20;

N = round(Np*T/Ta);

t = (0:N-1)*Ta;

y = 8*cos(5*pi*t + pi/4) + 6*sin(7*pi*t + pi/5);

tempo_espetro(y,Ta,F0,Np,2)