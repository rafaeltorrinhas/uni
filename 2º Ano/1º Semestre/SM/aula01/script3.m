
t = -4:0.01:4;
g = (1/sqrt(2*pi)).*(t.^2).*exp(-(t.^2)/2);
B = g.*sin(6*pi*t);
axis([-8 0 -0.5 0.8])

plot(t,g,'r')
hold on
plot(t,B,'b')
hold off

subplot(2,2,1)
plot(t,g,'r')
subplot(2,2,2)
plot(t,B,'b')
subplot(2,2,3)
plot(t,g,'r',t,B,'b')