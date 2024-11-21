wfunction [X, f] = Espetro(x, Ta) 
    % Inputs:
    % x - dimensão do vetor
    % Ta - Periodo de amostragem
    %
    % Outputs:
    % X - vetor da mesma dimensão de x, com coeficientes da dft de x(t)
    % f - vetor da mesma dimensão de x, com as frequências de cada componente
    % de X
    
    Fa = 1 / Ta;                % freq de amostragem
    N = length(x);              % numero de amostras
    
    % fft(x) calcula a dft de x : devolve um
    % vetor complexo que representa amplitude e
    % as fases das componentes das freqs do sinal

    X = fftshift(fft(x))/N;         % fft(x)/N normaliza a dft, para obter amplitude media de cada componente      

    % fftshift reorganiza os valores dos vetores de X para centralizar
    % as frequências em torno de zero

    % resolução frequencia (espaçamento entre amostras de frequência)
    delta_f = Fa / N;
    
    f = (-N/2:N/2-1)*(delta_f);       % vetor de frequencias
    %  cobre o intervalo de -Fa/2 a Fa/2 em passos de delta_f.
                                
                                % abs(x) vai calcular a magnitude de cada
                                % componente
    stem(f, abs(X));            % grafico do tipo haste das magnitudes de em função das frequencias
    xlabel("Frequência (Hz)")
    ylabel("Magnitude")
    title("Espetro")
    grid;

end