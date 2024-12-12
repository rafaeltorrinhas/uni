function [H, f] = respFreq(num,den,fa)
    
    M = 1024;

    [H, ~]=freqz(num,den,M,fa,'whole');
    H=abs(fftshift(H)); % modulo da resposta em frequencia
    f = (0:M-1)*fa/M - fa/2; 
    
end