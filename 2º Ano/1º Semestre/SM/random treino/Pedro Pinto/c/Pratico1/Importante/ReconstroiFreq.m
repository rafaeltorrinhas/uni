function [x, t] = ReconstroiFreq(X, f)
    
    N = length(X);
    fa = max(f)*2;
    ta = 1/fa;

    % Calculando a Inverse Fast Fourier Transformer do sinal
    x = ifft(ifftshift(X))*N;
    t = (0:N-2)*ta; 

    plot(x);
    grid on;
end