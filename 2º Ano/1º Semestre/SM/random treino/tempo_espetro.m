function [] = tempo_espetro(y, Ta, Fo, Np, T_F)
    T = 1/Fo;
    N = round(Np*T/Ta);
    t = (0:N-1)*Ta;

    %calcular
    N1=length(y);
    Y=fftshift(fft(y))/N1;

    df=Fo/N1;
    f=(0:(N1-1))*df-Fo/2;

    if T_F == 0
        plot(t, y);
        xlabel("Tempo (s)");
        ylabel("y");
        legend("Sinal Y")
        grid on;
    elseif T_F == 1
        plot(f, abs(Y))
        xlabel("Frequência (Hz)")
        ylabel("Magnitude")
        grid on;
    elseif T_F == 2
        figure(1);
        plot(t, y);
        xlabel("Tempo (s)");
        ylabel("y");
        legend("Sinal Y")
        grid on;

        figure(2);
        plot(f, abs(Y))
        xlabel("Frequência (Hz)")
        ylabel("Magnitude")
        grid on;
    else
        disp("T_F deverá ter valores 0, 1 e 2")
    end
end

