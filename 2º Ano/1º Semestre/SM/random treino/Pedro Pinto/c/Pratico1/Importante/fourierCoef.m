function [ak, bk] = fourierCoef(Ta, T0, x, K)
    ak = zeros(1, K);
    bk = zeros(1, K);
    N = T0 / Ta;
    f = 1 / T0;

    for i = 1:N
        ak(1) = ak(1) + (2/N) * x(i); % a_0
    end

    for k = 2:K
        for n = 1:N
            ak(k) = ak(k) + 2/N*x(n) * cos(2*pi*(k-1)*f*n*Ta);
            bk(k) = bk(k) + 2/N*x(n) * sin(2*pi*(k-1)*f*n*Ta);
        end
    end
end