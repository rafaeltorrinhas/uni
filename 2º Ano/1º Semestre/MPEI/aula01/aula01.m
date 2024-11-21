
%% a)
% v1 = 4:2:100 
inicio = 4
incr = 2
fim = 100
v1 = inicio:incr:fim

%% b)
% v2 = 5:-1:-5
inicio = 5
incr = -1
fim = -5
v2 = inicio:incr:fim

%% c)
n = 100
inicio = 0
fim = 1
incr = (fim-inicio)/(n-1)
v3 = inicio:incr:fim

%% d)
B = rand(20,30);
C = B(10:15,9:12);
hist(B(:),100)

%% e)

inicio = -pi
fim = pi
incr = pi/15
v4 = inicio:incr:fim

%% f)

plot(v4, sin(4*pi*v4), 'r+-.')

