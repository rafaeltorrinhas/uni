function[ak, bk] = CoefFourier(Ta,T0,x,k)
    %   
    %   Ta : Periodo de amostragem
    %   T0 : Período do sinal
    %   x : vetor de amostras do sinal
    %   k : número de termos a considerar
    %
    %   vetor de coefs ak (para termos de cosseno)
    %   vetor de coefs bk (para termos de seno)
    
    ak = zeros(1, k);
    bk = zeros(1, k);
    
    N = T0/Ta;                                                  % numero de amostras
    f = 1/T0;                                                   % frequencia
    
    for n = 1:N                                                 % somatório para a0
        ak(1) = ak(1) + (1/N)*x(n); 
    end
    
    for k1 = 2:k
        for n=1:N
            % como os indices começam em um e o somatorio começa em 0 
            % temos de usar (k-1) dentro das trignométricas
            ak(k1) = ak(k1) + 2/N * x(n) * cos(2*pi*(k1-1)*f*n*Ta); 
            bk(k1) = bk(k1) + 2/N * x(n) * sin(2*pi*(k1-1)*f*n*Ta);
        end
    end
end