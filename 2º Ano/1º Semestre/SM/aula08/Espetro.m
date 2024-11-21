function [X,f] = Espetro(x,Ta)   
    Fa = 1/Ta;
    N = length(x);
    X=fftshift(fft(x))/N;

    if rem(N,2)==0
        f=(-N/2:N/2-1)*(Fa/N);
    else
        f=(-(N-1)/2:(N-1)/2*(Fa/N));
    end

    
    stem(f, abs(X));
    xlabel("Frequência (Hz)")
    ylabel("Magnitude")
    title("Espetro")
    grid;
end