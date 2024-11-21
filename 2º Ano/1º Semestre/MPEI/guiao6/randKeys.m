function [genKeys] = randKeys(N,imin,imax,chars)
    % USAGE: randKeys(N,imin,imax)
    %        randKeys(N,imin,imax,chars)
    %   
    %       N = number of keys
    %       imin = minimum length of the keys
    %       imax = maximum length of the keys
    %       chars = array with characters
  

    if nargin < 4
        chars = ['a':'z' 'A':'Z'];
    end

    genKeys = cell(1,N);

    for i = 1:N
        key_size = randi([imin,imax]);
        rand_idx = randi(length(chars), 1, key_size);
        genKeys{i} = chars(rand_idx);
    end

 
end

