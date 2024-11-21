x = linspace(-1,1,51);
y = linspace(-1,1,51);
[XX,YY] = meshgrid(x,y);

f=cos(4*pi*(XX + YY)).*exp(-abs(XX+YY));

surf(x,y,f), axis tight
