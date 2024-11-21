function p = potencia_associada(x, Ta, T)
    % nº amostras
    N = T/Ta; 

    % media da soma das potencias
    % (x1^2 + x2^2 + x3^2 + ...)/N
    p = x(1:N)*x(1:N)'/N;   

end