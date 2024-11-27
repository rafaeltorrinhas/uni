function NumBits = numBits(Texto)
    Simbolos = unique(Texto);
    Frequencia = dictionary;
    for i = 1:length(Simbolos)
        Frequencia(Simbolos(i)) = count(Texto,convertCharsToStrings(Simbolos(i)))/length(Texto);
    end
    
    keys = Frequencia.keys;
    values = Frequencia.values;
    [~, sortIdx] = sort(values,"descend");
    sortedKeys = keys(sortIdx);
    lettertoBits = dictionary;
    for i= 1:length(sortedKeys)
       string = "";
       for j = 1:i
           string = append(string, "1");
       end
       string = append(string, "0");
       lettertoBits(sortedKeys(i)) = string;
    end
    NumBits = "";

    for i = 1:length(Texto)
        NumBits = append(NumBits, lettertoBits(Texto(i)));
    end

end