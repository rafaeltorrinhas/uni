function ck = fourier_coef_ck(s)
    % FOURIER_COEF_CK Computes the complex Fourier series coefficients ck
    % Input:
    %   s - Input signal (vector of samples)
    % Output:
    %   ck - Complex Fourier coefficients (vector)
    
    N = length(s);
    ck = fft(s) / N; 
end

