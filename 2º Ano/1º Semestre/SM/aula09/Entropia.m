function H = Entropia(Texto)
    Simbolos = unique(Texto);
    H = 0;
    for i = 1:length(Simbolos)
        Frequencia = count(Texto,convertCharsToStrings(Simbolos(i)))/length(Texto);
        H = H + Frequencia*log2(1/Frequencia); 
    end
end