function [t,xt] = fourier_func_ck(Ta, f0, Np, ck)
    
    T0 = 1/f0;
    t = (-Np * T0/2 : Ta : Np * T0/2 - Ta);
    K=floor(length(ck)/2);
    k = -K:K;
    xt = sum(ck.'.*exp(1j*2*pi*k'*f0*t));
    xt = real(xt);
end