function[x,t] = SomaFourier(Ta, f0, np, a, b)
    %   Ta : Período de amostragem, em segundos;
    %   f0 : Frequência do sinal composto, em Hz;
    %   np : Número de períodos a considerar para o sinal resultante;
    %   a : Vetor (Kx1) com os valores de ak da série;
    %   b : Vetor (Kx1) com os valores de bk da série.
    %   
    %   x : sinal resultante da soma dos termos de fourier  
    %   t : vetor de tempo correspondente a cada amostra do sinal
    
    T0 = 1/f0;                      % periodo fundamental do sinal composto
    t = 0:Ta:np*T0-Ta;
    L = length(a);                  % número de termos da serie de fourier
    x = 0;

    for k=1:L
        x = x + a(k)*cos(2*pi*(k)*f0*t) + b(k)*sin(2*pi*(k)*f0*t);

    end
end