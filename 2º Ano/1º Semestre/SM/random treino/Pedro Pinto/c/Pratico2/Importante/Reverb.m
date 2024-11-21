
function y = Reverb(x,fa,Delay,Gain)
Ta = 1/fa;
D = round(Delay/Ta); % atraso de Delay (ms)

num=1;
den=[1 zeros(1,D-1) Gain];

y = filter(num, den, x);

end