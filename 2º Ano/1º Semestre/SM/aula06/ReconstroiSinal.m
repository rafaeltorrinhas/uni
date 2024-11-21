function [y, t] = ReconstroiSinal(x, Ta)
    N = length(x);
    y = zeros(100*N,1);
    fa = 1/Ta;
    fs = 100*fa;
    t = (0 : (length(y)-1))'*(1/fs);
    for n=1:N
        y = y + x(n)*sinc(fa*(t-(n-1)*Ta));
    end

end