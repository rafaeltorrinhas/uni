function [genKeys] = randKeys(N)
    % USAGE: randKeys(N,imin,imax)
    %        randKeys(N,imin,imax,chars)
    %   
    %       N = number of keys
    %       imin = minimum length of the keys
    %       imax = maximum length of the keys
    %       chars = array with characters
  
    
    chars = ['a':'z'];
    
    genKeys = cell(1,N);
    
    
    for i = 1:N
        a = randi([0,100]); 
        if a > 40
            key_size = 8;
        else 
            key_size = 5;
        end
        rand_idx = randi(length(chars), 1, key_size);
        genKeys{i} = chars(rand_idx);
    end

 
end

