function P = potencia(x,Ta,T)
    % Calcula, com base na fórmula da potência, a potência média de um
    % período
    % x - sinal sinusoidal
    % Ta - Passo
    % Periodo do sinal
    %
    % P - média da potência do sinal

    samples = T/Ta;     % Representa o número de samples num periodo do 
                        % sinal (50 neste caso)
    x = x(:,1:samples); % Extraimos todas as samples de x, que correspondem
                        % a um peíodo inteiro
    P = x*x'/samples;   % Soma os quadrados de todas as samples. Divide -se 
                        % pelo número de samples e devolve nas a média da 
                        % potencia em x
end