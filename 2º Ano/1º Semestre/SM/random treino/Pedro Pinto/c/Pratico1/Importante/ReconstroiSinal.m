function [Y, t] = ReconstroiSinal(x, T_a)

    N = length(x); % numero de amostras de entrada
    
    f_a = 1 / T_a;
    f_s = 100 * f_a;
    T_s = 1 / f_s; % novo t_s

    t = (0:N*100-1)*T_s;   % aumentamos o numero de amostras

    Y = zeros(1, N*100);

    for n = 0:N-1

        Y = Y + x(n+1).*sinc(f_a.*(t-n.*T_a));
    
    end
     

end