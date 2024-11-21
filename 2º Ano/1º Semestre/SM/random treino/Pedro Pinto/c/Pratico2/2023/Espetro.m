function [X, f] = Espetro(x, Ta)
    
    N = length(x);
    fa = 1/Ta;

    % Calculando a Fast Fourier Transformer do sinal
    X = fftshift(fft(x)) .* (1/N);
    f = (0:N-1)*fa/N - fa/2; 
    

    stem(f,abs(X));
end