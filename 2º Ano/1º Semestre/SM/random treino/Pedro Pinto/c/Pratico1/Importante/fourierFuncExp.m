function [x, t] = fourierFuncExp(Ta, F0, Np, ck)
    
    T0 = 1/F0;
    
    N = round(T0/Ta*Np);
    t = (0:N-1)*Ta;
    
    Kc = length(ck);

    sum = 0;
    
    k_val = -floor(Kc/2);
    for k = 1:Kc
        disp(k_val)
        sum = sum + ck(k) * exp(j * 2 * pi * k_val * F0 * t);
        k_val = k_val + 1;
    end

    x = sum;

end