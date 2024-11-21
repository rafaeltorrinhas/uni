function [x,t] = fourier_func (Ta,f,Np,a,b)
  N = round(Np/(f*Ta));
  t = (0:N-1)*Ta;
  
  sumA = 0;
  sumB = 0;
  for k = 1 : length(a)
    sumA = sumA + a(k) * cos(2 * pi * (k-1) * f * t);
    sumB = sumB + b(k) * sin(2 * pi * (k-1) * f * t);
  end
  
  x = sumA + sumB;
  
end
