function tempo_espetro(y,Ta,F0,Np,T_f)
    T = 1/F0;
    N = T/Ta * Np;
    t = (0:N-1)*Ta;
    
    fa = 1 / Ta;
    
    % Calculando a Fast Fourier Transformer do sinal
    X = fftshift(fft(y)) .* (1/N);  % o fft(x) faz sem a divisao por N !
    f = (0:N-1)*fa/N - fa/2; % [-fa/2, fa/2] com N amostras
    
    if (T_f == 0)
       
        plot(t,y);
        xlabel("tempo (segundos)");
        ylabel("y");
        grid on


    elseif (T_f == 1)

        stem(f,abs(X));
        xlabel("frequencia (Hz)");
        ylabel("|C_n|");
        grid on


    elseif (T_f == 2)
        subplot(2,1,1);
        plot(t,y);
        xlabel("tempo (segundos)");
        ylabel("y");
        grid on

        subplot(2,1,2);
        stem(f,abs(X));
        xlabel("frequencia (Hz)");
        ylabel("|C_n|");
        grid on


    else
        disp("T_f devera ter valores de 0, 1 e 2");
    end

end

