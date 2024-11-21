function [S] = taylorsin(x,N)
% CALCULO DE SÉRIE DE TAYLOR FUNÇÃO SENO
S= 0;
for n = 1:N
    S = S + ((x.^n)/factorial(n))*sin((n.*pi)/2);
end

end

