function [Simbolos, Frequencia] = FreqOcurrencia(Texto)
    n = 1;
    Simbolos(1) = Texto(1);
    Ocurrencia(1) = 1;
    for k=2:length(Texto)
        if (sum(Simbolos == Texto(k)) == 0)
            n = n + 1;
            Simbolos(n) = Texto(k);
            Ocurrencia(n) = 1;
        else
            indice = Simbolos == Texto(k);
            Ocurrencia(indice) = Ocurrencia(indice) + 1;
        end
    end

    Frequencia = Ocurrencia/k;
   
    
end