function hc = hash_function_shingle(elem,hf,R,p)
    elem = char(elem);
    ascii_codes = double(elem);
    r = R(hf,:);
 

    hc = mod(ascii_codes * r', p);
end