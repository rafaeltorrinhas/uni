function [y, t] = ReconstroiSinal(x, Ta)
    %
    %   x : vetor com amostras dos sinais
    %   Ta : periodo de amostragem
    %
    %   y : sinal reconstruido 
    %   t : instantes de tempo correspondentes ás amostras

    N = length(x);          % número de amostras
    Fa = 1/Ta;              % frequencia de amostragem
    Fs = 100 * Fa;          % frequencia do sinal
    
    y = zeros(100*N,1);     
    
    t = (0 : (length(y)-1))' * (1/Fs);      %intervalo de zero ao ultimo ponto de y com passo 1/Fs

    for n = 1:N
        y = y + x(n)*sinc(Fa*(t-(n-1)*Ta));
    end
end