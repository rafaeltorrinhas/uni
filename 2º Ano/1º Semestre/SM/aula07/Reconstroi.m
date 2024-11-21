function [x,t] = Reconstroi(X,f)
    N = length(X);
    x = ifft(ifftshift(X))*N;
    dummy = diff(f);
    Fa = N * dummy(1);
    Ta = 1/Fa;
    t = (0:N-1)*Ta;

    plot(t,x);
    xlabel("Tempo (s)");
    ylabel("Amplitude");
    grid;
end