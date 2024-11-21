x = linspace(0,2*pi);

test1 = taylorsin(x,2);
test2 = taylorsin(x,10);
test3 = taylorsin(x,20);

plot(x,test1,'r')
hold on
plot(x,test2,'g')
plot(x,test3,'b')
hold off