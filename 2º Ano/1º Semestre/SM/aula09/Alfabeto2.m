function [Simbolos, Frequencia] = Alfabeto2(Texto)
    
    Simbolos = unique(Texto);
    
    Frequencia = zeros(size(Simbolos));

    for i = 1:length(Simbolos)
        Frequencia(i) = sum(Texto == Simbolos(i))/length(Texto) * 100;
    end

    
end
