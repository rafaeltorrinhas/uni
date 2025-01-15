function shingles = getShingles(str, shingleSize)

    nShingles = length(str) - shingleSize + 1;

    shingles = {1, nShingles};

    for s = 1:nShingles
        shingles{s} = str(s:s + shingleSize - 1);
    end

end