function [x, t] = fourierFunc(Ta, f, Np, a, b)
    N = round(Np / (f*Ta));
    t = (0:N-1) * Ta;

    sumA = 0;
    sumB = 0;
    for k = 0:length(a)-1
        sumA = sumA + a(k+1) * cos(2*pi*k*f*t);
        sumB = sumB + b(k+1) * sin(2*pi*k*f*t);
    end
    x = sumA + sumB;
end