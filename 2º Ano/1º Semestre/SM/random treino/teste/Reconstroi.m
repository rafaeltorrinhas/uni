function [x,t] = Reconstroi(X,f)
    %   
    %   X : vetor com os coefs da DFT de um sinal no dominio da frequencia
    %   f : vetor com as frequencias correspondentes a cada componente de X
    %
    %   x : vetor com as amostras do sinal reconstruido no dominio do tempo
    %   t : vetor de tempo associado a x

    N = length(X);                      % numero de amostras

    % ifftshift(x) descentraliza o vetor x, ou seja descloca as freqs para
    % a configuração original
    
    % ifft(ifftshift(x)) calcula a transformada inversa de fourier para retornar o sinal do dominio do tempo.
    % ifft toma o vetor de frequencia X e reconstroi o sinal temporal,
    % retorna um vetor complexo

    x = ifft(ifftshift(X))*N;     % multiplica se por N para restaurar a escala original do sinal      
 
    fa = max(f)*2;
    Ta = 1/fa;
    t = (0:N-1)*Ta;

    plot(t,abs(x));
    xlabel("Tempo (s)");
    ylabel("Amplitude");
    title("Sinal")
    grid;
end
