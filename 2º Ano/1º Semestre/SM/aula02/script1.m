w = linspace(0,2*pi,200);
f = sin(4*w).*exp(i*w);
g = sin(8*w).*exp(i*w);

x1 = real(f);
y1 = imag(f);
x2 = real(g);
y2 = imag(g);

subplot(2,1,1),plot(x1,y1,'r'),legend("f(x)")
subplot(2,1,2),plot(x2,y2),legend("g(x)")

