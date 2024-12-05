function Set = getShingles(file, ks)
    dicio2 = readcell(file); 
    Set = cell(length(dicio2), 1); 

    for i = 1:length(dicio2(:, 1))
        word = dicio2{i, 1}; 
        if ischar(word) || isstring(word) 
            word = char(word); 
            shingles_list = cell(1, length(word) - ks + 1); 
            for j = 1:length(word) - ks + 1
                shingles_list{j} = word(j:j + ks - 1); 
            end
            Set{i} = shingles_list; 
        else
            Set{i} = {}; 
        end
    end
end
