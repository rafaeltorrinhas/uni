function [X,F] = Espetro(x,ta)
%Espetro de amplitudes
%   X= numero de valores da função ta intervalo de tempo 
N=length(x);

X=fft(x)/N;
fa=1/ta

F=(0:N-1).*(fa/N)-fa/2;
%figure(1)
%subplot(2,1,1);
X=fftshift(X);
stem(F,abs(X));
%subplot(2,1,2); 
%stem(F,abs(fftshift(X)));

end

